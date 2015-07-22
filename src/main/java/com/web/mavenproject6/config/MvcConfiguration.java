package com.web.mavenproject6.config;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@PropertySource("resources/application.properties")
@ComponentScan(basePackages="com.web.mavenproject6")
@EnableWebMvc
@Import({ AppSecurityConfig.class })
public class MvcConfiguration extends WebMvcConfigurerAdapter{

    
      
        @Bean
        public TemplateResolver templateResolver(){
            ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
            templateResolver.setPrefix("/WEB-INF/views/");
            templateResolver.setSuffix(".html");
            templateResolver.setTemplateMode("HTML5");
            return templateResolver;
        }

        @Bean
        public SpringTemplateEngine templateEngine(){
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            return templateEngine;
        }

        @Bean
        public ViewResolver viewResolver(){
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver() ;
            viewResolver.setTemplateEngine(templateEngine());
            viewResolver.setOrder(1);
            viewResolver.setViewNames(new String[]{"thy/*"});
            return viewResolver;
        }
    
        @Bean
        public ViewResolver viewResolverJSP() {
            System.out.println("Inside View Resolver...");
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setViewClass(JstlView.class);
            viewResolver.setPrefix("/WEB-INF/views/");
            viewResolver.setSuffix(".jsp");
            viewResolver.setViewNames(new String[]{"jsp/*"});
            return viewResolver;
        }
        
     
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

        
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
           PropertyConfigurator.configure("resources/log4j.properties");
           return new PropertySourcesPlaceholderConfigurer();
        }
	
        
}
