package com.wd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.po.Shoppingcart;
import com.wd.service.IShoppingCratServer;
import com.wd.service.impl.ShoppingCartServer;

/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
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
		String sc_id=request.getParameter("sc_id");
		Shoppingcart sc=new Shoppingcart();
		sc.setSc_id(sc_id);
		IShoppingCratServer scs=new ShoppingCartServer();
		if(scs.deleteCart(sc)){
			response.getWriter().println("删除成功<a href='shoppingcart.jsp' target='content'> 返回</a>");
		}else{
			response.getWriter().println("删除失败");
		}
	}

}
