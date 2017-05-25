package br.com.mystudies.java.functional;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.util.List;

public class DiscountImperative {

	public BigDecimal apply(List<BigDecimal> list) {
		BigDecimal totalOfDiscountedPrices = ZERO;
		for (BigDecimal price : list) {
			if (price.compareTo(valueOf(20)) > 0){
				totalOfDiscountedPrices =
						totalOfDiscountedPrices.add(price.multiply(valueOf(0.9)));
			}
		}

		return totalOfDiscountedPrices;
	}
}
