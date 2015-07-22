/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
/**
 *
 * @author Aleks
 */

@Entity
@Table(name="users")
public class Users implements Serializable
{
    
    private long id;
    private String username;  
    private String password;  
    private String role;  
    private boolean enabled;
    

    public Users(long id, String username, String password, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    
    }

    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "role", nullable = false, length = 20)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
       
    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled +'}';
    }

   
   
}