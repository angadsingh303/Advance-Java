package com.angad.talentfinder.users.dao;

import static com.angad.talentfinder.users.dao.DBPropertyReader.getValue;
//	POJO - Plain old java object.
//DAO - DB CODE

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.angad.talentfinder.users.dto.RightDTO;
import com.angad.talentfinder.users.dto.UserDTO;
import com.angad.talentfinder.users.dto.UserRoleRightMappingDTO;

public class UserDAO {
	
	private Connection createConnection() throws ClassNotFoundException, SQLException{
		//Step-1 Load the Driver.
		//oracle.jdbc.driver.OracleDriver
		
		String driverName =getValue("drivername");
		//System.out.println(driverName);
		Class.forName(driverName);
		//Step-2 Create connection
		String dbURL = getValue("dburl");
		//System.out.println(dbURL);
		String userid =getValue("userid");
		//System.out.println(userid);
		String password =getValue("password");
		//System.out.println(password);
		Connection connection = (Connection) DriverManager.getConnection(dbURL,userid,password);
		/*if(connection!=null){
			System.out.println("Connection Created");
		}*/
		return connection;
	}
	/*public boolean isAuthenticate(UserDTO userDTO) throws ClassNotFoundException, SQLException{*/
	public UserRoleRightMappingDTO isAuthenticate(UserDTO userDTO) throws ClassNotFoundException, SQLException{
		UserRoleRightMappingDTO userRoleRight = null;
		boolean isFound = false;
		Connection connection = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			connection=createConnection();
			pstmt = connection.prepareStatement(SQLQueries.LOGIN_QUERY);
			//stmt = connection.createStatement();
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			//pstmt.setInt(3, Integer.parseInt(userDTO.getPinCode()));
			rs = pstmt.executeQuery();
			//rs = stmt.executeQuery("select userid,password from "
			//	+ "user_master where userid ='"+userDTO.getUserid()
			//		+"' and password ='"+userDTO.getPassword()+"' and pincode="+userDTO.getPinCode());
			ArrayList<RightDTO> rightList = new ArrayList<>();
			while(rs.next()){
				if(userRoleRight==null){
				userRoleRight = new UserRoleRightMappingDTO();	
				userRoleRight.setUserid(rs.getString("userid"));
				userRoleRight.setRole(rs.getString("rolename"));
				}
				RightDTO rightDTO = new RightDTO();
				rightDTO.setName(rs.getString("rightname"));
				rightDTO.setScreen(rs.getString("screenname"));
				rightList.add(rightDTO);
				
			}
			if(userRoleRight!=null){
				userRoleRight.setRightList(rightList);
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		
		return userRoleRight;
	}
	
	
	
	public boolean addUser(String userid, String password) throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		Statement statement = null;
		try{
		String sql = "insert into user (userid,password) "+ "values('"+userid+"','"+password+"')";
		connection = createConnection();
		//STEP - 3 Create do query
		statement = (Statement) connection.createStatement();
		int inserted = statement.executeUpdate(sql);
		return inserted>0?true:false;
		}
		finally{
			if(statement!=null)
			statement.close();
			
			if(connection!=null){
				connection.close();
			}
			
		}
	}
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException{
		UserDAO userDAO = new UserDAO();
		if(userDAO.addUser("amit","123")){
			System.out.println("record added...");
		}
		else{
			System.out.println("record not added");
		}
	}*/
	
}
