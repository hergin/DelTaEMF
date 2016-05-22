package io.github.hergin.delta.model;

public class Param {
	String key;
	String value;
	String displayName;

	public Param(String key) {
		this.key = key;
		this.value = "";
	}

	public Param(String key, String value) {
		this(key);
		this.value = value;
		this.displayName = "";
	}

	public Param(String key, String value, String displayName) {
		this(key, value);
		this.displayName = displayName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
