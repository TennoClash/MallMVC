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
 * Servlet implementation class ChangePWDServlet
 */
@WebServlet("/ChangePWDServlet")
public class ChangePWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePWDServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String password = request.getParameter("password");
		String npassword = request.getParameter("npassword");
		String repassword = request.getParameter("repassword");
		User user = (User) request.getSession().getAttribute("user");
		if (password.equals(user.getPassword())) {
			IUserService us = new UserService();
			user.setPassword(npassword);
			if (us.updateUser(user)) {
				response.getWriter().println("密码更新成功");

			} else {

				response.getWriter().println("密码更新失败");
			}

		} else {
			response.getWriter().println("密码输入有误");
		}
	}

}
