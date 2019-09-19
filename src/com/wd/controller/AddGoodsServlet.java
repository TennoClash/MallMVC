package com.wd.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wd.po.Goods;
import com.wd.service.IGoodsService;
import com.wd.service.impl.GoodsService;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 File tmpDir = null;//初始化上传文件的临时存放目录  
	    File saveDir = null;//初始化上传文件后的保存目录  
    public AddGoodsServlet() {
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
		
		String good_name=request.getParameter("good_name");
		String good_type=request.getParameter("good_type");
		String good_discount=request.getParameter("good_discount");
		String good_price=request.getParameter("good_price");
		String good_desc=request.getParameter("good_desc");
		String supplier=request.getParameter("supplier");
		String ispreferred=request.getParameter("ispreferred");
		String qty=request.getParameter("qty");
		String good_pic=request.getParameter("good_pic");
		good_pic="img/goodspu/"+good_pic;
		
		Goods og =new Goods();
		og.setGood_desc(good_desc);
		og.setGood_discount(good_discount);
		og.setGood_name(good_name);
		og.setGood_pic(good_pic);
		og.setGood_price(good_price);
		og.setGood_type(good_type);
		og.setIspreferred(ispreferred);
		og.setQty(qty);
		og.setSupplier(supplier);
		
		IGoodsService ig=new GoodsService();
		if (ig.addGoods(og)) {
			response.getWriter().println("添加成功");
		} else {
			response.getWriter().println("添加失败");

		}
		
		
		/*SmartUpload su = new SmartUpload();//新建一个SmartUpload对象
		//su.getRequest().getParameterValues();//取数组值
		String good_price=su.getRequest().getParameter("good_price");//取单个参数单个值
		//String good_name=request.getParameter("good_name");
		//response.getWriter().print(good_name);
		response.getWriter().print(good_price);
		String good_name=su.getRequest().getParameter("good_name");
		response.getWriter().print(good_name);
		
		try{  
	        if(ServletFileUpload.isMultipartContent(request)){  
	          DiskFileItemFactory dff = new DiskFileItemFactory();//创建该对象  
	          dff.setRepository(tmpDir);//指定上传文件的临时目录  
	          dff.setSizeThreshold(1024000);//指定在内存中缓存数据大小,单位为byte  
	          ServletFileUpload sfu = new ServletFileUpload(dff);//创建该对象  
	          sfu.setSizeMax(5000000);//指定单个上传文件的最大尺寸  
	          sfu.setSizeMax(10000000);//指定一次上传多个文件的总尺寸  
	          FileItemIterator fii = sfu.getItemIterator(request);//解析request 请求,并返回FileItemIterator集合  
	          while(fii.hasNext()){  
	            FileItemStream fis = fii.next();//从集合中获得一个文件流  
	            if(!fis.isFormField() && fis.getName().length()>0){//过滤掉表单中非文件域  
	                String fileName = fis.getName().substring(fis.getName().lastIndexOf("\\")+1);//获得上传文件的文件名  
	                BufferedInputStream in = new BufferedInputStream(fis.openStream());//获得文件输入流  
	                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(saveDir+fileName)));//获得文件输出流  
	                Streams.copy(in, out, true);//开始把文件写到你指定的上传文件夹  
	            } 
	          }  
	          response.getWriter().println("File upload successfully!!!");//终于成功了,还不到你的上传文件中看看,你要的东西都到齐了吗  
	        }  
	    }catch(Exception e){  
	        e.printStackTrace();  
	    }  */
		
	}

	 public void init() throws ServletException {  
		/*super.init();  
		    String tmpPath = "q://tmpdir";  
		    String savePath ="q://tmpdir1";  
		    tmpDir =new File(tmpPath);  
		    saveDir = new File(savePath);  
		    if(!tmpDir.isDirectory())  
		        tmpDir.mkdir();  
		    if(!saveDir.isDirectory())  
		        saveDir.mkdir();     
	 
		 */
	 }
	
	
}
