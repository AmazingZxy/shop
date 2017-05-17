package cn.it.shop.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sun.reflect.generics.tree.ReturnType;

import cn.it.shop.model.Category;
import cn.it.shop.service.BaseService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.util.HibernateSessionFactory;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<T>  implements BaseService<T> {
	


	private Class clazz;//class记录了当前传入的对象
	
	public BaseServiceImpl() {
		
		System.out.println("this代表的是当前你调用构造方法的对象"+this);
		System.out.println("获取当前this的弗雷的信息"+this.getClass().getSuperclass());
		System.out.println("获取当前this对象的父类信息（包括泛型"+this.getClass().getGenericSuperclass());
		// TODO Auto-generated method stub
		//得到当前泛型对象
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	

	private  SessionFactory sessionFactory;
	
	//继承机制，这个依赖了，下面继承的子类就不用依赖SessionFac
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		//从当前线程获取session，如果没有则创建新session
	
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Object t) {
		getSession().save(t);
		
	}

	@Override
	public void update(Object t) {
		getSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		
		String hql = "DELETE "+clazz.getSimpleName()+" WHERE id=:id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
		
	}

	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	
	@Override
	public List<T> query() {
		
		String hql = "FROM "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}
	


}
