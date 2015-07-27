/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Users;
import com.web.mavenproject6.service.UserServiceImp;
import com.web.mavenproject6.validators.UsersValidator;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Aleks
 */
@Controller
public class UserController {
    
    @Autowired
    private Environment env;
    
    @Autowired
    UserServiceImp userServiceImp;
    
    @Autowired
    private UsersValidator usersValidator;
 
//    @InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(usersValidator);
//	}
       
    @RequestMapping(value="/signup")
    public ModelAndView signUpUser(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());

        Users u = new Users();
        u.setUsername("admin");
        u.setPassword("password");
        userServiceImp.add(u);
        return new ModelAndView("thy/signup");    
    }
    
    @RequestMapping(value="/admin/apanel",method =   RequestMethod.GET)
    public String home(Map<String, Object> model,Locale locale) {
            model.put("users", userServiceImp.list());
            model.put("user", new Users());
          
            return "thy/adminPanel";
    }
   
   @RequestMapping(value="/admin/apanel",method =   RequestMethod.POST)
   public ModelAndView addUser(@ModelAttribute("user") @Valid Users user,BindingResult result,
			final RedirectAttributes redirectAttributes,Map<String, Object> model,Locale locale) { 
      
            usersValidator.validate(user, result);
            if (result.hasErrors()){
                model.put("users", userServiceImp.list());
                return new ModelAndView("thy/adminPanel");
            }
		
		ModelAndView mav = new ModelAndView();
                
		userServiceImp.add(user);
		mav.setViewName("thy/adminPanel");
		return mav;		
   }
    
    @RequestMapping(value="/user/del/{userId}")
    public void deleteUser(@PathVariable("userId") String id,HttpServletRequest request,HttpServletResponse response,ModelMap map) throws IOException{
       userServiceImp.delete((long)Integer.parseInt(id));
       map.addAttribute("id", id);
           response.sendRedirect("/../admin/apanel");
     //   return "redirect:admin/apanel";
    }

   
}
