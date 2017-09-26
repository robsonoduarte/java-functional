package br.com.mystudies.java.functional;

import static java.lang.String.format;

import java.awt.Color;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratingUsingLambdaExpressions {

	public static void main(String[] args) {
		
		final Camera camera  = new Camera();

		final Consumer<String> printCaptured = (filterInfo) ->
			System.out.println(format("with %s : %s", filterInfo, camera.capture(new Color(200, 100, 200))));

		camera.setFilters(Color::brighter, Color::darker);
		printCaptured.accept("no filters");
	}



	public static class Camera{
		
		private Function<Color, Color> filter;

		public Camera(){setFilters();}
		
		public Color capture(final Color inputColor){
			return filter.apply(inputColor);
		}
		
		public void setFilters(final Function<Color,Color>... filters){
			filter = Stream.of(filters)
					.reduce((filter,next) -> filter.compose(next))
					.orElse(color -> color);
		}
	}
}
