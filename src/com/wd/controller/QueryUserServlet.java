package com.wd.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.dao.IUserDao;
import com.wd.dao.impl.UserDao;
import com.wd.util.Constant;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserServlet() {
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
		
		if (username != null) {
			username = URLDecoder.decode(username, "utf-8");
		}
		
		String page = request.getParameter("page");
		int cpage = 1;
		if (page != null && !("").equals(page)) {
			cpage = Integer.valueOf(page);
		}
		
		String tpage=request.getParameter("tpage");
		String ttpage=request.getParameter("ttpage");
		if(tpage!=null){
			int i=Integer.valueOf(tpage).intValue();
			int j=Integer.valueOf(ttpage).intValue();
				if(i>0&&i<=j){
					cpage=i;
				}
		}
		
		IUserDao ns=new UserDao();

		List<Map<String, String>> userList=ns.queryUserByPage(cpage, Constant.PAGESIZE, username);
		int totalcount =ns.queryUserCount(username);
		if (username != null) {
			request.setAttribute("username", URLEncoder.encode(URLEncoder.encode(username, "utf-8")));
		} else {
			request.setAttribute("username", username);
		}
		
		request.setAttribute("page", cpage);
		request.setAttribute("pageCount", (totalcount % Constant.PAGESIZE == 0) ? totalcount / Constant.PAGESIZE
				: totalcount / Constant.PAGESIZE + 1);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("queryuser.jsp").forward(request, response);
	}

}
