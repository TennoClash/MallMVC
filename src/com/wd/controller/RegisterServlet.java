package com.wd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.po.User;
import com.wd.service.IUserService;
import com.wd.service.impl.UserService;
import com.wd.util.Constant;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String realname=request.getParameter("realname");
		String phone=request.getParameter("phone");
		String isadminadd="add";
		String isadmin="admin";
		String adminadd=request.getParameter("adminadd");
		String admintype=request.getParameter("admintype");
		List<String> errors = new ArrayList<String>();
		if (username == null || username == "") {
			errors.add("用户名不能为空");
		}
		if (password.length() < 6) {
			errors.add("密码长度小于6");

		}

		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setGender(gender);
			user.setEmail(email);
			user.setRealname(realname);
			user.setPhone(phone);
			if(admintype.equals(isadmin) ){
				user.setUser_type(Constant.TYPE2);;
			}else{
				user.setUser_type(Constant.TYPE1);
			}
			
			IUserService userService = new UserService();
			
			if(adminadd.equals(isadminadd)&&userService.addUser(user)){
				response.getWriter().println("添加用户成功<a href='adminadd.jsp' target='content'> 继续添加</a>");
				response.getWriter().println("<a href='index.jsp' target='index'> 返回</a>");
			}else{
			if (userService.addUser(user)) {
				response.sendRedirect("login.jsp");
			}
			}
			
		
		}
		
		
		
		
	}

}
