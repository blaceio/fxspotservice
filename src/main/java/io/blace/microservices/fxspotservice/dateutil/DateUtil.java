package io.blace.microservices.fxspotservice.dateutil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {

	public Date getEndOfDay(Date date) {
		  LocalDateTime localDateTime = dateToLocalDateTime(date);
		  LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
		  return localDateTimeToDate(endOfDay);
		}

		private static Date localDateTimeToDate(LocalDateTime startOfDay) {
		  return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
		}

		private static LocalDateTime dateToLocalDateTime(Date date) {
		  return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
		}
		
	
}
