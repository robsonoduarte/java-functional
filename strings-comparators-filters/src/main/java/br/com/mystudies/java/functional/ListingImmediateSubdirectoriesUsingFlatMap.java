package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListingImmediateSubdirectoriesUsingFlatMap {


	public static void main(String[] args) {
		listTheHardway();
	}







    // list files in the imperative style
	public static void listTheHardway(){
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








}
