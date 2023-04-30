package com.mvc.login_project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.login_project.dao.impl.FoodProductDaoImpl;
import com.mvc.login_project.dao.impl.OwnerDaoImpl;
import com.mvc.login_project.dto.FoodProduct;
import com.mvc.login_project.dto.Owner;

@Controller
public class FoodProductController {

	@Autowired
	OwnerDaoImpl ownerDaoImpl;
	
	@Autowired
	FoodProductDaoImpl productDao;
	
	@RequestMapping("createProduct")
	public ModelAndView createProduct() {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("productmodel",new FoodProduct());
		mv.setViewName("createproduct.jsp");
		return mv;
	}
	
	@RequestMapping("saveProduct")
	public ModelAndView saveProduct(@ModelAttribute FoodProduct foodProduct,HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		int id=(int) session.getAttribute("Id");
		
		Owner owner=ownerDaoImpl.getOwnerById(id);
		
		foodProduct.setOwner(owner);
		
		String message=productDao.saveProduct(foodProduct);
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("result",message);
		mv.setViewName("ownermessage.jsp");
		return mv;
	}
	
	@ModelAttribute("values")
	public ArrayList<String> values(){
		ArrayList<String> values=new ArrayList<String>();
		
		values.add("Veg");
		values.add("Non-Veg");
		return values;
	}
	
	@RequestMapping("viewProducts")
	public ModelAndView viewProducts() {
		
		ArrayList<FoodProduct> products=productDao.getAllProducts();
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("products",products);
		mv.setViewName("viewproducts.jsp");
		return mv;
	}
}
