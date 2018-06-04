package br.com.mystudies.java.functional;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.util.List;

public class DiscountFunctional {
	public BigDecimal apply(List<BigDecimal> list) {
		return list.stream()
			.filter(p -> p.compareTo(valueOf(20)) > 0)
			.map(p -> p.multiply(valueOf(0.9)))
			.reduce(ZERO, BigDecimal::add);

	}

}
