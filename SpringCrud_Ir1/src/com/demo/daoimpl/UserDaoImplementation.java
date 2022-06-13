/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.daoimpl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.dao.BaseDAO;
import com.demo.dao.UserDAO;
import com.demo.model.Student;
import com.demo.rm.UserRowMapper;

/**
 *
 * @author irfan
 */
@Repository
public class UserDaoImplementation extends BaseDAO implements UserDAO {

    @Override
    public void save(Student student) {
    	
        String query = "INSERT INTO "
                + "             Student ( "
        		+"				studentId"
                + "             ,name "
                + "             ,password "
                + "             ,mail "
                +"              ,mob "
                + " ) VALUES( "
                + "             :studentId "
                + "            ,:name "
                + "            ,:password "
                + "            ,:mail "
                + "            ,:mob " 
                + " )";
          Map m=new HashMap();
          m.put("studentId",student.getStudentId());
          m.put("name",student.getName());
          m.put("password",student.getPassword());
          m.put("mail",student.getMail());
          m.put("mob",student.getMob());
          super.getNamedParameterJdbcTemplate().update(query,m);
          
        
    }

    @Override
    public void update(Student student) {
    	System.out.println("inside daoimpl");
        String str="UPDATE "
                +"              student "
                +"   SET "
                +"               name=:name "
                +"              ,password=:password "
                +"              ,mail=:mail "
                +"              ,mob=:mob "
                +" WHERE "
                +"              studentId=:studentId ";
        Map m=new HashMap();
        m.put("studentId",student.getStudentId());
        m.put("name",student.getName());
        m.put("password",student.getPassword());
        m.put("mail",student.getMail());
        m.put("mob",student.getMob());
        getNamedParameterJdbcTemplate().update(str, m);
        
    }

    @Override
    public void delete(Integer studentId) {
        String query="DELETE FROM student WHERE studentId=:studentId";
        Map m=new HashMap();
        m.put("studentId",studentId);
        getNamedParameterJdbcTemplate().update(query, m);
    }

    @Override
    public List<Student> findAll() {
        
        String sql="SELECT "
                +"          studentId "
                +"          ,name "
                +"          ,password "
                +"          ,mail "
                +"          ,mob "
                +" FROM "
                +"           student";
         return getNamedParameterJdbcTemplate().query(sql,new UserRowMapper());
        
        
    }

    @Override
    public Student findById(Integer studentId) {
       String query="SELECT "
               + "              studentId "
               +"               ,name "
               +"               ,password "
               +"               ,mail "
               +"               ,mob "
               +" FROM "
               +"                student "
               +" WHERE "
               +"              studentId=:studentId ";
       Map m=new HashMap();
       m.put("studentId",studentId);
       return getNamedParameterJdbcTemplate().queryForObject(query, m, new UserRowMapper());
    }

    @Override
    public List<Student> findByProperty(Integer property, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
