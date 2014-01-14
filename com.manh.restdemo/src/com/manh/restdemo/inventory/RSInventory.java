package com.manh.restdemo.inventory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.manh.dao.*;
import com.manh.util.ToJSON;

import org.codehaus.jettison.json.JSONArray;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Path("/inventory")
public class RSInventory {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String returnAllPCParts()throws Exception
	{
		
		PreparedStatement query=null;
		Connection conn=null;
		String myString=null;
		String returnString=null;	
		
		try{
			
			conn=JaxRSDAO.getRSDataSource().getConnection();
			query=conn.prepareStatement("select * "+" from PC_PARTS");
			ResultSet rs=query.executeQuery();
			JSONArray jsonArray=new  JSONArray();
			ToJSON converter=new ToJSON();
			jsonArray=converter.ToJSONArray(rs);
			rs.close();
			returnString=jsonArray.toString();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
			
			if(conn!=null)
			{
				conn.close();
			}
		}

	return returnString;
	}
	
	
}
