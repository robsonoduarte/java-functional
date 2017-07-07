package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.List;

public class JoiningElements {

	public static void main(String[] args) {

		final List<String> friends =
				asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");


		// Using only the old JDK libraries
		for (String friend : friends) {
			System.out.print(friend +  ", ");
		}
		System.out.println();


		// To remove the comma at the end
		for (int i = 0; i < friends.size() - 1; i++) {
			System.out.print(friends.get(i) + ", ");
		}
		if(friends.size() > 0)
			System.out.println(friends.get(friends.size() - 1));


		// use the method add in String in Java 8
		System.out.println(String.join(", ", friends));

		
		
	}

}
