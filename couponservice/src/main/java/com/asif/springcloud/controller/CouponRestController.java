package com.asif.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asif.springcloud.model.Coupon;
import com.asif.springcloud.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	CouponRepo couponRepo;

	@RequestMapping(value="/coupons",method=RequestMethod.POST)
	public Coupon create(@RequestBody  Coupon coupon) {
		return couponRepo.save(coupon);
	}
	
	//@GetMapping
	@RequestMapping(value="/coupon/{code}",method=RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		
		//return couponRepo.findById(null)
		return couponRepo.findByCode(code);
	}
}
