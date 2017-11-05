package controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hlaing.gson.entity.Product;

@RestController
public class IndexController {
	
	@RequestMapping(value = "/", produces= {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct() {
		final Product product = new Product();
		final double val = 15.00;
		
	      product.setProductId("235268845711068313");
	      product.setDescription("Spring Framework Guru Jug");
	      product.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_jug-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
	      product.setPrice(BigDecimal.valueOf(val));
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
