package cn.it.shop.service.impl;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryServiceImplTest {

	@Resource
	private CategoryService categoryService;

	@Test
	public void testSave() {
		categoryService.save(new Category("≤‚ ‘“ªœ¬",true));
	}

	@Test
	public void testUpdate() {
		categoryService.update(new Category(5,"≤‚ ‘33",true));
		
	}

	
	@Test
	public void testGet() {
		System.out.println(categoryService.get(5));
	}

	@Test
	public void testQuery() {
		for(Category temp:categoryService.query()){
			System.out.println(temp);
		}
	}
	
	@Test
	public void testDelete() {
		categoryService.delete(5);
	}
	
	@Test
	public void testqueryAccount() {
		for(Category temp:categoryService.queryJoinAccount("")){
			System.out.println(temp);
			System.out.println(temp.getAccount());
		}
	}


}
