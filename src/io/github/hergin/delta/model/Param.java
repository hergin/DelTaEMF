package io.github.hergin.delta.model;

public class Param {
	String key;
	String value;

	public Param(String key) {
		this.key = key;
	}

	public Param(String key, String value) {
		this(key);
		this.value = value;
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
}
