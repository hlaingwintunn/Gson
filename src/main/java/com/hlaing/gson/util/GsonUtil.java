package com.hlaing.gson.util;

import com.google.gson.Gson;
import com.hlaing.gson.entity.Product;

public class GsonUtil {
	
	public static String simpleJson(final Product product) {
		final Gson gson = new Gson();
		String json = gson.toJson(product);
		System.out.println(json);
		return json;
	}

}
