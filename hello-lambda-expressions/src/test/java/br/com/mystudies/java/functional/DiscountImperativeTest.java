package br.com.mystudies.java.functional;

import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

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
	 final List<BigDecimal> list = asList(
			 new BigDecimal("10"),new BigDecimal("30"),new BigDecimal("17"),
			 new BigDecimal("20"),new BigDecimal("15"),new BigDecimal("18"),
			 new BigDecimal("45"),new BigDecimal("12")
			 );

	  assertEquals(valueOf(67.5), discountImperative.apply(list));
	}



}
