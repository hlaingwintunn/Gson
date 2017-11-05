package com.hlaing.gson.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

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
	
	public static String simpleJsonWithExposeField(final Product product) {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		String json = gson.toJson(product);
		System.out.println(json);
		return json;
	}
	
	public static String simpleJsonWithCustomJsonSerialization(final Product product) {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Product.class, new CustomProductSerializer()).setPrettyPrinting();
		final Gson gson = gsonBuilder.create();
		final String json = gson.toJson(product);
		System.out.println(json);
		
		return json;
	}

	public static Product simpleJsonWithCustomJsonDeserialization() throws IOException {
		Product product = null;
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Product.class, new CustomProductDeserializer());
		final Gson gson = gsonBuilder.create();
		try(Reader reader = new InputStreamReader(GsonUtil.class.getResourceAsStream("/json/product.json"))) {
			product = gson.fromJson(reader, Product.class);
			System.out.println(product.getProductId());
			System.out.println(product.getDescription());
			System.out.println(product.getImageUrl());
			System.out.println(product.getPrice());
		}
		
		return product;
	}
	
}
