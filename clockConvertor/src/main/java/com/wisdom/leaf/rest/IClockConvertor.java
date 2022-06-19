package com.wisdom.leaf.rest;

import org.springframework.web.bind.annotation.GetMapping;


public interface IClockConvertor {
	
	@GetMapping(path = "convert")
//	@ResponseBody
	public String clockConvertor();
			

}
