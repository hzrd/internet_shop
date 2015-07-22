/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Users;
import com.web.mavenproject6.service.UserServiceImp;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    
     
    @RequestMapping(value="/signup")
    public ModelAndView signUpUser(HttpServletRequest request,HttpServletResponse response,Map<String, Object> model) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());

        Users u = new Users();
        u.setUsername("admin");
        u.setPassword("password");
        userServiceImp.add(u);
        return new ModelAndView("thy/home");    
    }
    
    @RequestMapping("/admin/apanel")
    public String home(Map<String, Object> model) {
            model.put("users", userServiceImp.list());
            return "thy/adminPanel";
    }
   
   @RequestMapping(value="/user/add",method =   RequestMethod.POST)
   public void addUser(@RequestParam("login") String login, 
                               @RequestParam("password") String pass,HttpServletResponse response,ModelMap map) throws IOException{   
       Users u = new Users();
       u.setUsername(login);
       u.setPassword(pass);
       userServiceImp.add(u);      
       response.sendRedirect("/../admin/apanel");
      // return "redirect:admin/apanel";
   }
    
    @RequestMapping(value="/user/del/{userId}")
    public void deleteUser(@PathVariable("userId") String id,HttpServletRequest request,HttpServletResponse response,ModelMap map) throws IOException{
       userServiceImp.delete((long)Integer.parseInt(id));
       map.addAttribute("id", id);
           response.sendRedirect("/../admin/apanel");
     //   return "redirect:admin/apanel";
    }

   
}
