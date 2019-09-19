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

import com.wd.dao.IOrderDao;
import com.wd.dao.IUserDao;
import com.wd.dao.impl.OrderDao;
import com.wd.dao.impl.UserDao;
import com.wd.util.Constant;

/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOrderServlet() {
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
		if(tpage!=null&&"".equals(tpage)){
			int i=Integer.valueOf(tpage).intValue();
			int j=Integer.valueOf(ttpage).intValue();
				if(i>0&&i<=j){
					cpage=i;
				}
		}
		
		IOrderDao iod =new OrderDao();

		List<Map<String, String>> userList=iod.queryOrderByPage(cpage, Constant.PAGESIZE3, username);
		int totalcount =iod.queryOrderCount(username);
		if (username != null) {
			request.setAttribute("username", URLEncoder.encode(URLEncoder.encode(username, "utf-8")));
		} else {
			request.setAttribute("username", username);
		}
		
		request.setAttribute("page", cpage);
		request.setAttribute("pageCount", (totalcount % Constant.PAGESIZE3 == 0) ? totalcount / Constant.PAGESIZE3
				: totalcount / Constant.PAGESIZE3 + 1);
		request.setAttribute("orderList", userList);
		request.getRequestDispatcher("queryorder.jsp").forward(request, response);
		
		
	}

}
