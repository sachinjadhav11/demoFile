package com.project;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionLoader
{
    public static Connection getConnection()
    {
    	Connection con=null;
    	
    	try
    	{
	
    Properties p= new Properties();
    		
    FileInputStream f = new FileInputStream("D:\\Tekvision_Assignment\\demoFile\\src\\main\\webapp\\WEB-INF\\db.properties");	
    	
    p.load(f);
    	
     String driver= p.getProperty("Driver");
     String url= p.getProperty("url");
     String username=p.getProperty("username");
     String password = p.getProperty("password");
     
     Class.forName(driver);
     
     con=DriverManager.getConnection(url, username, password);
    		
		} 
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	
    	return con;
    }
}
