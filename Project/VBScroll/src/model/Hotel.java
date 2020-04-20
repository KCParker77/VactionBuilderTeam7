package model;


public class Hotel {
	   private String hotelName;
	   private double hotelPrice;
	   private String hotelInfo;
	   private String hotelImage;
	   
	   public Hotel( String hotelName, double hotelPrice, String hotelInfo,String hotelImage ) {
	       this.hotelName = hotelName;
	       this.hotelPrice = hotelPrice;
	       this.hotelInfo = hotelInfo;
	       this.hotelImage = hotelImage;
	   }
	 
		public String getHotelImage() {
			return hotelImage;
		}

		public void setHotelImage(String hotelImage) {
			this.hotelImage = hotelImage;
		}
	   
	   
		public String getHotelInfo() {
			return hotelInfo;
		}

		public void setHotelInfo(String hotelInfo) {
			this.hotelInfo = hotelInfo;
		}
	   
	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public double getHotelPrice() {
		return hotelPrice;
	}


	public void setHotelPrice(double hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public String toString(){
		return String.format("%-40s  \t$%s/pn",hotelName,hotelPrice);
	   }
}
