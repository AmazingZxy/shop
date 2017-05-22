package cn.it.shop.service.impl;



import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	
	//查询热点类别
	public CategoryServiceImpl(){
		super();
	}
	
	

}
