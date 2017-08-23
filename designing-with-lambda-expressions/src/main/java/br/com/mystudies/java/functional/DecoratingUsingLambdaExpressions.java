package br.com.mystudies.java.functional;


import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DecoratingUsingLambdaExpressions {


	private static final DateTimeFormatter pattern = ofPattern("yyyy-MM-dd HH:mm:ss");


	public static void main(String[] args) {

		LocalDateTime d1 = parse("2017-08-17 20:58:00", pattern);
		LocalDateTime d2 = parse("2017-08-17 20:59:00", pattern);

		System.out.println(Duration.between(d1, d2).getSeconds());
	}



}
