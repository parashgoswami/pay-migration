package matfin.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import matfin.entity.PayImage;

public class PayImageInsertDAO extends MySqlDAO {
	PayImage PayImage;
	Connection con;
     
	public PayImageInsertDAO() throws Exception {
	}
	

	public int[] insertPayImage(List<PayImage> PayImageList) {
		Statement stmt = null;
		int[] rows = null;

		try {
			con = getCon();
			con.setAutoCommit(false);
			stmt = con.createStatement();			
			for (PayImage PayImage : PayImageList) {
				stmt.addBatch("INSERT IGNORE INTO ii_pay_image(emp_num,yymm,pay_code,pay_code_srl,pay_mode,txn_amt) VALUES ('" + PayImage.getEmpNum() + "',"
						+ PayImage.getYymm() + "," + PayImage.getPayCode() + "," + PayImage.getPayCodeSrl() + ","
						+ PayImage.getPayMode() + "," + PayImage.getTxnAmt() +")");
			}

			rows = stmt.executeBatch();
			con.commit();		

		} catch (Exception e) {
			System.out.println("Pay Image Insert Error:" + e);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				closeConnection();
			} catch (Exception e) {
			}
		}
		return rows;
	}

}
