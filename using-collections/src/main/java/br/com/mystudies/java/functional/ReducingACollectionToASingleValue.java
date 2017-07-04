package br.com.mystudies.java.functional;

import static java.lang.String.format;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ReducingACollectionToASingleValue {

	public static void main(String[] args) {

		final List<String> friends =
				asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");


		// example of map/reduce using the mapToInt and sum
		System.out.println("Total number of characters in all names: " +
		 friends.stream()
			.mapToInt(String::length)
			.sum());




		// common lambda for next examples
		BinaryOperator<String> isLongerThan = (n1,n2) -> n1.length() >= n2.length() ? n1 : n2;


		// example of reduce using the reduce method
		Optional<String> aLongName =
				friends.stream()
					.reduce(isLongerThan);

		aLongName.ifPresent(name -> System.out.println(format("A longest name: %s", name)));


		// example of variation of reduce with default value

		String steveOrLonger =
				friends.stream()
					.reduce("Steve", isLongerThan);

		System.out.println("Steve or Longer -> " + steveOrLonger);

	}


}
