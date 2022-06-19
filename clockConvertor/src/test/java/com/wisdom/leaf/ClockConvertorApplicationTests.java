package com.wisdom.leaf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisdom.leaf.service.IClockConvertorService;

@SpringBootTest
class ClockConvertorApplicationTests   {
	@Autowired
	private IClockConvertorService ICS;

	@Test
	void contextLoads() {
	
		System.out.println(ICS.checking());
	}

}
