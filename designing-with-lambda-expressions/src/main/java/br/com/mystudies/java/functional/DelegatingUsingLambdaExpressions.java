package br.com.mystudies.java.functional;

import static java.math.BigDecimal.valueOf;
import static java.net.URLEncoder.encode;
import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Locale.US;

import java.io.UnsupportedEncodingException;
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


			try {
				final String x =
				"http://www.google.com/finance/historical?q=" + ticker + "&startdate=" + yesterday() + "&output=csv";

				System.out.println(x);

				/*final URL url = new URL("http://www.google.com/finance/historical?q=${symbol}&startdate=${yesterday}&output=csv");*/

				return valueOf(10.0);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}




		private static String yesterday() throws UnsupportedEncodingException {
			return encode(now().minusDays(1).format(ofPattern("MMM d, yyyy",US)),"UTF-8");
		}


	}

}
