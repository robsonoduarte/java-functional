package br.com.mystudies.java.functional;

import static java.lang.String.format;
import static java.math.BigDecimal.valueOf;
import static java.net.URLEncoder.encode;
import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Locale.US;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.function.Function;

public class DelegatingUsingLambdaExpressions {

	public static void main(String[] args) {
		// use the method reference to give the function to constructor
		CalculateNAV calculateNAV = new CalculateNAV(GoogleFinance::getPrice);
		System.out.println(format("100 shares of Google worth: $%.2f", calculateNAV.computeStockWorth("GOOG", 100))  );
	}

	public static class CalculateNAV{
		private Function<String, BigDecimal> priceFinder;
		// receive one function in constructor
		public CalculateNAV(Function<String, BigDecimal> priceFinder) {
			this.priceFinder = priceFinder;
		}

		public BigDecimal computeStockWorth(final String ticker, final int shares){
			return priceFinder.apply(ticker).multiply(valueOf(shares)); // use the function
		}
	}


	public static class GoogleFinance{
		public static BigDecimal getPrice(final String ticker){
			try {
				final URL url = new URL("http://www.google.com/finance/historical?q=" + ticker + "&startdate=" + yesterday() + "&output=csv");

				BufferedReader reader =
						new BufferedReader(new InputStreamReader(url.openStream()));

				final String[] dataItems =
						reader.lines()
							.skip(1)
							.findFirst()
							.get()
							.split(",");

				return new BigDecimal(dataItems[dataItems.length - 2]);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		private static String yesterday() throws UnsupportedEncodingException {
			return encode(now().minusDays(1).format(ofPattern("MMM d, yyyy",US)),"UTF-8");
		}
	}

}
