/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Wallet;
import com.web.mavenproject6.repositories.WalletRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Никита
 */
@Service
public class WalletServiceImp implements WalletService
{
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void add(Wallet wallet) {
        walletRepository.save(wallet);
    }
    
    @Override
    public long count() {
        return walletRepository.count();
    }

    @Override
    public Wallet findOne(Long id) {
        return walletRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
         walletRepository.delete(id);
    }
    
    public List<Wallet> list(){
        return (List<Wallet>) walletRepository.findAll();
    }
}
