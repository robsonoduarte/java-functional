package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsingTheCollectMethodAndTheCollectorsClass {




	public static void main(String[] args) {

		final List<Person> people = asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Creg", 35)
			);


		// collect  using mutability and forEach()
		final List<Person> list1 = new ArrayList<>();

		people.stream()
			.filter(p -> p.getAge() > 20)
			.forEach(p -> list1.add(p));


		System.out.println("People older than 20: " + list1);


		// using the collect method to take the list without mutability
		List<Person> list2 =
				people.stream()
					.filter(p -> p.getAge() > 20)
					.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		System.out.println("People older than 20: " + list2);


		// using the collect method and Collectors.toList
		List<Person> list3 =
				people.stream()
					.filter(p -> p.getAge() > 20)
					.collect(toList());

		System.out.println("People older than 20: " + list3);



		// using the collect method and Collectors.groupingBy
		Map<Integer, List<Person>> peopleByAge =
				people.stream()
				.collect(groupingBy(Person::getAge));

		System.out.println("Grouped by age : " + peopleByAge);




		// get the only Person's name with one downstream
		Map<Integer, List<String>> nameOfPeopleByAge =
				people.stream()
				.collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));

		System.out.println("People grouped by age : " + nameOfPeopleByAge);



		// Group by first letter and reduce with the maximum age

		Map<Character, Optional<Person>> oldestPersonOfEachLetter =
				people.stream()
					.collect(groupingBy(p -> p.getName().charAt(0), reducing(maxBy(comparing(Person::getAge)))));

		System.out.println("Oldest person of each letter " + oldestPersonOfEachLetter);

	}























}
