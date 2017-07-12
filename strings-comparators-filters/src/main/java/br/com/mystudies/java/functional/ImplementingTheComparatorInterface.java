package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class ImplementingTheComparatorInterface {


	public static void main(String[] args) {


		final List<Person> people = asList(
					new Person("John", 20),
					new Person("Sara", 21),
					new Person("John", 21),
					new Person("John", 35)
				);


		// using the sorted method to apply comparator
		List<Person> ascendingAge =
				people.stream()
					.sorted(Person::ageDifference)
					.collect(toList());

		printPeople("Sorted in ascending order by age: ", ascendingAge);

	}






	private static void printPeople(final String message, final List<Person> people) {
		System.out.println(message);
		people.forEach(System.out::println);
	}



}

