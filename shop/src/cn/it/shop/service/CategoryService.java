package cn.it.shop.service;




import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryService extends BaseService<Category>{

	//��ѯ�����Ϣ����������Ա
	public List<Category> queryJoinAccount(String type,int   page,int size);//��ҳ��ѯ
	
}
