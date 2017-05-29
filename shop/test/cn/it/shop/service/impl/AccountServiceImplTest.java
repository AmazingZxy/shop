package cn.it.shop.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class AccountServiceImplTest {

	@Resource
	private AccountService accountService;

	@Test
	public void testSave() {
		accountService.save(new Account("admin", "¥Û«ø", "aaa"));
	}

	@Test
	public void testQuery(){
		List<Account> list = accountService.query();
		for(Account a:list){
			System.out.println(a.getLogin());
		}
	}


}
