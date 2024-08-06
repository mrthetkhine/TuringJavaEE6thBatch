package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.controller.core.CoreController;

import lombok.extern.slf4j.Slf4j;

@Component
@SessionScope
@Slf4j
public class ShoppingCart {

	List<String> items = new ArrayList<>();
	
	public ShoppingCart()
	{
		log.info("ShoppingCart created "+this);
	}
	public void addToCart(String item)
	{
		log.info("Add "+item);
		this.items.add(item);
	}
	public int getNoOfItem()
	{
		return this.items.size();
	}
}
