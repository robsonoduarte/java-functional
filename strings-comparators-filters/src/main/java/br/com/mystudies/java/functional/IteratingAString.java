package br.com.mystudies.java.functional;

public class IteratingAString {

	public static void main(String[] args) {

		final String str = "w00t";

		// print only the numbers of chars
		str.chars()
			.forEach(System.out::println);


		// print the letter
		str.chars()
			.forEach(IteratingAString::printChar);

	}



	private static void printChar(int aChar){
		System.out.println((char)aChar);
	}





}
