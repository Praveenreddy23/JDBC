package com.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBC_Updation {
    public static void main(String[] args) {
        String value ; int eid; double esal;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "805026");

            Statement smt = con.createStatement();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Enter Emp Id: ");
                value = br.readLine();
                eid = Integer.parseInt(value);

                System.out.println("Enter Emp New Salary: ");
                value = br.readLine();
                esal= Double.parseDouble(value);


                int count = smt.executeUpdate("update emp set esal ="+esal+" where eno = "+eid);

                if (count > 0)
                    System.out.println(count+ " Row Record Updated");
                else
                    System.out.println("No Record Found");

            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e);

        }
    }
}
