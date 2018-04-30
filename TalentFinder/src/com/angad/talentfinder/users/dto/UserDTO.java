package com.angad.talentfinder.users.dto;

public class UserDTO {
private String userid;
private String password;
private String pinCode;
public String getPinCode() {
	return pinCode;
}
public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
}
public String getUserid() {
	return userid;
}
public String getPassword() {
	return password;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public void setPassword(String password) {
	this.password = password;
}
	
}
