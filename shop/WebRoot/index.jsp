<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  </head>
  
 <body>
 	
 	 <a href="send_main_aindex.action">直接到后台 ui版本</a>
 	 <a href="send_main_index.action">直接到后台</a>
     <a href="${shop}/category_update.action?category.id=2&category.type=儿童休闲&category.hot=false">访问action 测试ssh环境</a>
     
     <a href="${shop}/category_update.action?id=2&type=儿童休闲&hot=false">模型驱动测试</a>
     
     
     <!-- javascript只能用这个 -->
     <a href="category_save.action">访问save 测试是spring和Struts环境</a>
     
     <a href="category_save.action">访问save，测试所以的Spring与Struts的环境</a>
     <a href="category_query.action">查询所有的类别</a>
     
      <a href="account_query.action?login=admin">Account Action测试</a>
     <br/>
     <c:forEach items="${requestScope.categoryList}" var="category">
     	${category.id}|${category.type}|${category.hot}<br/>
     </c:forEach>
     <hr/>
      <c:forEach items="${sessionScope.categoryList}" var="category">
     	${category.id}|${category.type}|${category.hot}<br/>
     </c:forEach>
     <hr/>
      <c:forEach items="${applicationScope.categoryList}" var="category">
     	${category.id}|${category.type}|${category.hot}<br/>
     </c:forEach>
     
     
  </body>
</html>
