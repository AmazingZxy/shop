package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Account;
import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//ModelDrean 此接口，必须实现getModel方法，这个方法呢会把返回的对象存储压到栈顶中
@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account>{
	
	
	public String query(){
		//System.out.println(model);
		jsonList = accountService.query();
		return "jsonList";
	}
	
	
	
}
