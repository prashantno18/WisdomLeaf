package com.wisdom.leaf.service.impl;

import org.springframework.stereotype.Service;

import com.wisdom.leaf.service.IClockConvertorService;

@Service("ClockConvertorServiceImpl")
public class ClockConvertorServiceImpl implements IClockConvertorService{

	@Override
	public String checking() {
		return "Method Is reachable";
	}
	
	
	

}
