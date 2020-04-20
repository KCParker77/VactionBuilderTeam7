package model;

public class Vacation {
	 private String vacName;
	   private double flightPrice;
	 
	   public Vacation( String vacName, double flightPrice) {
	       this.vacName = vacName;
	       this.flightPrice = flightPrice;
	   }
	   
	   public String getVacName() {
	       return vacName;
	   }
	 
	   public void setVacName(String vacName) {
	       this.vacName = vacName;
	   }
	 
	   public double getFlightPrice() {
	       return flightPrice;
	   }
	 
	   public void setFlightPrice(int flightPrice) {
	       this.flightPrice = flightPrice;
	   }
	   public String toString(){
		return String.format("%-32s  \t$%s",vacName,flightPrice);
		   
	   }
}
