package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用来完成请求转发的功能，所以不处理任何的逻辑<p>Title:SendAction </p>
  * <p>Description: </p>
  * <p>Company: </p> 
  * @author AmazingZ
  * @date 2017-5-18下午2:48:59
 */
@Controller
public class SendAction extends ActionSupport{
	
	public String execute(){
		return "send";
	}
}
