package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class FindingElements {


	public static void main(String[] args) {

		final List<String> friends =
				asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		// finding in old approach
		final List<String> startsWithN = new ArrayList<>();

		for (String name : friends) {
			if(name.startsWith("N")){
				startsWithN.add(name);
			}
		}

		System.out.println(startsWithN);



		// using the filter method + collector

		final List<String> startsWithN2 =
				friends.stream()
					.filter(name -> name.startsWith("N"))
					.collect(toList());

		System.out.println(startsWithN2);
	}


 }
