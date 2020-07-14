package com.hello.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/7/14 21:29
 */
public class MyNameSpaceHandler extends NamespaceHandlerSupport {


	@Override
	public void init() {
		registerBeanDefinitionParser("user", new BeanDefinitionParser());
	}
}
