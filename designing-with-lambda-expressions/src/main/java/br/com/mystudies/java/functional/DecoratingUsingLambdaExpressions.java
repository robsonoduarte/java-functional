package br.com.mystudies.java.functional;


import static java.time.Duration.between;
import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DecoratingUsingLambdaExpressions {


	private static final DateTimeFormatter PATTERN = ofPattern("yyyy-MM-dd HH:mm:ss");


	public static void main(String[] args) {

		LocalDateTime d1 = parse("2017-08-17 20:58:00", PATTERN);
		LocalDateTime d2 = parse("2017-08-17 20:59:00", PATTERN);

		System.out.println(between(d1, d2).getSeconds());
		// or
		System.out.println(SECONDS.between(d1, d2));

	}



}
