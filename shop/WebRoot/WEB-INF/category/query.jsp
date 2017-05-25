<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	 <script type="text/javascript">
 	 	//alert("----");
 	 	$(function(){
 	 		$('#dg').datagrid({ 
 	 		    //请求数据的地址   
			    url:'datagrid_data.json', 
			    //配置dg的列字段field，列字段的名称，与json的key捆绑title：列标题   
			    columns:[[    
			        {field:'code',title:'编号',width:100},    
			        {field:'productname',title:'产品的名称',width:100},    
			        {field:'unitcost',title:'Price',width:100,align:'right'}    
			    ]]    
			});  
 	 	});
 	 		
 	 </script>
 	 
  </head>
  
 <body>
   	 <script type="text/javascript">
   	 	//alert("===");
   	 </script>
   	<table id="dg"></table> 
  </body>
</html>
