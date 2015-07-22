/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Никита
 */
@Entity
@Table(name="wallets")
public class Wallet implements Serializable
{
    private long id;
    private String type;
    private String number;
    private User user;
    
    public Wallet(long id, String type, String number,User user)
    {
        this.id = id;
        this.type = type;
        this.number = number;
        this.user = user;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "number", nullable = false, length = 20)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    @Column(name = "user", nullable = false, columnDefinition = "")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
