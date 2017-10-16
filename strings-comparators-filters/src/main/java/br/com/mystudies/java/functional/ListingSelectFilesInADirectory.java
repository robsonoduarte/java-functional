package br.com.mystudies.java.functional;

import static java.nio.file.Paths.get;
import static java.util.Arrays.asList;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListingSelectFilesInADirectory {

	public static void main(String[] args) throws IOException {
		
		final String resources = "./src/main/resources";

		// use File.list with Filter in anonymous class syntax
		print(
			new File(resources).list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".txt");
				}
			}));

      		// change to the lambda
		print(new File(resources).list((dir,name) -> name.endsWith(".txt")));

	//--------------------------------------------------------------------------------------------------

	 	// using the Files.newDirectoryStream with anonymous class syntax
		Files.newDirectoryStream(get(resources),
			new DirectoryStream.Filter<Path>(){
				@Override
				public boolean accept(Path path) throws IOException {
					return path.toString().endsWith(".txt");
				}
		}).forEach(System.out::println);


	  	// change to the lambda
		Files.newDirectoryStream(
				get(resources),p -> p.toString().endsWith(".txt")
			).forEach(System.out::println);


	//--------------------------------------------------------------------------------------------------

		// get files based on the properties with one FileFilter ( only using the lambda expression )
		print(new File(resources).listFiles(file -> file.isHidden()));


		// change to the method reference
		print(new File(resources).listFiles(File::isHidden));

	}









	private static void print(File[] files) {
		asList(files).forEach(System.out::println);
	}

	private static void print(final String[] files) {
		asList(files).forEach(System.out::println);
	}
}
