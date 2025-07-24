package com.weekly.assignment02.GuitarApp;

public class GuitarSpec {
	private Builder builder;
	private String model;
	private Type type;
	private int numStrings;
	private Wood backWood;
	private Wood topWood;

	public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.numStrings = numStrings;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}

	// Optional: matching logic (can be used in place of inline search)
	public boolean matches(GuitarSpec otherSpec) {
		if (builder != null && builder != otherSpec.getBuilder())
			return false;
		if (model != null && (otherSpec.getModel() == null || !model.equals(otherSpec.getModel())))
			return false;
		if (type != null && type != otherSpec.getType())
			return false;
		if (numStrings != 0 && numStrings != otherSpec.getNumStrings())
			return false;
		if (backWood != null && backWood != otherSpec.getBackWood())
			return false;
		if (topWood != null && topWood != otherSpec.getTopWood())
			return false;

		return true;

	}
}