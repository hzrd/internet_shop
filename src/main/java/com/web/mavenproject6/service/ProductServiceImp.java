/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Product;
import com.web.mavenproject6.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Никита
 */
@Service
public class ProductServiceImp implements ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }
    
    @Override
    public long count() 
    {
        return productRepository.count();
    }

    @Override
    public Product findOne(Long id) 
    {
        return productRepository.findOne(id);
    }

    @Override
    public void delete(Long id) 
    {
         productRepository.delete(id);
    }
    
    /**
     *
     * @return
     */
    public List<Product> list()
    {
        return (List<Product>) productRepository.findAll();
    }
}
