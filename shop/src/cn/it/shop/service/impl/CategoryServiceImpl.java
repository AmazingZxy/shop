package cn.it.shop.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	
	//查询热点类别
	public CategoryServiceImpl(){
		super();
	}

	

	

	@Override
	public List<Category> queryJoinAccount(String type,int   page,int size) {
		return getSession().createQuery("FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE :type")
		.setString("type", "%"+type+"%")
		.setFirstResult((page-1)*size)
		.setMaxResults(size)
		.list();
		
		
	}

	@Override
	public Long getCount(String type) {
		String hql="SELECT count(c) FROM Category c WHERE c.type LIKE :type";
	    return 	(Long) getSession().createQuery(hql)
		.setString("type", "%"+type+"%")
		.uniqueResult();
		
	}

	@Override
	public void deleteByIds(String ids) {
		//这样写由于setString设置最后是int ,所以只能删除第一个
		//String hql = "DELETE from Category WHERE id in (:ids)";
		//getSession().createQuery(hql).setString("ids", ids).executeUpdate();
		String hql = "DELETE from Category WHERE id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
		
	}
	
	

}
