/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.repositories;

import com.web.mavenproject6.entities.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Aleks
 */

public interface UserRepository extends CrudRepository<Users, Long> {
    
}