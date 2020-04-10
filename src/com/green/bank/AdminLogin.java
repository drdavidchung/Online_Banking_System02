package com.green.bank;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.bank.model.AccountModel;

//import com.lmonkey.entity.LMONKEY_USER;
//import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		int count = BANKING_USERDao.selectByNM(userName, passWord);
		
		//System.out.println(userName + "##"+passWord);
		System.out.println("count = "+count);
		
		if(count > 0) {
			
			AccountModel user = BANKING_USERDao.selectAdmin(userName, passWord);
			HttpSession session = request.getSession();
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			if(user.getUser_status() == 2) {
				session.setAttribute("isAdminLogin", "1");
				System.out.println(userName + "##"+passWord);
				response.sendRedirect("admin_index.jsp");
			}else{
				
				response.sendRedirect("index.jsp");
			}			
			
		}else{
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户登录失败！');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
		}
	}

}
