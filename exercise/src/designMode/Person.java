package designMode;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Person extends PersonFather {

	{
		fields = Arrays.asList(new PersonParser().getMetadata());
	}

	public Object get(String attr) {
		int x = fields.indexOf(attr);
		return get(x + 1);
	}

	public void set(String attr, Object obj){
		int x = fields.indexOf(attr);
		this.set(x + 1, obj);
	}
	
	public Object get(int index) {
		String attrName = fields.get(index - 1);
		Object result = null;
		try {
			Field field = this.getClass().getDeclaredField(attrName);
			result = field.get(this);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void set(int index, Object obj) {
		String attrName = fields.get(index - 1);
		try {
			this.getClass().getDeclaredField(attrName).set(this, obj);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	private String name;
	private String email;
	private String address;
	private String job;
	private String hobits;
	private int age;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobits() {
		return hobits;
	}

	public void setHobits(String hobits) {
		this.hobits = hobits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
