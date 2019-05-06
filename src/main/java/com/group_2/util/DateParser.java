package com.group_2.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParser {

	public static Date toDate(String date){
		java.sql.Date realDate;
		java.util.Date utilDate;
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			utilDate = formatter.parse(date);
			realDate = new Date(utilDate.getTime());
			return realDate;
		} catch (ParseException e) {
					return null;
		}
	}

	public static String toString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public static Date utilToSql(java.util.Date date){
		return new Date(date.getTime());
	}


}
