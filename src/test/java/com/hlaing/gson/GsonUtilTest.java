package com.hlaing.gson;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hlaing.gson.entity.Product;
import com.hlaing.gson.util.GsonUtil;

public class GsonUtilTest {
	private Product product;
	
	 String json_string = "{\n" +
	          "  \"productId\": \"235268845711068312\",\n" +
	          "  \"description\": \"Spring Framework Guru Mug\",\n" +
	          "  \"imageUrl\": \"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_towel-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg\",\n" +
	          "  \"price\": 14\n" +
	          "}";
	
	@BeforeMethod
	public void setUp() {
		product = new Product("P01","Spring Guru Mug","https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg",new BigDecimal(18.95));
	}
	
	@Test (enabled = false)
	public void simpleJson() {
		String result = GsonUtil.simpleJson(product);
		
		assertEquals(4, result.replace("{", "").replace("}","").split(",").length);
	    assertEquals("\"productId\":\"P01\"".trim(), result.replace("{", "").replace("}","").split(",")[0].trim());
	    assertEquals("\"description\":\"Spring Guru Mug\"".trim(), result.replace("{", "").replace("}","").split(",")[1].trim());
	    assertEquals("\"imageUrl\":\"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg\"".trim(), result.replace("{", "").replace("}","").split(",")[2].trim());
	    assertEquals("\"price\":"+ new BigDecimal(18.95)+"".trim(), result.replace("{", "").replace("}","").split(",")[3].trim());
	}
	
	@Test (enabled = false)
	public void simpleJsonPrettyPrinting() {
		String result = GsonUtil.simpleJsonWithPrettyPrinting(product);
	}
	
	@Test (enabled = true)
	public void jsonToObjectTest() {
		final Product product = GsonUtil.jsonToObject(json_string);
		
		  assertNotNull(product);
		  assertEquals("235268845711068312", product.getProductId());
		  assertEquals("Spring Framework Guru Mug", product.getDescription());
		  assertEquals("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_towel-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", product.getImageUrl());
		  assertEquals(new BigDecimal(14), product.getPrice());
	}
	
	@Test (enabled = false)
	public void simpleJsonWithExposeField() {
		final String result = GsonUtil.simpleJsonWithExposeField(product);
		
		assertEquals(1, result.replace("{", "").replace("}","").split(",").length);
		assertEquals("\"price\": "+ new BigDecimal(18.95)+"".trim(), result.replace("{", "").replace("}","").split(",")[0].trim());
	}
	
	@Test (enabled = true)
	public void simpleJsonWithCustomSerialization() {
		final String result = GsonUtil.simpleJsonWithCustomJsonSerialization(product);
		
		 assertEquals(4, result.replace("{", "").replace("}","").split(",").length);
		 assertEquals("\"product-id\": \"P01\"", result.replace("{", "").replace("}","").split(",")[0].trim());
		 assertEquals("\"description\": \"Spring Guru Mug\"".trim(), result.replace("{", "").replace("}","").split(",")[1].trim());
		 assertEquals("\"image-url\": \"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg\"".trim(), result.replace("{", "").replace("}","").split(",")[2].trim());
		 assertEquals("\"price\": 18.95".trim(), result.replace("{", "").replace("}","").split(",")[3].trim());
	}
	
	@Test(enabled = true)
	public void objectWithCustomDeserialization() throws IOException {
		final Product product = GsonUtil.simpleJsonWithCustomJsonDeserialization();
		assertNotNull(product);
		assertEquals("235268845711068312", product.getProductId());
		assertEquals("Spring Framework Guru Mug", product.getDescription());
//		assertEquals("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_mug-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", product.getImageUrl());
		assertEquals(new BigDecimal(14), product.getPrice());
	}

}
