package com.company.yedam.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =  //ApplicationContext가 스프링 컨테이너   
				new GenericXmlApplicationContext("applicationContext.xml");
//		TV tv = (TV)factory.getBean("tv"); name(=id), class타입 으로 검색할수있다 
		TV tv = factory.getBean(TV.class);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
