package com.wisdom.leaf.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


public interface IClockConvertor {
	
	@GetMapping(path = "convert")
	@ResponseBody
	String clockConvertor(@RequestParam(required = false, name = "time") String time);
			

}
