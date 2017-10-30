package com.hlaing.gson;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hlaing.gson.entity.Product;
import com.hlaing.gson.util.GsonUtil;

public class GsonUtilTest {
	private Product product;
	
	@BeforeMethod
	public void setUp() {
		product = new Product("P01","Spring Guru Mug","https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg",new BigDecimal(18.95));
	}
	
	@Test
	public void simpleJson() {
		String result = GsonUtil.simpleJson(product);
		
		assertEquals(4, result.replace("{", "").replace("}","").split(",").length);
	    assertEquals("\"productId\":\"P01\"".trim(), result.replace("{", "").replace("}","").split(",")[0].trim());
	    assertEquals("\"description\":\"Spring Guru Mug\"".trim(), result.replace("{", "").replace("}","").split(",")[1].trim());
	    assertEquals("\"imageUrl\":\"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg\"".trim(), result.replace("{", "").replace("}","").split(",")[2].trim());
	    assertEquals("\"price\":"+ new BigDecimal(18.95)+"".trim(), result.replace("{", "").replace("}","").split(",")[3].trim());
	}

}
