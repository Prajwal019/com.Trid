package com.Trid.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to fetch the data from property file
	 * @author Prajwal
	 * @param key
	 * @return
	 * @throws IOException
	 */
		public String readDataFromPropertyFile(String key) throws IOException
		{
			FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
			Properties p=new Properties();
			p.load(fis);
			String value=p.getProperty(key);
			return value;
			}
		}
