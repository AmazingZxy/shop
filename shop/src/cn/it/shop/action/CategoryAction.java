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

//ModelDrean �˽ӿڣ�����ʵ��getModel��������������ػ�ѷ��صĶ���洢ѹ��ջ����
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{
	
	public String queryJoinAccount(){
		//�����洢��ҳ������
		pageMap = new HashMap<String,Object>();
		
		
		//���ݹؼ��ֺͷ�ҳ�Ĳ�����ѯ��Ӧ������
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		//���ݹؼ��ֲ�ѯ�ܼ�¼��	
		pageMap.put("total", categoryService.getCount(model.getType()));
		return "jsonMap";
	}
	
	
	public String deleteByIds(){
		System.out.println("ɾ����idΪ��"+ids);
		categoryService.deleteByIds(ids);//�����Ļ�����ͻ�ִ��
		inputStream =  new ByteArrayInputStream("true".getBytes());
		return "stream";//��������
	}
	
	public void save(){
		System.out.println(model);
		categoryService.save(model);
	}
	
	public void update(){
		System.out.println(model);
		categoryService.update(model);
	}
	
}
