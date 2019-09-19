package com.wd.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wd.service.IGoodsService;
import com.wd.service.impl.GoodsService;

/**
 * Servlet implementation class QueryGoodsServlet
 */
@WebServlet("/QueryGoodsServlet")
public class QueryGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryGoodsServlet() {
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
		String good_id=request.getParameter("good_id");
		String username=request.getParameter("username");
		IGoodsService ns=new GoodsService();
		
		Map<String, String> m = ns.queryGoodsDetail (good_id);
		request.setAttribute("good_name",m.get("good_name"));
		request.setAttribute("good_type", m.get("good_type"));             
		request.setAttribute("good_price",m.get("good_price"));
		request.setAttribute("good_discount",m.get("good_discount"));
		request.setAttribute("good_desc",m.get("good_desc"));
		request.setAttribute("supplier",m.get("supplier"));
		request.setAttribute("qty",m.get("qty"));
		request.setAttribute("ispreferred",m.get("ispreferred"));
		request.setAttribute("good_pic",m.get("good_pic"));
		request.setAttribute("username", username);
		
		
		DecimalFormat df = new DecimalFormat( "0.0 ");
		double bprice=Double.parseDouble(m.get("good_price"));
		double discount=Double.parseDouble(m.get("good_discount"));
		bprice=bprice*discount;
		
		request.setAttribute("bprice", df.format(bprice));
		
		request.getRequestDispatcher("goods.jsp").forward(request, response);
		
		
		
		
	}

}
