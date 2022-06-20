package com.wisdom.leaf.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.leaf.constants.TimeConstants;
import com.wisdom.leaf.rest.IClockConvertor;
import com.wisdom.leaf.service.IClockConvertorService;

@Primary
@RestController
public class ClockConvertor implements IClockConvertor {

	@Autowired
	private IClockConvertorService ICS;

	@Override
	public String clockConvertor(String time) {
		
		if (time.isEmpty()) {
			return TimeConstants.PLEASE_ENTER_VAILD_TIME;
		}
		return ICS.clockConvertor(time);
	}

}
