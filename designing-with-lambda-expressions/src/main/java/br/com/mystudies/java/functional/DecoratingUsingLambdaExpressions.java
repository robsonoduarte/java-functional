package br.com.mystudies.java.functional;

import java.awt.Color;
import java.util.function.Function;

public class DecoratingUsingLambdaExpressions {



	public static void main(String[] args) {
	}


	public static class Camera{
		private Function<Color, Color> filter;

		public Color capture(final Color inputColor){
			final Color processedColor = filter.apply(inputColor);
			return processedColor;
		}
	}


}
