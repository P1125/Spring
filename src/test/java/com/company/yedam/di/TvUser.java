package com.company.yedam.di;

public class TvUser {

	public static void main(String[] args) {
		
		BeanFactory factory = new BeanFactory();
				//(tv)로 캐스팅			
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
