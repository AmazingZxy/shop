package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//ModelDrean 此接口，必须实现getModel方法，这个方法呢会把返回的对象存储压到栈顶中
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{
	
	public String queryJoinAccount(){
		//用来存储分页的数据
		pageMap = new HashMap<String,Object>();
		
		
		//根据关键字和分页的参数查询相应的数据
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		//根据关键字查询总记录数	
		pageMap.put("total", categoryService.getCount(model.getType()));
		return "jsonMap";
	}
	
	
	public String deleteByIds(){
		System.out.println("删除的id为："+ids);
		categoryService.deleteByIds(ids);//过来的话下面就会执行
		inputStream =  new ByteArrayInputStream("true".getBytes());
		return "stream";//用流返回
	}
	
	public void save(){
		System.out.println(model);
		categoryService.save(model);
	}
	
	public void update(){
		System.out.println(model);
		categoryService.update(model);
	}
	
	public String query(){
//		System.out.println(model);
		jsonList = categoryService.query();
		return "jsonList";
	}
	
}
