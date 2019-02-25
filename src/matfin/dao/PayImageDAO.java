package matfin.dao;

import java.sql.*;
import java.util.*;

import matfin.entity.PayImage;



public class PayImageDAO extends IngresDAO
{
   
   Connection con;

   public PayImageDAO(String url,String port, String userId,String password)throws Exception
   {

	   super(url,port,userId,password);
   }


   public ArrayList<PayImage> getPayImageData(String yymm)
	{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<PayImage> PayImageList = new ArrayList<PayImage>();
		try
		{
			stmt = getCon().createStatement();

			rs = stmt.executeQuery("SELECT * FROM pay_image WHERE yymm ='"+yymm+"'");

			    while(rs.next() == true)
				{
				   PayImage payImage = new PayImage();
				   
                   payImage.setEmpNum(rs.getString("emp_num"));
                   payImage.setYymm(rs.getString("yymm"));
                   payImage.setPayCode(rs.getString("pay_code"));
                   payImage.setPayCodeSrl(rs.getString("pay_code_srl"));
                   payImage.setPayMode(rs.getString("pay_mode"));
                   payImage.setTxnAmt(rs.getString("txn_amt"));
                   
                   PayImageList.add(payImage);
                }


		}catch(Exception e)
		{
			System.out.println("Pay Image DAO error:"+e);
		}finally
		{
			try
			{
				if(rs != null ) rs.close();
				if(stmt != null) stmt.close();
				closeCon();
			}catch(Exception e){}
		}


	     return PayImageList;
	}



 }
