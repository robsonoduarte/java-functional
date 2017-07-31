package br.com.mystudies.java.functional;

import static java.nio.file.Paths.get;

import java.io.IOException;
import java.nio.file.Files;

public class ListingAllFilesInADirectory {

	public static void main(String[] args) throws IOException {

		// list all files in current directory
		Files.list(get("."))
			.forEach(System.out::println);

		// using one filter to get only directories
		Files.list(get("."))
			.filter(Files::isDirectory)
			.forEach(System.out::println);
	}
}
