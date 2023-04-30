package com.sk.relations;

public class PersonController {

	public static void main(String[] args) {
		
		Person p=new Person();
		p.setId(2);
		p.setName("balraj");
		p.setMarks(45);
		
		Address a=new Address();
		a.setId(102);
		a.setCity("indore");
		a.setState("mp");
		
		//setting address object to person object
		p.setAddress(a);
		
		PersonDao dao=new PersonDao();
		dao.save(p, a);
	}
	
	
	
	
	
}
