package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class UsingTheCollectMethodAndTheCollectorsClass {




	public static void main(String[] args) {

		final List<Person> people = asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Creg", 35)
			);


		// collect  using mutability and forEach()

		final List<Person> olderThan20 = new ArrayList<>();

		people.stream()
			.filter(p -> p.getAge() > 20)
			.forEach(p -> olderThan20.add(p));


		System.out.println("People older than 20: " + olderThan20);

	}



}
