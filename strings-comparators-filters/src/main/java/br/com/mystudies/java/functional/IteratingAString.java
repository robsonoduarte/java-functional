package br.com.mystudies.java.functional;

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


		// map the int to char
		str.chars()
			.mapToObj(ch -> valueOf((char)ch))
			.forEach(System.out::println);


		


	}



	private static void printChar(int aChar){
		System.out.println((char)aChar);
	}





}
