package com.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Insertion {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "805026");

            PreparedStatement psmt = con.prepareStatement("Insert into emp values(?,?,?)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Enter Emp Id: ");
                int eno = Integer.parseInt(br.readLine());

                System.out.println("Enter Emp Name: ");
                String ename = br.readLine();

                System.out.println("Enter Emp Salary: ");
                double sal = Double.parseDouble(br.readLine());

                psmt.setInt(1, eno);
                psmt.setString(2, ename);
                psmt.setDouble(3, sal);

                int count = psmt.executeUpdate();

                if (count > 0)
                    System.out.println(count + "Record inserted");
                else
                    System.out.println("No Record Inserted");

                System.out.println("Do You Want to More Records...[Yes/No]");

                String ch = br.readLine();

                if (ch.equalsIgnoreCase("no"))
                break;
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e);

        }
    }
}
