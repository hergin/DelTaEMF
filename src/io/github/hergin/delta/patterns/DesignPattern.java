package io.github.hergin.delta.patterns;

import java.util.List;

import io.github.hergin.delta.model.Param;

public class DesignPattern {

	String path;
	List<Param> params;
	String name;
	String details;
	String xmiName;

	public DesignPattern(String name, String path, List<Param> params, String details) {
		this.name = name;
		this.params = params;
		this.path = path;
		this.details = details;
	}

	public DesignPattern(String name, String path, List<Param> params, String details, String xmiName) {
		this(name, path, params, details);
		this.xmiName = xmiName;
	}

	public String getXmiName() {
		return xmiName;
	}

	public String getPath() {
		return path;
	}

	public List<Param> getParams() {
		return params;
	}

	public String getName() {
		return name;
	}

	public String getDetails() {
		return details;
	}

	public void updateParam(String key, String newVal) {
		for (Param param : params) {
			if (param.getKey().equals(key))
				param.setValue(newVal);
		}
	}

}
