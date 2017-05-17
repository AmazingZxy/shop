package cn.it.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * <p>Title:BaseAction </p>
 * 
 * 先创建Action，在调用拦截器，这是Struts的启动流程
 * 在项目的启动的时候struts过滤器，一级吧相应的内置对象和内置对象对应的map存在Application
 * 如果实现了相应的***Aware的接口，就会从Application中取相应的map传入拦截器：servletConfig
 * servletConfig：实现什么接口，注入什么对象
  * <p>Description: </p>
  * <p>Company: </p> 
  * @author AmazingZ
  * @date 2017-5-17下午10:00:26
 */
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware, ModelDriven<T>{
	
	protected T model;
	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T)clazz.newInstance();
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		} 
		return model;
	}
	
	//这里的service是单利的，所以不用担心每次都会创建一遍，其实他们只需要开始的时候创建一遍就好了
	protected CategoryService categoryService;
	
	protected AccountService accountService;
		
	
	

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	
	@Override
	public void setApplication(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}

	

}
