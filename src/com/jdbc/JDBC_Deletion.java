package com.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBC_Deletion {
    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "805026");

            Statement smt = con.createStatement();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Enter Deletion Emp Id: ");
                int eno = Integer.parseInt(br.readLine());


                int count = smt.executeUpdate("delete from emp where eno = "+eno);

                if (count == 1)
                    System.out.println(count+ " Row Deleted");
                else
                    System.out.println("No Record Deleted");

                System.out.println("Do You Want to Delete More Records...[Yes/No]");

                String ch = br.readLine();

                if (ch.equalsIgnoreCase("no"))
                    break;
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e);

        }
    }
}
