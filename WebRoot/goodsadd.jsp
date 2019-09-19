<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<style>
form{color:#fff;font-weight:bold;}

</style>
</head>
<body>

        

 <form action="AddGoodsServlet" method="post" name="addGoodsForm" >
<input type="hidden" name="addtype" id="addtype" value="form"/>	
<div>
	<table>
		<tr>
			<td colspan="10" class="tdfirst">添加商品</td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td ><input type="text" name="good_name" id="good_name"/></td>
		
		
			<td>商品价格</td>
			<td >
				<input type="text" name="good_price" id="good_price"/>
			</td>
			<td>商品折扣
			<select name="good_discount">
					<option value="0.1">10%off</option>
					<option value="0.2">20%off</option>
					<option value="0.3">30%off</option>
					<option value="0.4">40%off</option>
					<option value="0.5">50%off</option>
					<option value="0.6">60%off</option>
					<option value="0.7">70%off</option>
					<option value="0.8">80%off</option>
					<option value="0.9">90%off</option>
					<option value="1">none</option>
				</select>
			</td>
		</tr>
		
		<tr >
		<td colspan="4">商品类型
		        <input type="radio" name="good_type" value="sport"/>户外运动
				<input type="radio" name="good_type" value="wears"/>穿戴
				<input type="radio" name="good_type" value="dress"/>服饰
				<input type="radio" name="good_type" value="appliances"/>家电
				<input type="radio" name="good_type" value="phone"/>手机		
		</td>
		
		<td>是否推荐
		<input type="radio" name="ispreferred" value="yes"/>yes
		<input type="radio" name="ispreferred" value="no" checked/>no
		</td>
		
		</tr>
		
		<tr>
		<td colspan="5">描述 <textarea rows="5" cols="80" name="good_desc"></textarea>
		
		</td>
		</tr>
		
		<tr>
		<td colspan="5">
		商品图片<input type="file" name="good_pic" id="good_pic"/>		
		</td>
		</tr>
		
		
		<tr>
		<td colspan="2">供应商 <input type="text" name="supplier" id="supplier"/></td>
		<td colspan="2">库存数量 <input type="text" name="qty" id="qty"/></td>
		
		</tr>
		
		
		<tr>
			<td colspan="5" class="tdlast">
				<input type="submit" value="提交"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</div>



</form>


</body>
</html>