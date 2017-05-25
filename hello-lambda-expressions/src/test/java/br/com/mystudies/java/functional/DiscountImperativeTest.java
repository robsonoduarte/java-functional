package br.com.mystudies.java.functional;

import static java.util.Arrays.asList;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DiscountImperativeTest {

	private DiscountImperative discountImperative;


	@Before
	public void setUp() throws Exception {
		discountImperative = new DiscountImperative();
	}




	@Test
	public void test() {
	  BigDecimal total = discountImperative.apply(asList(new BigDecimal("10")));
	}



}
