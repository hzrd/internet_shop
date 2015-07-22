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
    private Product product;
    private int productCount;
    
    public Bucket(long id, long sessionNumber, Product product, int productCount)
    {
        this.id = id;
        this.sessionNumber = sessionNumber;
        this.product = product;
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

    @Column(name = "product", nullable = false, columnDefinition = "")
    public Product getProduct() 
    {
        return product;
    }

    public void setProduct(Product product) 
    {
        this.product = product;
    }
    
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
