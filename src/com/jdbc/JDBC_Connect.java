package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect {
    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","805026");

            Statement smt = con.createStatement();
            smt.executeUpdate("create table emp(eno number, ename varchar(20),esal number)");

            System.out.println("Table Created successfully...");
            con.close();


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);

        }
    }
}
