package matfin.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDAO {
	private Connection con;


  	public MySqlDAO()
  	{
    		try{
      	         con = null;
      	         Class.forName("com.mysql.jdbc.Driver").newInstance();
     		     con = DriverManager.getConnection("jdbc:mysql://10.3.0.10/hrms","root","server88");
    		}catch(Exception e)
    		{
      		     System.out.println("Error:Database connection error. " + e);
    		}
  	}


  	public Connection getCon(){
    		return this.con;
  	}


  	public void closeConnection()
  	{
    		try{
      		     if(con != null){con.close();}        		
    		}catch(Exception e){
       	        System.out.println("Error on Close connection " + e.getMessage());
    		}
  	}
}
