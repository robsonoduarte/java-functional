package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

public class PickingAnElement {


	public static void main(String[] args) {

		final List<String> names =
				asList("Robson", "Ana Mara", "Maria Helena", "Antonio", "Aparecida", "Cibele");

		pickNameIperative(names, "A");
		pickNameIperative(names, "B");

		pickNameFuctional(names, "A");
		pickNameFuctional(names, "B");

	}



	// the habitual approach (imperative)
	private static void pickNameIperative(final List<String> names, final String startingLetter) {
		String foundName = null;
		for (String name : names) {
			if(name.startsWith(startingLetter)){
				foundName = name;
				break;
			}
		}
		System.out.println(String.format("A name starting with %s", startingLetter));

		if(foundName != null){
			System.out.println(foundName);
		}else{
			System.out.println("No name found");
		}
	}




	// the functional style
	private static void pickNameFuctional(List<String> names, String startingLetter) {
		Optional<String> foundName =
				names.stream()
					.filter(name -> name.startsWith(startingLetter))
					.findFirst();

		System.out.println(String.format("A name starting with %s : %s", startingLetter, foundName.orElse("No name found")));

	}


}
