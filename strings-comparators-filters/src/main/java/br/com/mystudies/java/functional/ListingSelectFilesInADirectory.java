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


		// use File.list with Filter in anonymous class syntax
		final String[] files1 =
			new File("./src/main/resources").list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".txt");
				}
			});

		asList(files1).forEach(System.out::println);

      // change to the lambda
		String[] files2 =
				new File("./src/main/resources").list((dir,name) -> name.endsWith(".txt"));

		asList(files2).forEach(System.out::println);

	//--------------------------------------------------------------------------------------------------


	 // using the Files.newDirectoryStream with anonymous class syntax
		Files.newDirectoryStream(get("./src/main/resources"),
			new DirectoryStream.Filter<Path>(){
				@Override
				public boolean accept(Path path) throws IOException {
					return path.toString().endsWith(".txt");
				}
		}).forEach(System.out::println);


	  // change to the lambda
		Files.newDirectoryStream(
				get("./src/main/resources"),p -> p.toString().endsWith(".txt")
			).forEach(System.out::println);



	//--------------------------------------------------------------------------------------------------











	}


}
