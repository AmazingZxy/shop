package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//ModelDrean 此接口，必须实现getModel方法，这个方法呢会把返回的对象存储压到栈顶中
public class CategoryAction extends BaseAction<Category>{
	
	
//	private Category category;	
	
	


	public String update(){
		System.out.println("-----update---");
		System.out.println(categoryService);
		System.out.println(model);
//		categoryService.update(category);
		return "index";
	}
	public String save(){
		System.out.println("-----save---");
		System.out.println(categoryService);
		return "index";
	}
	
	public String query(){
		System.out.println(ActionContext.getContext().getValueStack());
		//解决方案1 ，采用map取代了原来的内置对象，这样与jsp没有依赖，但是这样代码量会增大
//		ActionContext.getContext().put("categoryList",categoryService.query());
//		ActionContext.getContext().getSession().put("categoryList",categoryService.query());
//		ActionContext.getContext().getApplication().put("categoryList",categoryService.query());
		
		//方案二  实现相应的接口，让相应的map注入，但是如果接口实现卸载子类，代码凉的话比较大，所以基于这种我们改第三种方法
		request.put("categoryList",categoryService.query());
		session.put("categoryList",categoryService.query());
		application.put("categoryList",categoryService.query());
		return "index";
	}
	
	
	
}
