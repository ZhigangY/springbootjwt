package com.uplinfo.book.ubdata.domain;

import java.util.List;

public class FiledInfo {
	private String type;
	private String label;
	private String name;
	private String placeholder;
	private List<FiledOption> options;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public List<FiledOption> getOptions() {
		return options;
	}

	public void setOptions(List<FiledOption> options) {
		this.options = options;
	}

}
