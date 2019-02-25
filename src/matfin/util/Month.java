package matfin.util;

public class Month {
	
		private String id;
		private String month;

		public Month() {

		}

		public Month(String id, String month) {
			this.id = id;
			this.month = month;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		@Override
		public String toString() {
			return this.month;
		}

}
