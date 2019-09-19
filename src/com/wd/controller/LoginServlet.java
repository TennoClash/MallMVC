package com.wd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.po.User;
import com.wd.service.IUserService;
import com.wd.service.impl.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		IUserService userService = new UserService();
		User user = userService.getUserByNameAndPwd(username, password);
		if (user != null) {
			request.getSession().invalidate();
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("username", username);
			response.sendRedirect("index.jsp");
		} else {
			request.getSession().setAttribute("error", "用户名或密码错误");
			response.sendRedirect("login.jsp");
		}
	}

}
