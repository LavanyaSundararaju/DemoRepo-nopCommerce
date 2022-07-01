package com.nopCommerceDemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	
	Properties pro;
	public ReadConfig() 
	{
		File src=new File("./Configuration/config.properties");
		try
		{
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
		
		
	}
	
	public String getUrl()
	{
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getEmail()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
		

}
