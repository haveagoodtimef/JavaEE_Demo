package day12;

import java.util.Date;

/**
 * 定义私有属性:
 * int id;
 * String name;
 * int age;
 * String gender;
 * int salary;
 * Date hiredate;//入职时间
 * 
 * 定义构造方法，以及属性get,set方法.
 * 
 * 定义toString方法，格式如:
 *    id:1,姓名:张三,年龄:25,性别:男,薪资:5000,入职时间:2006-02-15
 * 
 * 定义equals方法，要求id相同，则认为内容一致。
 *
 */
public class Emp {
	private int id;
	private String name;
	private int age;
	private String gender;
	private int salary;
	private Date hiredate;
	
	public Emp() {
		super();
	}

	public Emp(int id, String name, int age, String gender, int salary, Date hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized int getAge() {
		return age;
	}

	public synchronized void setAge(int age) {
		this.age = age;
	}

	public synchronized String getGender() {
		return gender;
	}

	public synchronized void setGender(String gender) {
		this.gender = gender;
	}

	public synchronized int getSalary() {
		return salary;
	}

	public synchronized void setSalary(int salary) {
		this.salary = salary;
	}

	public synchronized Date getHirdate() {
		return hiredate;
	}

	public synchronized void setHirdate(Date hirdate) {
		this.hiredate = hirdate;
	}
	/*
	 *  定义toString方法，格式如:
 *    id:1,姓名:张三,年龄:25,性别:男,薪资:5000,入职时间:2006-02-15
 * 
 * 定义equals方法，要求id相同，则认为内容一致。
	 */

	@Override
	public String toString() {
		return "id = " +id +","+"姓名:"+name +","+ "年龄:"+ age+"," +"性别:"+gender+"," +"薪资:"+salary+"," +"入职时间:"+hiredate;
	}

	public boolean equals(int id) {
		return this.id == id;
	}
	
	
}
