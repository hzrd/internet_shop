/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Bucket;
import com.web.mavenproject6.repositories.BucketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Никита
 */
@Service
public class BucketServiceImp implements BucketService
{
    @Autowired
    private BucketRepository productRepository;

    @Override
    public void add(Bucket product) {
        productRepository.save(product);
    }
    
    @Override
    public long count() 
    {
        return productRepository.count();
    }

    @Override
    public Bucket findOne(Long id) 
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
    public List<Bucket> list()
    {
        return (List<Bucket>) productRepository.findAll();
    }
}
