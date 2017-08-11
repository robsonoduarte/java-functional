package br.com.mystudies.java.functional;

import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;
import java.util.function.Function;

public class DelegatingUsingLambdaExpressions {


	public static void main(String[] args) {
		CalculateNAV calculateNAV = new CalculateNAV(GoogleFinance::getPrice);

		System.out.println(calculateNAV.computeStockWorth("GOOG", 100));
	}





	public static class CalculateNAV{

		private Function<String, BigDecimal> priceFinder;

		public CalculateNAV(Function<String, BigDecimal> priceFinder) {
			this.priceFinder = priceFinder;
		}

		public BigDecimal computeStockWorth(final String ticker, final int shares){
			return priceFinder.apply(ticker).multiply(valueOf(shares));
		}
	}



	public static class GoogleFinance{
		public static BigDecimal getPrice(final String ticker){
			return valueOf(10.0);
		}

		//"http://www.google.com/finance/historical?q=${symbol}&startdate=${yesterday}&output=csv"
	}

}
