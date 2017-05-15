package cn.it.shop.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.util.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService {
	
private  SessionFactory sessionFactory;
	
	protected Session getSession(){
		//从当前线程获取session，如果没有则创建新session
	
		return sessionFactory.getCurrentSession();
	}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		//通过工具类回去session
		
			Session session = HibernateSessionFactory.getSession();
			try{
				//手动事物
				session.getTransaction().begin();
				//执行业务逻辑			
				session.save(category);			
				//手东提交
				session.getTransaction().commit();			
			}catch(Exception e){
				session.getTransaction().rollback();
				throw new RuntimeException(e);
			}finally{
				HibernateSessionFactory.closeSession();
			}

	}
	
	public void update(Category category) {
		getSession().update(category);
	}

}
