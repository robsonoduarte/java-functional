package br.com.mystudies.java.functional;

import static br.com.mystudies.java.functional.Asset.AssetType.BOND;
import static br.com.mystudies.java.functional.Asset.AssetType.STOCK;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.function.Predicate;



public class SeparatingConcernsUsingLambdaExpressions {

	public static void main(String[] args) {

		final List<Asset> assets = asList(
				new Asset(BOND, 1000),
				new Asset(BOND, 2000),
				new Asset(STOCK, 3000),
				new Asset(STOCK, 4000)
		);

		//Getting Entangled with the concerns ( duplicate code see the statics methods )
		System.out.println("Total of all assets: " + totalAssetValues(assets));
		System.out.println("Total of all bonds: " + totalBondValues(assets));
		System.out.println("Total of all stock: " + totalStockValues(assets));



		//Refactoring to Separate a Key Concern
		System.out.println("Total of all assets: " + totalAssetValues(assets, asset -> true));
		System.out.println("Total of all bonds: " + totalAssetValues(assets, asset -> BOND.equals(asset.type())));
		System.out.println("Total of all stocks: " + totalAssetValues(assets, asset -> STOCK.equals(asset.type())));

	}






	// METHODS THE SAME CONCERNS
	public static int totalAssetValues(final List<Asset> assets){
		return assets.stream()
				.mapToInt(Asset::value)
				.sum();
	}


	public static int totalBondValues(final List<Asset> assets){
		return assets.stream()
				.filter(asset -> BOND.equals(asset.type()))
				.mapToInt(Asset::value)
				.sum();
	}


	public static int totalStockValues(final List<Asset> assets){
		return assets.stream()
				.filter(asset -> STOCK.equals(asset.type()))
				.mapToInt(Asset::value)
				.sum();
	}





	// Refactoring the methods above in one only method that receives the lambda expression
	public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector){
		return assets.stream()
				.filter(assetSelector)
				.mapToInt(Asset::value)
				.sum();
	}



}
