package com.spring.springrestcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	    String jdbcurl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
    		String jdbcuser="springlearn";
    		String jdbcpassword="springlearn";
    		
    		try {
				Connection conn = DriverManager.getConnection(jdbcurl, jdbcuser, jdbcpassword);
			    System.out.println("connect");
			    conn.close();
    		
    		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    }
}
