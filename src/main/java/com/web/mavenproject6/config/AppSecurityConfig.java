package com.web.mavenproject6.config;

import com.web.mavenproject6.config.CustomAuthenticationProvider;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
@Configuration
@EnableWebMvcSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
        @Autowired
	DataSource dataSource;
        
        @Autowired
        private AuthenticationProvider CustomAuthenticationProvider;
        
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {                 
//               auth
//        .inMemoryAuthentication()
//            .withUser("user").password("password").roles("USER").and()
//            .withUser("admin").password("password").roles("USER", "ADMIN");
             auth.authenticationProvider(CustomAuthenticationProvider);
//                     .jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery(
//			"select username,password, enabled from users where username=?")
//		.authoritiesByUsernameQuery(
//			"select username, role from user_roles where username=?");
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
            http
            .authorizeRequests()                                                                
                .antMatchers("/","/login","/vkapi**").permitAll()                  
                .antMatchers("/admin/**").hasRole("ADMIN")                                      
                .anyRequest().authenticated() 
            .and()
                .formLogin()
                .loginPage("/login")
            .permitAll();
                    
//                    .failureUrl("/login?error")
//                .usernameParameter("username").passwordParameter("password")
//            .and()
//                .logout().logoutSuccessUrl("/login?logout")
//            .and()
//                .exceptionHandling().accessDeniedPage("/403")
//            .and()
//                .csrf();
	}
	
}
