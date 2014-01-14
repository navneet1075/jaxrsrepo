package com.manh.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JaxRSDAO {

	private static DataSource jaxrsDatasource=null;
	private static Context rsContext=null;

	public static DataSource getRSDataSource() throws Exception{
		
		if(jaxrsDatasource!=null)
			return jaxrsDatasource;
		try {
                             if(rsContext==null)
                            	 rsContext=new InitialContext();
			
                             jaxrsDatasource=(DataSource)rsContext.lookup("jdbc/JaxRSConnectionPool");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jaxrsDatasource;
	}

}
