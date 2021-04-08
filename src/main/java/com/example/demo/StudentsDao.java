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
    private  String arg = "test_aeh_students";
    @Autowired
    public StudentsDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(test_aeh_students test_aeh_students){
        String sql = "INSERT INTO test_aeh_students VALUES(?,?)";
        jdbcTemplate.update(sql, new Object []{
                test_aeh_students.getName(),
                test_aeh_students.getLastname()
                });
    }
    public List<Map<String, Object>> showResult() {
        String sql = "SELECT * FROM " + arg;
        return jdbcTemplate.queryForList(sql);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doInit(){
        add(new test_aeh_students("Jakub", "Nowak"));

        //String sql = "CREATE TABLE aeh_students (name varchar(255), lastname varchar(255));";
        //getJdbcTemplate().update(sql);
        //String sql1 = "CREATE TABLE test_aeh_students (name varchar(255), lastname varchar(255));";
        //getJdbcTemplate().update(sql1);
    }



}
