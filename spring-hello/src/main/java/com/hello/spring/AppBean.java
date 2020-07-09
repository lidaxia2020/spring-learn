package com.hello.spring;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppBean {

	public static void main(String[] args) {
		String path = AppBean.class.getResource("/").getPath();
		System.out.println("args = " + path);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:mybean.xml");
		MyBean myBean = ctx.getBean(MyBean.class);
		System.out.println("myBean = " + myBean);
	}
}
