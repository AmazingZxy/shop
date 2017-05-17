package cn.it.shop.model;

import java.io.Serializable;

import org.hibernate.annotations.Entity;


@Entity
public class Account implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String login;
	private String name;
	private String pass;

	

	public Account(Integer id, String login, String name, String pass) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.pass = pass;
	}
	
	public Account(String login, String name, String pass) {
		super();
		this.login = login;
		this.name = name;
		this.pass = pass;
	}
	

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", login=" + login + ", name=" + name
				+ ", pass=" + pass + "]";
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
