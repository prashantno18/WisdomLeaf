package com.wisdom.leaf.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wisdom.leaf.constants.TimeConstants;
import com.wisdom.leaf.service.IClockConvertorService;

@Service("ClockConvertorServiceImpl")
public class ClockConvertorServiceImpl implements IClockConvertorService {

	private Logger logger = LogManager.getLogger(ClockConvertorServiceImpl.class);

	@Override
	public String clockConvertor(String time) {

		try {
			if (time != null) {
				int hour = Integer.parseInt(time.split(":")[0]);

				int minute = time.split(":").length > 1 ? Integer.parseInt(time.split(":")[1]) : 00;

				int nextHour = hour % 12;

				String[] numberWords = getTimeInWords();
				if (hour < 24 && minute < 60) {

					if (hour == 00) {
						return midnight(minute, nextHour, numberWords);
					}
					if (hour == 12) {

						return midday(minute, nextHour, numberWords);
					} else {

						return dayTime(hour, minute, nextHour, numberWords);
					}
				} else {
					
					return TimeConstants.NOT_VALID;
				}
			}
		} catch (NumberFormatException e) {

			return "Time Formate is not vaild";
		} catch (Exception e) {

			e.printStackTrace();
		}
		return time;

	}

	private String midnight(int minute, int nextHour, String[] numberWords) {
		if (minute == 00) {

			return TimeConstants.ITS +TimeConstants.MIDNIGHT;
		} else {
			return TimeConstants.ITS + numberWords[nextHour + 12] + " " + numberWords[minute];
		}
	}

	private String midday(int minute, int nextHour, String[] numberWords) {
		if (minute == 00) {

			return TimeConstants.ITS +TimeConstants.MIDDAY;
		} else {

			return TimeConstants.ITS + numberWords[12] + " " + numberWords[minute];
		}
	}

	private String dayTime(int hour, int minute, int nextHour, String[] numberWords) {
		if (minute != 0) {

			return TimeConstants.ITS + numberWords[nextHour] + " " + numberWords[minute];
		} else {

			return TimeConstants.ITS + numberWords[nextHour] + " o'clock ";
		}
	}

	private static String[] getTimeInWords() {
		String[] numberWords = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
				"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
				"twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one",
				"thirty two", "thirty three", "thirty four", "thirty five", "thirty six", "thirty seven",
				"thirty eight", "thirty nine", "fourty", "fourty one", "fourty two", "fourty three", "fourty four",
				"fourty five", "fourty six", "fourty seven", "fourty eight", "fourty nine", "fifty", "fifty one",
				"fifty two", "fifty three", "fifty four", "fifty five", "fifty six", "fifty seven", "fifty eight",
				"fifty nine" };
		return numberWords;
	}

}
