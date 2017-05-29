<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	 <script type="text/javascript">
 	 	//alert("----");
 	 	$(function(){
 	 		$('#dg').datagrid({ 
 	 		    //请求数据的地址   
			    url:'category_queryJoinAccount.action', 
			    //显示斑马线
			    striped:true,
			    queryParams:{type:''},
			    loadMsg:'请稍后...',
			    //指定id子弹为标识符字段，再删除 更新的时候有用，翻页的时候记录不会丢失
			    idField:'id',
			    //数据显示同行
			    nowrap:true,
			    //自适应，设置后会出现水平的滚动条
			    fitColumns:true,
			    //单行显示，默认值就是true
			    singleSelect:true,
			    //设置分页
			    pagination:true,
			    pageSize:5,
			    pageList:[5,10,15,20],
				toolbar: [{
					iconCls: 'icon-add',
					text:'添加类别',
					handler: function(){
						alert('编辑按钮')
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'更新类别',
					handler: function(){
						alert('帮助按钮')
					}
				},'-',{
					iconCls: 'icon-remove',
					text:'删除类别',
					handler: function(){
						//1.判断是否有选中的记录
						var rows = $("#dg").datagrid("getSelections");
						//rows 返回被选中的行，没有任何行选址，返回空数组
						if(rows.length==0){
							//弹出提示
							$.messager.show({
								title:'错误提示',
								msg:'至少选中一行',
								timeout:'2000',
								showType:'slide'
							});
						}else{
							//执行删除的逻辑
							$.messager.confirm('删除确认对话框','是否删除选中的记录!',function(r){
								if(r){
									alert("自己实现删除的逻辑");
								}
							});
						}
					}
				},'-',{					
					text:"<input id='ss' name='search' />"				
				}],
			    
			    //同列属性，但是会被冻结在左侧
			    frozenColumns:[[
			    	{field:"zxy",checkbox:true},
			    	{field:'id',title:'编号',width:100}
			    ]],
			    //配置dg的列字段field，列字段的名称，与json的key捆绑title：列标题   
			    columns:[[    
			          
			        {field:'type',title:'产品的名称',width:100,
				        formatter:function(value,row,index){
				        	return "<span title=" +value+">"+value+"</span>"
				        }
				    },    
			        {field:'hot',title:'热点',width:100,align:'right',
			        	formatter:function(value,row,index){
			        		if(value){
			        			return "<input type='checkbox' checked='checked' disabled='disabled'/>";
			        		}else{
			        			return "<input type='checkbox' disable='true'/>";
			        		}
			        	}
			        },
			        //自己写格式吧
			        {field:'account.login',title:'所属管理员',width:100,
			        	formatter:function(value,row,index){
				        	if(row.account!=null && row.account.login!=null){
				        		return row.account.login;
				        	}
				        }
			        	
			        }    
			    ]]    
			}); 
			//把普通的文板框化成搜索的文本框
			$('#ss').searchbox({ 
			//触发查询事件
				searcher:function(value,name){ 
					//获取当前查询的关键字，通过dg加载相应的信息
					$('#dg').datagrid('load',{type:value}
					);
				}, 
				prompt:'小姐姐bilibili' 
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
