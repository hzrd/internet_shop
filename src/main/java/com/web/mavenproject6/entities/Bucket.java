/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Никита
 */
@Entity
@Table(name="buckets")
public class Bucket implements Serializable
{
    private long id;
    private long sessionNumber;
    //private Set<Product> product = new HashSet<Product>(0); 
    private int productCount;
    
    public Bucket(long id, long sessionNumber, int productCount)
    {
        this.id = id;
        this.sessionNumber = sessionNumber;
        this.productCount = productCount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    @Column(name = "sessionNumber", nullable = false)
    public long getSessionNumber() 
    {
        return sessionNumber;
    }

    public void setSessionNumber(long sessionNumber) 
    {
        this.sessionNumber = sessionNumber;
    }
/*
    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
    */

    
    @Column(name = "count", nullable = false)
    public int getProductCount() 
    {
        return productCount;
    }

    public void setProductCount(int productCount) 
    {
        this.productCount = productCount;
    }
}
