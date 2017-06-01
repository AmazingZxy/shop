package cn.it.shop.service;




import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryService extends BaseService<Category>{

	//查询类别信息，级联管理员
	public List<Category> queryJoinAccount(String type,int   page,int size);//分页查询
	
	public Long getCount(String type);//获得总记录数
	
	//根据ids删除多条记录
	public void deleteByIds(String  ids);
	
}
