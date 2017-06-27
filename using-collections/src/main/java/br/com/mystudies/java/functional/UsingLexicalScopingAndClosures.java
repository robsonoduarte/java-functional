package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsingLexicalScopingAndClosures {


	public static void main(String[] args) {

		final List<String> friends =
				asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");


		// Duplication in Lambada Expressions

		final Predicate<String> startsWithB = name -> name.startsWith("B");
		final Predicate<String> startsWithN = name -> name.startsWith("N");


		System.out.println(friends.stream().filter(startsWithB).count());
		System.out.println(friends.stream().filter(startsWithN).count());


		// Removing Duplication with Lexical Scoping


		// the full sintaxe
/*		final Function<String, Predicate<String>> startsWithLetter =
				(String letter) -> {
					Predicate<String> checkstarts = (String name) -> name.startsWith(letter);
					return checkstarts;
				};*/

		// using the lambda function
		final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

		System.out.println(friends.stream().filter(startsWithLetter.apply("B")).count());
		System.out.println(friends.stream().filter(startsWithLetter.apply("N")).count());




	}




}
