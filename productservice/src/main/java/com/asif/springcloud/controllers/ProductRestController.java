package com.asif.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.asif.springcloud.dto.Coupon;
import com.asif.springcloud.model.Product;
import com.asif.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	
	@Autowired
	private RestTemplate restTemplate; //Should use webclient instead
	
	//@Autowired
//	private WebClient webClient;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Value("${couponService.URL}")
	private String couponServiceURL;

	@RequestMapping(value="/products",method=RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		WebClient webClient = WebClient.create(couponServiceURL.concat(product.getCouponCode()));//SuperSale
		Coupon coupon = webClient.get().retrieve().bodyToMono(Coupon.class).block();
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepo.save(product);
			
	}
	
	
	 
}
