package com.company.yedam.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{

	@Autowired 
	@Qualifier("appleSpeaker") //따로지정안하면 첫글자만 소문자로 바꾸면됨
	Speaker speaker; 
	//두개중 선택할때 사용
	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV powerDown");
	}
	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
