package com.wd.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.po.Order1;
import com.wd.po.Shoppingcart;
import com.wd.service.IOrderService;
import com.wd.service.IShoppingCratServer;
import com.wd.service.impl.OrderService;
import com.wd.service.impl.ShoppingCartServer;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String order_date = sdf.format(new Date());
		String order_price=request.getParameter("order_price");
		String username=request.getParameter("username");
		String sc_id=request.getParameter("sc_id");
		
		Order1 o=new Order1();
		o.setOrder_date(order_date);
		o.setOrder_price(order_price);
		o.setSc_id(sc_id);
		o.setUsername(username);
		 
		IOrderService ios=new OrderService();
		IShoppingCratServer iscs=new ShoppingCartServer();
		Shoppingcart sc=new Shoppingcart();
		sc.setUsername(username);
		iscs.deleteCart2(sc);
		if(ios.addOrder(o)){
			response.getWriter().print("提交成功");
		}else {
			response.getWriter().print("提交失败");
		}
	}

}
