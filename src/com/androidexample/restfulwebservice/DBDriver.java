package com.androidexample.restfulwebservice;

import org.sqldroid.SQLDroidDriver;

/**
 * 
 */

/**
 * @author lfhernandez
 *
 */
public class DBDriver {
 
	private SQLDroidDriver driver;
    /**
	 * @return the driver
	 */
	public SQLDroidDriver getDriver() {
		return driver;
	}

	private static DBDriver instance;
     
    private DBDriver() {
    	driver = new org.sqldroid.SQLDroidDriver();
    }
     
    public static synchronized DBDriver getInstance() {
        if(instance == null){
            instance = new DBDriver();
        }
        return instance;
    }
     
}
