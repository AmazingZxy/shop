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
	public void save(Category t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> queryJoinAccount(String type,int   page,int size) {
		return getSession().createQuery("FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE :type")
		.setString("type", "%"+type+"%")
		.setFirstResult((page-1)*size)
		.setMaxResults(size)
		.list();
		
		
	}
	
	

}
