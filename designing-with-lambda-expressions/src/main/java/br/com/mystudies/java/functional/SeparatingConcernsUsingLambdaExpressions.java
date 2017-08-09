package br.com.mystudies.java.functional;

import static br.com.mystudies.java.functional.Asset.AssetType.BOND;
import static br.com.mystudies.java.functional.Asset.AssetType.STOCK;
import static java.util.Arrays.asList;

import java.util.List;



public class SeparatingConcernsUsingLambdaExpressions {

	public static void main(String[] args) {

		final List<Asset> assets = asList(
				new Asset(BOND, 1000),
				new Asset(BOND, 2000),
				new Asset(STOCK, 3000),
				new Asset(STOCK, 4000)
		);

		System.out.println("Total of all assets: " + totalAssetValues(assets));
		System.out.println("Total of all bonds: " + totalBondValues(assets));
	}







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





}
