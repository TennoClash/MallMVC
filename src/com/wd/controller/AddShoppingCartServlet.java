package com.wd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.po.Shoppingcart;
import com.wd.service.IShoppingCratServer;
import com.wd.service.impl.GoodsService;
import com.wd.service.impl.ShoppingCartServer;

/**
 * Servlet implementation class AddShoppingCartServlet
 */
@WebServlet("/AddShoppingCartServlet")
public class AddShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShoppingCartServlet() {
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
		if(username==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else{
		String good_name=request.getParameter("good_name");
		String good_pic=request.getParameter("good_pic");
		String good_price=request.getParameter("good_price");
		String sc_count=request.getParameter("sc_count");

		Shoppingcart sc=new Shoppingcart();
		sc.setGood_name(good_name);
		sc.setGood_pic(good_pic);
		sc.setGood_price(good_price);
		sc.setSc_count(sc_count);
		sc.setUsername(username);
		IShoppingCratServer scs=new ShoppingCartServer();
		
		if(scs.addcart(sc)){
			response.getWriter().append("添加购物车成功");
		}else{
			response.getWriter().append("添加购物车失败");
		}
		}
	}

}
