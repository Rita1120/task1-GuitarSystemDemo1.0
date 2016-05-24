<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dataBaseFactory.DaoFactory" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js"></script>
<title>查询吉他</title>
</head>
<body>
<label>吉他编号：</label><input type="text" name="serialnum" id="serialnum" placeholder="请输入吉他编号">
<label>生产商：</label><input type="text" name="builder" id="builder" placeholder="请输入生产商">
<label>型号：</label><input type="text" name="model" id="model" placeholder="请输入型号">
<br><br>
<label>类型：</label><select name="type" id="type"><option>请选择</option><option value="电子">电子</option><option value="古典">古典</option></select>
<label>背板木：</label><input type="text" name="backWood" id="backWood" placeholder="请输入背板木">
<label>顶端木：</label><input type="text" name="topWood" id="topWood" placeholder="请输入顶端木">
<br><br>
&nbsp;&nbsp;&nbsp;
<input type="button" name="find" id="find"  value="查询">
&nbsp;&nbsp;&nbsp;
<input type="reset" name="reset" value="重置">
<br><br>
	<table border="1" width="600px">
	    <thead>
	        <tr>
	        	<th>吉他编号</th>
	            <th>价格</th>
	            <th>制造商</th>
	            <th>型号</th>
	            <th>类型</th>
	            <th>背板木</th>
	            <th>顶端木</th>
	        </tr>
	    </thead>
	    <tbody>
<c:forEach var="guitar" items="${DaoFactory.getGuitarDaoInstance().findAll('')}">
        <tr>
        <td>${guitar.serialNumber}</td> 
        <td>${guitar.price}</td>    
        <td>${guitar.builder}</td>   
        <td>${guitar.model}</td>   
        <td>${guitar.type}</td>   
        <td>${guitar.backWood}</td>    
         <td>${guitar.topWood}</td> 
        </tr>    
</c:forEach>
	    
	    </tbody>
	    </table>
</body>
<script type="text/javascript">
//查询吉他功能
	$(document).ready(function() {
		$("#find").click(function() {
					var serialnum = $("#serialnum").val();
					var builder = $("#builder").val();
					var price = $("#price").val();
					var model = $("#model").val();
					var type = $("#type").val();
					var backWood = $("#backWood").val();
					var topWood = $("#topWood").val();
					$.get("findServlet",{
						serialnum : serialnum,
						price:price,
						builder:builder,
						model:model,
						type:type,
						backWood:backWood,
						topWood:topWood
						},function(m2) {
										$("table tr:gt(0)").remove();//除了第一行的数据后，其他行都删除
										var html = "";
										for (var i = 0; i < m2.guitar.length; i++) {
											var r = m2.guitar[i];
									        html+="<tr><td>" + r.serialnum + "</td>";
									        html+="<td>" + r.price + "</td>";		
									        html+="<td>" + r.builder + "</td>";	
									        html+="<td>" + r.model + "</td>";	
									        html+="<td>" + r.type + "</td>";	
									        html+="<td>" + r.backWood + "</td>";	
									        html+="<td>" + r.topWood + "</td></tr>";					
										}
										$("table").append(html);
									});
				});
	});
</script>

</html>