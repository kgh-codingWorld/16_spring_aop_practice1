package com.application.aop.practice1.chapter01_aop;

import org.springframework.stereotype.Component;

@Component
public class Manager {

	public void work() {
		System.out.println("관리자의 일을 한다.");
	}

	public void getWorkingTime() {

		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getInfo(String title, int salary) {

		return "(return) title : " + title + " / salary : " + salary;
	}

	public void getException() {

		throw new NullPointerException();
	}

}
