package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(aeh_students aeh_students){
        String sql = "INSERT INTO aeh_students VALUES(?,?)";
        jdbcTemplate.update(sql, new Object []{
                aeh_students.getName(),
                aeh_students.getLastname()
                });
    }

    public List<Map<String, Object>> showResult(){
        String sql = "SELECT * FROM aeh_students";
        return jdbcTemplate.queryForList(sql);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void doInit(){
    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
        add(new aeh_students("Jakub", "Nowak"));

        //String sql = "CREATE TABLE aeh_students (name varchar(255), lastname varchar(255));";
        //getJdbcTemplate().update(sql);
        //String sql1 = "CREATE TABLE test_aeh_students (name varchar(255), lastname varchar(255));";
        //getJdbcTemplate().update(sql1);
    }



}
