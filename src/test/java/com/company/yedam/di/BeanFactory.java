package com.company.yedam.di;


public class BeanFactory { //생성해서 공급해주는객체.
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
