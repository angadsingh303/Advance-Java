package com.bmpl.ims.users.views;

import java.sql.SQLException;
import java.util.Scanner;

import com.bmpl.ims.users.dao.UserDAO;
import com.bmpl.ims.users.dto.UserDTO;

public class LoginView {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the usr id");
		String userId = scanner.nextLine();
		System.out.println("Enter the password");
		String pwd = scanner.nextLine();
		System.out.println("Enter the pincode");
		String pinCode = scanner.nextLine();
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userId,pwd,pinCode,"A");
		if(userDAO.read(userDTO)){
			System.out.println("Found");
		}
		else{
			System.out.println("Not found");
		}
	}

}
