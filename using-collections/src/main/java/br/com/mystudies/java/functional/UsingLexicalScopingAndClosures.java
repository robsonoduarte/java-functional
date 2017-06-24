package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.List;
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

		System.out.println(friends.stream().filter(startsWith("B")).count());
		System.out.println(friends.stream().filter(startsWith("N")).count());


	}


	public static Predicate<String> startsWith(final String letter){
		return name -> name.startsWith(letter);
	}

}
