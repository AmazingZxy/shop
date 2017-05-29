package cn.it.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * <p>Title:BaseAction </p>
 * 
 * �ȴ���Action���ڵ���������������Struts����������
 * ����Ŀ��������ʱ��struts��������һ������Ӧ�����ö�������ö����Ӧ��map����Application
 * ���ʵ������Ӧ��***Aware�Ľӿڣ��ͻ��Application��ȡ��Ӧ��map������������servletConfig
 * servletConfig��ʵ��ʲô�ӿڣ�ע��ʲô����
  * <p>Description: </p>
  * <p>Company: </p> 
  * @author AmazingZ
  * @date 2017-5-17����10:00:26
 */
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware, ModelDriven<T>{
	
	protected T model;
	
	protected  String ids;//��ȡ��ɾ����ids
	//�������أ��� jsonһ������
	protected InputStream inputStream ;
		

	protected Integer page;
	
	protected Integer rows;
	
	public Map<String,Object> pageMap = null;

	

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
	
	//�����service�ǵ����ģ����Բ��õ���ÿ�ζ��ᴴ��һ�飬��ʵ����ֻ��Ҫ��ʼ��ʱ�򴴽�һ��ͺ���
	@Resource
	protected CategoryService categoryService;
	
	@Resource
	protected AccountService accountService;
		
	
	

//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}
//
//	public void setCategoryService(CategoryService categoryService) {
//		this.categoryService = categoryService;
//	}
	
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
	
	

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
	public Map<String, Object> getPageMap() {
		System.out.println("-------------------pageMap-------------------------");
		return pageMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		
		this.pageMap = pageMap;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	
	

}
