package matfin.bo;

import java.util.ArrayList;
import java.util.List;

import matfin.dao.PayImageDAO;
import matfin.dao.PayImageInsertDAO;
import matfin.entity.PayImage;

public class PayImageMigrationBO {
	
	public int migrate(String url,String port,String userId,String password,String yymm) 
	{
		int result =0;
		List<PayImage> resultList ;
		try {
			resultList = new PayImageDAO(url, port, userId, password).getPayImageData(yymm);
			if(resultList != null) {
				result = new PayImageInsertDAO().insertPayImage(resultList).length;
			}
		}catch (Exception e) {
			result=0;
		}
		
		return result;
	}

}
