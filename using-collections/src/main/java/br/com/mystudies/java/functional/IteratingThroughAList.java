package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.function.Consumer;

public class IteratingThroughAList {

	public static void main(String[] args) {

		final List<String> friends =
				asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		// the habitual, but not so desirable, way to iterate
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}

		// foreach ( since java 5 )
		for (String name : friends) {
			System.out.println(name);
		}

		// foreach() of Interable interface ( since java 8 ) with the anonymous inner class
		friends.forEach(new Consumer<String>() {
			@Override
			public void accept(final String name) {
				System.out.println(name);
			}
		});


		// foreach() with lambda expression
		friends.forEach((final String name) -> System.out.println(name));

		// compiler can infer the type
		friends.forEach((name) -> System.out.println(name));

		// compiler treats single-parameter lambda expression as special
		friends.forEach(name -> System.out.println(name));


		// with method reference
		friends.forEach(System.out::println);
	}
	
	
}
