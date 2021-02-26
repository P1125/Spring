package com.company.yedam.di;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.yedam.config.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {  AppConfig.class }) //classes가 배열이라 { }
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class TvUserClient {
	@Autowired TV tv;
	@Autowired TV tv2;

	//@Test
	public void singleTest() {
		assertEquals(tv, tv2);
	}
	@Test
	public void tvtest() {
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
	
}
