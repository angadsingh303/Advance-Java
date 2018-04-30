package com.bmpl.ims.common.dao;

public interface CommonSQL {
	 static String LOGIN_SQL = "select userid, password from user_mst where userid=?"+"and password=?"+"and pincode=?";
	 static String REGISTER_SQL = "insert into user_mst(userid,password,pincode) values(?,?,?)";
}
