package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �����������ת���Ĺ��ܣ����Բ������κε��߼�<p>Title:SendAction </p>
  * <p>Description: </p>
  * <p>Company: </p> 
  * @author AmazingZ
  * @date 2017-5-18����2:48:59
 */
@Controller
public class SendAction extends ActionSupport{
	
	public String execute(){
		return "send";
	}
}
