package com.Trid.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

	public class JavaUtility {
		/**
		 * This method is used to get random numbers
		 * @author Prajwal
		 * @return
		 */
		public int getRandomNo() {
			Random ran=new Random();
			int random=ran.nextInt(666);
			return random;
		}
		/**
		 * @author Prajwal
		 * @return
		 */
		public String getSystemDate() {
			Date d=new Date();
			String date = d.toString();
			return date;
		}
		/**
		 * This method is used to get system date in format
		 * @author Prajwal 
		 * @return
		 */
		public String getSystemDateInFormat() {
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
			Date date=new Date();
			String systemDateFormat = dateformat.format(date);
			return systemDateFormat;
		}
}