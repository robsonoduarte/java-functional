package br.com.mystudies.java.functional;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class DealingWithExceptions {

	public static void main(String[] args) {

		/*
		 * we have two options with exceptions in lambda expression
		 *
		 * 1 - Handle the exception right there within the lambda expression
		 *
		 * 2 - Catch in and rethrow it as an unchecked  exception
		 */


		// second option
		Stream.of("C:", "E:")
			.map(path -> {
				try {
					return new File(path).getCanonicalPath();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}).forEach(System.out::println);

	}
}
