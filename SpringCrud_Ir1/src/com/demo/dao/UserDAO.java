/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.dao;


import java.util.List;

import com.demo.model.Student;

/**
 *
 * @author irfan
 */
public interface UserDAO {
    public void save(Student student);
    public void update(Student student );
    public void delete(Integer id);
    public List<Student> findAll();
    public Student findById(Integer id);
    public List<Student> findByProperty(Integer property,Object value);
            
    
}
