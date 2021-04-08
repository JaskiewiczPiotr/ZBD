package com.example.demo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SeleniumDatabaseTesting {
    static Connection con = null;
    private static Statement stmt;
    public static String DB_URL = "jdbc:postgresql://localhost:5432/students";
    public static String DB_USER = "postgres";
    public static String DB_PASSWORD = "!Query";
    @BeforeTest
    public void setUp() throws Exception {
        try{
            String dbClass = "org.postgresql.Driver";
            Class.forName(dbClass).newInstance();
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void test() {
        try{
            String query = "select * from test_aeh_students";
            ResultSet res = stmt.executeQuery(query);
            while (res.next())
            {
                System.out.print(res.getString(1));
                System.out.print(" " + res.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }

    @Test
    public void test1() {
        try{
            String query = "select * from test_aeh_students";
            ResultSet res = stmt.executeQuery(query);
            while (res.next())
            {
                System.out.print(res.getString(1));
                System.out.print(" " + res.getString(2));
                System.out.print(" " + res.getString(3));
            }
        }


        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try{
            String query = "select * from example";
            ResultSet res = stmt.executeQuery(query);
            while (res.next())
            {
                System.out.print(res.getString(1));
                System.out.print(" " + res.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}

