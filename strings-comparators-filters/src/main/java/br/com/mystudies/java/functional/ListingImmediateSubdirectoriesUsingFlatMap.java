package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListingImmediateSubdirectoriesUsingFlatMap {


	public static void main(String[] args) {
		listInImperativeSytle();
		listInFunctionalStyle();
	}





    // list files in the imperative style
	public static void listInImperativeSytle(){
		List<File> files = new ArrayList<>();

		File[] filesInCurrentDir = new File(".").listFiles();

		for (File file : filesInCurrentDir) {
			File[] filesInDir = file.listFiles();
			if(filesInDir != null){
				files.addAll(asList(filesInDir));
			}else{
				files.add(file);
			}
		}

		for (File file : files) {
			System.out.println(file);
		}
	}




	// list files in functional style using the flatmap method.
	public static void listInFunctionalStyle(){
		of(new File(".").listFiles())
			.flatMap(file -> file.listFiles() == null ? of(file) : of(file.listFiles()))
			.collect(toList())
			.forEach(System.out::println);
	}


}
