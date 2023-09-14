package com.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProprertyFileRead {
public static void main(String[] args) throws IOException {
	FileInputStream fis= new FileInputStream(".//src/test/resources/Commondata.propreties");
	Properties p=new Properties();
	p.load(fis);
	String URL = p.getProperty("url");
	String BROWSER = p.getProperty("browser");
	String USERNAME = p.getProperty("username");
	String PASSWORD = p.getProperty("password");
	System.out.println(URL);
	System.out.println(BROWSER);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
}
}
