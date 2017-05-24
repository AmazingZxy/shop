<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	<style type="text/css">
 	 	#menu{
 	 		width: 200px;
 	 		///border:1px solid red;
 	 	}
 	 	#menu ul{
 	 		list-style:none;
 	 		padding:0px;
 	 		margin:0px;
 	 	}
 	 	#menu ul li{
 	 		border-botom:1px solid #fff;
 	 	}
 	 	#menu ul li a{
 	 		display:block;
 	 		background-color: #008792;
 	 		color:#fff;
 	 		padding:5px;
 	 		text-decoration: none;
 	 	}
 	 	#menu ul li a:hover{
 	 		background-color: #00a6ac
 	 	}
 	 </style>	
 	 <script type="text/javascript">
 	 	$(function(){
 	 	$("a[title]").click(function(){
		 	 	var text = $(this).text();
		 	 	var href = $(this).attr("title");
 	 			//1 判断当前后边是否已经有相应的tab
 	 			if($("#tt").tabs("exists",text)){
 	 				$("#tt").tabs("select",text);
 	 			}else{
 	 				$("#tt").tabs("add",{
 	 					title:text,
 	 					closable:true,
 	 					context:'<frame src="send_category_query.action" frameborder="0" width ="100%" height="100%" />'
 	 					//href 默认是通过URL地址，加载远程的页面，但是仅仅是body页面
 	 					//href:'send_category_query.action'
 	 				});
 	 			}
 	 			//2 如果没有则创建一个新的tag，否则切换到当前tab
 	 		});
 	 	});
 	 </script> 
  </head>
  
	<body class="easyui-layout">  
	
		
	    <div data-options="region:'north',title:'欢迎来到易购后台管理系统',split:true" style="height:100px;"></div>     
	    <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
	    	
		    <!-- 显示的系统的菜单 -->
		    <div id="menu" class="easyui-accordion" data-options="fit:true">
		     	<div title="基本操作" data-options="iconCls:'icon-save'">
		     		<ul>
		     		<li><a href="#" title="send_category_query.action">类别管理</a></li>
		     		<li><a href="#">商品管理</a></li>
		     	</ul>
		    	 </div>
		    	<div title="基本操作" data-options="iconCls:'icon-save'">
		     		<ul>
		     			<li><a href="#">类别管理</a></li>
		     			<li><a href="#">商品管理</a></li>
		     		</ul>
		     	
		     	</div>
		     </div>
			     
			
	    </div>   
	    <div data-options="region:'center',title:'后台操作界面'" style="padding:1px;background:#fff;">
	    	<div id="tt" class="easyui-tabs" data-options="fit:true">   
			    <div title="系统缺省页面" style="padding:10px;">   
			        此处以后显示相应的系统信息（当前操作想it的类型，包括当前项目的域名 硬件的相关配置，或者显示报表  
			    </div>   
		   
			</div>  
	    </div>   
	</body> 
</html>
