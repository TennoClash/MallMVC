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

import com.wd.service.IGoodsService;
import com.wd.service.IShoppingCratServer;
import com.wd.service.impl.GoodsService;
import com.wd.service.impl.ShoppingCartServer;
import com.wd.util.Constant;

/**
 * Servlet implementation class QueryShoppingCartServlet
 */
@WebServlet("/QueryShoppingCartServlet")
public class QueryShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryShoppingCartServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		request.setAttribute("username", username);
		String good_name = null;
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
				
				IShoppingCratServer ns=new ShoppingCartServer();
				List<Map<String, String>> goodsList=ns.queryGoodsByPage(cpage, Constant.PAGESIZE3,username ,good_name);
				int totalcount =ns.queryGoodsCount(good_name);
				if (good_name != null) {
					request.setAttribute("good_name", URLEncoder.encode(URLEncoder.encode(good_name, "utf-8")));
				} else {
					request.setAttribute("good_name", good_name);
				}
				
				request.setAttribute("page", cpage);
				request.setAttribute("pageCount", (totalcount % Constant.PAGESIZE3 == 0) ? totalcount / Constant.PAGESIZE3
						: totalcount / Constant.PAGESIZE3 + 1);
				request.setAttribute("cratList", goodsList);
				
				request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		
	}

}
