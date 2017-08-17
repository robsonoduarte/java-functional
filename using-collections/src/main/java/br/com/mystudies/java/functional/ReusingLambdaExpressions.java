package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.function.Predicate;

public class ReusingLambdaExpressions {

	public static void main(String[] args) {


		final List<String> friends =
				asList("Brian","Nate","Neal","Raju","Sara","Scott");


		final List<String> editors =
				asList("Brian", "Jackie", "John", "Mike");


		final List<String> comrades =
				asList("Kate","Ken", "Nick", "Paula", "Zach");


		// USING THE 3 LAMBADA EXPRESSION IN WITCH STREAM

		long countFriendsStartN =
				friends.stream()
					.filter(name -> name.startsWith("N"))
					.count();

		long countEditorsStartN =
				editors.stream()
				.filter(name -> name.startsWith("N"))
				.count();

		long countComradesStartN =
				comrades.stream()
				.filter(name -> name.startsWith("N"))
				.count();


		System.out.println(countFriendsStartN);
		System.out.println(countEditorsStartN);
		System.out.println(countComradesStartN);


		// USING THE 1 LAMBDA EXPRESSION IN WITCH STREAM WITH THE PRECIDATE

		final Predicate<String> startsWithN = name -> name.startsWith("N");

		countFriendsStartN =
				friends.stream()
					.filter(startsWithN)
					.count();

		countEditorsStartN =
				editors.stream()
				.filter(startsWithN)
				.count();

		countComradesStartN =
				comrades.stream()
				.filter(startsWithN)
				.count();


		System.out.println(countFriendsStartN);
		System.out.println(countEditorsStartN);
		System.out.println(countComradesStartN);

	}
}
