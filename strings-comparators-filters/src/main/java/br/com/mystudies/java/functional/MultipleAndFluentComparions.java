package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class MultipleAndFluentComparions {

	public static void main(String[] args) {


		final List<Person> people = asList(
			new Person("John", 20),
			new Person("Sara", 21),
			new Person("Jane", 21),
			new Person("Creg", 35)
		);

		// the sorted example using the lambda
		printPeople("Sorted in descending order by age",
			people.stream()
				.sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
				.collect(toList())
		);



		// more fluent express using the functions in the comparator




	}







	private static void printPeople(final String message, final List<Person> people) {
		System.out.println(message);
		people.forEach(System.out::println);
	}
}


