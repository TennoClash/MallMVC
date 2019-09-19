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

import com.wd.dao.IGoodsDao;
import com.wd.dao.IUserDao;
import com.wd.dao.impl.GoodsDao;
import com.wd.dao.impl.UserDao;
import com.wd.service.IGoodsService;
import com.wd.service.impl.GoodsService;
import com.wd.util.Constant;

/**
 * Servlet implementation class GoodsShowServlet
 */
@WebServlet("/GoodsShowServlet")
public class GoodsShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsShowServlet() {
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
String good_name = null;
String username=request.getParameter("username");
good_name=request.getParameter("good_name");

		if (good_name != null) {
			good_name = URLDecoder.decode(good_name, "utf-8");
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
		
		IGoodsService ns=new GoodsService();
		List<Map<String, String>> goodsList=ns.queryGoodsByPage(cpage, Constant.PAGESIZE2, good_name);
		int totalcount =ns.queryGoodsCount(good_name);
		if (good_name != null) {
			request.setAttribute("good_name", URLEncoder.encode(URLEncoder.encode(good_name, "utf-8")));
		} else {
			request.setAttribute("good_name", good_name);
		}
		
		request.setAttribute("page", cpage);
		request.setAttribute("pageCount", (totalcount % Constant.PAGESIZE2 == 0) ? totalcount / Constant.PAGESIZE2
				: totalcount / Constant.PAGESIZE2 + 1);
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("username", username);
		request.getRequestDispatcher("goodsshow.jsp").forward(request, response);
	}

}
