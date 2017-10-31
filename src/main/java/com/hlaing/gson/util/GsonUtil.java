package com.hlaing.gson.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hlaing.gson.entity.Product;

public class GsonUtil {
	
	public static String simpleJson(final Product product) {
		final Gson gson = new Gson();
		String json = gson.toJson(product);
		System.out.println(json);
		return json;
	}
	
	public static String simpleJsonWithPrettyPrinting(final Product product) {
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(product);
		System.out.println(json);
		return json;
	}
	
	public static Product jsonToObject(final String json) {
		Gson gson = new Gson();
		Product product = gson.fromJson(json, Product.class);
		System.out.println(product);
		return product;
	}

}
