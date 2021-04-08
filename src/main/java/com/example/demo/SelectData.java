package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SelectData {
   private StudentsDao studentsDao;

    @Autowired
   public SelectData (StudentsDao studentsDao){
       this.studentsDao = studentsDao;
       System.out.println(studentsDao.showResult());
   }

}
