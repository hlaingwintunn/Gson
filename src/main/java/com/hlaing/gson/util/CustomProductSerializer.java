package com.hlaing.gson.util;

import java.lang.reflect.Type;
import java.math.RoundingMode;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.hlaing.gson.entity.Product;

public class CustomProductSerializer implements JsonSerializer<Product>{

	@Override
	public JsonElement serialize(Product product, Type type, JsonSerializationContext context) {
		JsonObject object = new JsonObject();
		object.addProperty("product-id", product.getProductId());
		object.addProperty("description", product.getDescription());
		object.addProperty("image-url", product.getImageUrl());
		object.addProperty("price", product.getPrice().setScale(2, RoundingMode.HALF_UP));
		return object;
	}

}
