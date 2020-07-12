package com.hello.spring;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AppBean {

	public static void main(String[] args) {
		String path = AppBean.class.getResource("/").getPath();
		System.out.println("args = " + path);
		// classpath:
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mybean.xml");
		MyBean myBean = ctx.getBean(MyBean.class);
		System.out.println("myBean = " + myBean);

		ClassPathResource classPathResource = new ClassPathResource("mybean.xml");
		BeanFactory beanFactory = new XmlBeanFactory(classPathResource);
		MyBean bean = beanFactory.getBean(MyBean.class);
		System.out.println("bean = " + bean);

	}
}
