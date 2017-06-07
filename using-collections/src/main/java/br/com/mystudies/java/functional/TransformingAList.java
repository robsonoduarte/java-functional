package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class TransformingAList {

	public static void main(String[] args) {

		final List<String> friends =
				asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");



		// imperative style
		final List<String> upperCaseNames = new ArrayList<String>();

		for (String name : friends) {
			upperCaseNames.add(name.toUpperCase());
		}
		System.out.println(upperCaseNames);


		// add functional style using the internal iterator foreach()
		friends.forEach(name -> upperCaseNames.add(name.toUpperCase()));
		System.out.println(upperCaseNames);



		// using lambda expressions with Stream interface and no explicit mutation
		friends.stream()
			.map(name -> name.toUpperCase())
			.forEach(name -> System.out.print(name + " "));


		// using method reference
		friends.stream()
			.map(String::toUpperCase)
			.forEach(name -> System.out.print(name + " "));


	}


}
