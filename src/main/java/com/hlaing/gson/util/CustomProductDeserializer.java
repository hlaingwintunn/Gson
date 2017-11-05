package com.hlaing.gson.util;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.hlaing.gson.entity.Product;

public class CustomProductDeserializer implements JsonDeserializer<Product>{
	
	private String productId, description, imageUrl;
	private BigDecimal price;

	@Override
	public Product deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		if(jsonObject.has("product-id")) {
			productId = jsonObject.get("product-id").getAsString();
		}
		if(jsonObject.has("description")) {
			description = jsonObject.get("description").getAsString();
		}
		if(jsonObject.has("image-url")) {
			imageUrl = jsonObject.get("image-url").getAsString();
		}
		if(jsonObject.has("price")) {
			price = jsonObject.get("price").getAsBigDecimal();
		}
		
		final Product product = new Product(productId, description, imageUrl, price);
		
		return product;
	}

}
