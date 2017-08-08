package br.com.mystudies.java.functional;

public class Asset {

	public enum AssetType {BOND, STOCK}
	private final AssetType type;
	private final int value;

	public Asset(AssetType type, int value) {
		this.type = type;
		this.value = value;
	}

	public AssetType type(){
		return type;
	}

	public int value(){
		return value;
	}


}
