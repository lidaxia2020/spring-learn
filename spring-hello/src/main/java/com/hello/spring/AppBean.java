package com.hello.spring;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.beans.Introspector;

public class AppBean {

	/**
	 * UserService.class---)推断构造方法.-)普通对象--》依赖注入--》初始化(fterPropertiesSet) .--)初始化后 (AOP) --)代理对象
	 * 放入Map<beanName，Bean对象
	 * UserServiceProxy对象===UserService代理对象--->UserService代理对象.target=普通对象
	 * * *
	 * @param args
	 */
	public static void main(String[] args) {
		String path = AppBean.class.getResource("/").getPath();
		System.out.println("args = " + path);
		// classpath:
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mybean.xml");
		MyBean myBean = ctx.getBean(MyBean.class);
		MyBean myBean1 = ctx.getBean(MyBean.class);
		System.out.println("myBean = " + myBean);

		BeanFactory beanFactory = new ClassPathXmlApplicationContext("mybean.xml");
		MyBean bean = beanFactory.getBean(MyBean.class);
		System.out.println(  myBean1 == myBean);

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.hello.spring");
		UserService userService = applicationContext.getBean(UserService.class);
		System.out.println(userService);
	}
}
