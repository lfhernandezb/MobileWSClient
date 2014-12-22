package com.androidexample.restfulwebservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import android.content.Context;

/**
 * 
 */

/**
 * @author lfhernandez
 *
 */
public class DBHelper {
	public static Connection getConnection(Context context) throws SQLException {
		String url = "jdbc:sqldroid:" + context.getFilesDir().getAbsolutePath() + "/car.db3";
		
		return DBDriver.getInstance().getDriver().connect(url , new Properties());	        			

	}

}
