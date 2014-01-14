package com.manh.restdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.manh.dao.JaxRSDAO;

@Path("v1")
public class DemoService {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getTitle()
	{
		return new String("<h1>R.K.Dutta</h1>");
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getVersion()
	{
		return new String("<h2>0.0.0.1</h2>");
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus()throws Exception
	{
		PreparedStatement ps=null;
		String myString=null;
		String returnString=null;
		Connection conn=null;
		StringBuilder buildDatabaseStatus=new StringBuilder();
		try{
			conn=JaxRSDAO.getRSDataSource().getConnection();
			ps=conn.prepareStatement("select * from mytable");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				myString=rs.getString("name");
				buildDatabaseStatus=buildDatabaseStatus.append(myString+"--");
				
						
			}
			ps.close();
			returnString= "<h1> Database Names "+buildDatabaseStatus.toString()+"</h1>";
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
		return returnString;
	}
	     
}
