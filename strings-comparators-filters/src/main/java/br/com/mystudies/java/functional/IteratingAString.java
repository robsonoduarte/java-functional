package br.com.mystudies.java.functional;

import static java.lang.Character.isDigit;
import static java.lang.Character.valueOf;

public class IteratingAString {

	public static void main(String[] args) {

		final String str = "w00t";

		// print only the numbers of chars
		str.chars()
			.forEach(System.out::println);


		// print the letter
		str.chars()
			.forEach(IteratingAString::printChar);


		// map to object -> of int to char
		str.chars()
			.mapToObj(ch -> valueOf((char)ch))
			.forEach(System.out::println);


		// using filter in stream

		str.chars()
			.filter(ch -> isDigit(ch))
			.forEach(ch -> printChar(ch));


		// use the reference methods
		str.chars()
			.filter(Character::isDigit)
			.forEach(IteratingAString::printChar);

	}



	private static void printChar(int aChar){
		System.out.println((char)aChar);
	}

}
