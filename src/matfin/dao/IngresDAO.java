package matfin.dao;

import java.sql.*;
import java.io.*;
import java.util.*;

public class IngresDAO
{

    private Connection con;
    public IngresDAO(){}
  	public IngresDAO(String url,String port,String userId,String password)
	  {
	    try{
            con = null;
            String ingUrl = "jdbc:ingres://"+url.trim()+":"+port.trim()+"/"+userId.trim()+";UID="+userId.trim()+";PWD="+password.trim();
            Class.forName("com.ingres.jdbc.IngresDriver");
            con = DriverManager.getConnection(ingUrl);
          }catch(Exception e)
         {
          System.out.println("Sorry!Database Link is Not Available. " + e);
         }	
    }

    public Connection getCon(){
      return this.con;
    }
    
    public void closeCon(){
      try{
        if(con!= null){
          con.close();
        }
      }catch(Exception e)
        {
          System.out.println("Error on Close connection " + e.getMessage());
        }
    }
 
}      