package br.com.mystudies.java.functional;

public interface FastFly extends Fly {

	default void takeOff(){System.out.println("FastFly::takeOff");}
}
