package customerRecord;

public class Address {
 private String state;
 private String city;
 private String streetNo;
 private String pinCode;
 
 public Address(String state,String city,String streetNo, String pinCode)
 {
	 this.state = state;
	 this.city = city;
	 this.streetNo = streetNo;
	 this.pinCode = pinCode;
 }
 
 @Override
 public boolean equals(Object object){
	 if(object instanceof Address){
		 Address address = (Address) object; //downcasting
		
		 if(this==address){
			 return true;
		 }
		 if(this.pinCode.equals(address.pinCode) &&
				 this.streetNo.equalsIgnoreCase(address.streetNo)){
			 return true;
		 }
		 return false;
	 }
	 return false;
 }
 
 @Override
 public int hashCode(){
	 if(city.equalsIgnoreCase("delhi")){
		 return 100;
	 }
	 if(city.equalsIgnoreCase("mumbai")){
		 return 100;
	 }
	 if(city.equalsIgnoreCase("bangalore")){
		 return 100;
	 }
	 else
		 return 400;
 }
 
public String getState() {
	return state;
}
public String getCity() {
	return city;
}
public String getStreetNo() {
	return streetNo;
}
public String getPinCode() {
	return pinCode;
}
public void setState(String state) {
	this.state = state;
}
public void setCity(String city) {
	this.city = city;
}
public void setStreetNo(String streetNo) {
	this.streetNo = streetNo;
}
public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
}
 
 
}
