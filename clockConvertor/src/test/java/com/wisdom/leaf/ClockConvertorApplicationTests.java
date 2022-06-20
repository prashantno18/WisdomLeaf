package com.wisdom.leaf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisdom.leaf.rest.IClockConvertor;

@SpringBootTest
class ClockConvertorApplicationTests   {
	@Autowired
	private IClockConvertor ICR;

	@Test
	void notValidTimeFormate() {
	
		assertEquals("Time Formate is not vaild",ICR.clockConvertor("10.11"));
	}
	
	@Test
	void validTimeFormate() {
	
		assertEquals("It's ten eleven",ICR.clockConvertor("10:11"));
	}
	
	@Test
	void pleaseEnterValidTime() {
	
		assertEquals("Please enter the valid time",ICR.clockConvertor(""));
	}
	
	@Test
	void inValidTime() {
	
		assertEquals("Not Valid",ICR.clockConvertor("122:22"));
	}
	
	@Test
	void midday() {
	
		assertEquals("It's Midday",ICR.clockConvertor("12:00"));
	}
	
	@Test
	void midnight() {
	
		assertEquals("It's Midnight",ICR.clockConvertor("00:00"));
	}

}
