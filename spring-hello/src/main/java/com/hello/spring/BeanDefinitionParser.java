package com.hello.spring;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;


/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/7/14 21:23
 */
public class BeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class getBeanClass(Element element){
		return CustomUser.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String userName = element.getAttribute("userName");
		String email = element.getAttribute("email");

		// 将提取的数据放到BeanDefinitionBuilder中
		if(StringUtils.hasText(userName)){
			builder.addPropertyValue("userName",userName);
		}
		if(StringUtils.hasText(email)){
			builder.addPropertyValue("email",email);
		}

	}
}
