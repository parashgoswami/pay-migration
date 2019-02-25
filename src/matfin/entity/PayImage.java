package matfin.entity;

public class PayImage {
	
	      private String empNum;
	      private String yymm;
	      private String payCode;
	      private String payCodeSrl;
	      private String payMode;
	      private String txnAmt;     


	      public void setEmpNum(String empNum)
		  {
			this.empNum = empNum;
		  }

		  public String getEmpNum()
		  {
		    	return empNum;
	      }

	      public void setYymm(String yymm)
		  {
			this.yymm = yymm;
		  }

		  public String getYymm()
		  {
				return yymm;
	      }

	      public void setPayCode(String payCode)
		  {
			this.payCode = payCode;
		  }

		  public String getPayCode()
		  {
				return payCode;
	      }

	      public void setPayCodeSrl(String payCodeSrl)
		  {
			this.payCodeSrl = payCodeSrl;
		  }

		  public String getPayCodeSrl()
		  {
				return payCodeSrl;
	      }

	      public void setPayMode(String payMode)
		  {
			this.payMode = payMode;
		  }

		  public String getPayMode()
		  {
				return payMode;
	      }

	      public void setTxnAmt(String txnAmt)
		  {
			this.txnAmt = txnAmt;
		  }

		  public String getTxnAmt()
		  {
				return txnAmt;
	      }
	    
	}

