package br.com.mystudies.java.functional;

import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.util.function.Function;

public class DelegatingUsingLambdaExpressions {


	public static void main(String[] args) {

	}




	public class CalculateNAV{

		private Function<String, BigDecimal> priceFinder;

		public CalculateNAV(Function<String, BigDecimal> priceFinder) {
			this.priceFinder = priceFinder;
		}


		public BigDecimal computeStockWorth(final String ticker, final int shares){
			return priceFinder.apply(ticker).multiply(valueOf(shares));
		}

	}









}
