package com.wineshop.model;

import java.util.HashMap;
import java.util.Map;

public enum Category {
	WINES(0),
	BEER(1),
	WHISKEY(2),
	RUM(3),
	VODKA(4),
	SCOTCH(5),
	BEVERAGES(6);

	private int value;
	private static Map map = new HashMap<>();

	private Category(int value) {
		this.value = value;
	}

	static {
		for (Category category : Category.values()) {
			map.put(category.value, category);
		}
	}

	public static Category valueOf(int category) {
		return (Category) map.get(category);
	}

	public int getValue() {
		return value;
	}
}
