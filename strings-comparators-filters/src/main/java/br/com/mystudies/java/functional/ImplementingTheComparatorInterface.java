package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

public class ImplementingTheComparatorInterface {


	public static void main(String[] args) {


		final List<Person> people = asList(
					new Person("John", 20),
					new Person("Sara", 21),
					new Person("Jane", 21),
					new Person("Creg", 35)
				);


		// using the sorted method to apply comparator
		List<Person> ascendingAge =
				people.stream()
					.sorted(Person::ageDifference)
					.collect(toList());

		printPeople("Sorted in ascending order by age: ", ascendingAge);



		// sorting in descending
		List<Person> descending = people.stream()
			.sorted((p1,p2) -> p2.ageDifference(p1))
			.collect(toList());


		printPeople("Sorted in descending order by age: ", descending);


		// Reusing the comparator with reversed default method

		Comparator<Person> compareAscending = (p1,p2) -> p1.ageDifference(p2);
		Comparator<Person> compareDescending = compareAscending.reversed();


		printPeople("Sorted in ascending order by age:",
				people.stream()
					.sorted(compareAscending)
					.collect(toList())
			);

		printPeople("Sorted in descending order by age:",
				people.stream()
					.sorted(compareDescending)
					.collect(toList())
			);


	}





	private static void printPeople(final String message, final List<Person> people) {
		System.out.println(message);
		people.forEach(System.out::println);
	}



}

