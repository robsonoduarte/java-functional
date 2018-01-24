package br.com.mystudies.java.functional;

import java.util.function.Consumer;

public class CreatingFluentInterfacesUsingLambdaExpressions {

	
	
	
	public static void main(String[] args) {
		Mailer.send(mailer ->
			mailer.from("robson.o.d@gmail.com")
				.to("java@java.com.br")
				.subject("Java Language")
				.body("Is the best language programming")
		);
	}
	
	
	
	
	public static class Mailer{
		
		private Mailer() {}
		
		public Mailer from(final String address) {return this;}
		public Mailer to(final String address) {return this;}
		public Mailer subject(final String line) {return this;}
		public Mailer body(final String body) {return this;}
		
		
		public static void send(final Consumer<Mailer> block) {
			final Mailer mailer = new Mailer();
			block.accept(mailer);
			System.out.println("sending...");
		}
	}
	
}
