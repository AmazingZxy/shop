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

//ModelDrean �˽ӿڣ�����ʵ��getModel��������������ػ�ѷ��صĶ���洢ѹ��ջ����
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
		//�������1 ������mapȡ����ԭ�������ö���������jspû����������������������������
//		ActionContext.getContext().put("categoryList",categoryService.query());
//		ActionContext.getContext().getSession().put("categoryList",categoryService.query());
//		ActionContext.getContext().getApplication().put("categoryList",categoryService.query());
		
		//������  ʵ����Ӧ�Ľӿڣ�����Ӧ��mapע�룬��������ӿ�ʵ��ж�����࣬�������Ļ��Ƚϴ����Ի����������Ǹĵ����ַ���
		request.put("categoryList",categoryService.query());
		session.put("categoryList",categoryService.query());
		application.put("categoryList",categoryService.query());
		return "index";
	}
	
	
	
}
