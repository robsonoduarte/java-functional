package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.FilenameFilter;

public class ListingSelectFilesInADirectory {

	public static void main(String[] args) {


		// use File.list with Filter in anonymous class sintaxe

		String[] files =
			new File("./src/main/resources").list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".txt");
				}
			});

		asList(files).forEach(System.out::println);







	}


}
