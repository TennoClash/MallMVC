package com.wd.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.po.User;
import com.wd.service.IUserService;
import com.wd.service.impl.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		IUserService iu=new UserService();
		String change=request.getParameter("change");
		
		if(change.equals("display")){
			String user_id =request.getParameter("user_id");
			Map<String, String> n =iu.queryNewsDetail(user_id);	
			request.setAttribute("n", n);
			request.setAttribute("user_id", user_id);
			request.getRequestDispatcher("editUser.jsp").forward(request, response);
			
		}else{
		
		String email =request.getParameter("email");
		String  gender=request.getParameter("gender");
		String  phone=request.getParameter("phone");
		String  user_type=request.getParameter("user_type");
		String user_id =request.getParameter("user_id");
		
		response.getWriter().println(email);
		response.getWriter().println(gender);
		response.getWriter().println(phone);
		response.getWriter().println(user_type);
		response.getWriter().println(user_id);
		User user=new User();
		
		user.setEmail(email);
		user.setGender(gender);
		user.setPhone(phone);
		user.setUser_type(user_type);
		user.setUser_id(user_id);
		if(user_type.equals("admin")){
			user_type="管理员";
		}else {
			user_type="用户";
		}
		user.setUser_type(user_type);
		
		String su="修改成功";
		String fe="修改失败";
		if(iu.updateUserinfo(user)){
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().print(su);
			response.getWriter().println("<a href='QueryUserServlet' target='content'> back</a>");
		}else {
			response.getWriter().print(fe);
		}
			
		}
		
		
	}

}
