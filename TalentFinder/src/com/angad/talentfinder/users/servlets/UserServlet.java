package com.angad.talentfinder.users.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.angad.talentfinder.users.dao.UserDAO;
import com.angad.talentfinder.users.dto.UserDTO;
import com.angad.talentfinder.users.dto.UserRoleRightMappingDTO;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private int counter;
	@Override
	public void init(){
		counter=1;
		System.out.println("Init Call once");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid= request.getParameter("userid");//when input data is in HTML
		String password = request.getParameter("pwd");
		String pinCodeData = request.getParameter("pincode");
		String favColor = request.getParameter("favcolor");
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		userDTO.setPinCode(pinCodeData);
		int pinCode = 1001;
		//if(userid.equals(password)){
		try{
		UserRoleRightMappingDTO userRoleDTO = userDAO.isAuthenticate(userDTO);	
		if(userRoleDTO!=null){
			HttpSession session = request.getSession(true); // create a new session
			//Check if cookie exists or not
			boolean isCookieFound = false;
			Cookie cookies[]=request.getCookies();
			if(cookies!=null && cookies.length>0){
				for(Cookie c: cookies){
					if(c.getName().equals("mycolor")){
						isCookieFound=true;
						break;
					}
				}
			}
			//Define Cookie
			if(!isCookieFound){
			Cookie cookie = new Cookie("mycolor",favColor);
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
			}
			//session.setAttribute("userid", userid);
			//session.setAttribute("pinCode", pinCode);
			session.setAttribute("userinfo", userRoleDTO);
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "-1");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.talent");
			rd.forward(request, response);
			
			//String enCodedURL=response.encodeRedirectURL("welcome.talent");
			//response.sendRedirect(enCodedURL);
			//request.setAttribute("pin", pinCode);
			//response.sendRedirect("welcome");
			//response.sendRedirect("welcome.html");
			//response.sendRedirect("welcome?uid="+userid+"&pin="+pinCode);//Query String
			//RequestDispatcher rd = request.getRequestDispatcher("welcome");
			//rd.forward(request, response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.println("Invalid user id or password");
			out.close();
		}
	}	
		catch (SQLException e){
			response.sendRedirect("CustomerError.html");
			e.printStackTrace();
			}
		catch(ClassNotFoundException e){
			response.sendRedirect("CustomerError.html");
			e.printStackTrace();
			}
		catch(Exception e){
			response.sendRedirect("CustomerError.html");
			e.printStackTrace();
			}
		/*System.out.println("Get (Service) call again and again");
		PrintWriter out = response.getWriter();
		out.println("Hello Client"+counter);
		counter++;*/
		//out.close();
	}

}