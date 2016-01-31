package com.demo.client.model;

public class ClientInfo {
	private PersonalInfo personal;
	private SalaryInfo work;
	private PostalInfo address;
	public PersonalInfo getPersonal() {
		return personal;
	}
	public void setPersonal(PersonalInfo personal) {
		this.personal = personal;
	}
	public SalaryInfo getWork() {
		return work;
	}
	public void setWork(SalaryInfo work) {
		this.work = work;
	}
	public PostalInfo getAddress() {
		return address;
	}
	public void setAddress(PostalInfo address) {
		this.address = address;
	}
	
	
}
