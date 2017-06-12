package com.us.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.us.entity.Product;
import com.us.service.IProductService;

@Controller
public class ProductController {
	@Autowired
	IProductService productService;

	@RequestMapping(value="createProduct",method=RequestMethod.GET)
	public ModelAndView createProduct() {
		System.out.println("Inside Create Product");
		
		return new ModelAndView("productForm","product",new Product());  
	}
	
	@RequestMapping(value="saveProduct",method=RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		System.out.println("Inside Save Product -- "+product.getDescription());
		List<Product> producList = productService.save(product);
		if(producList != null){
			return new ModelAndView("productList","productList",producList);
		}else {
			return new ModelAndView("productForm","product",new Product());
		}
	}
	
	// list page
		@RequestMapping(value = "/products", method = RequestMethod.GET)
		public String showAllProducts(Model model) {

			model.addAttribute("productList", productService.getProductList());
			return "productList";

		}
	
	@RequestMapping(value = "/products/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

		Product product = productService.findById(id);
		model.addAttribute("product", product);

		return "editProduct";

	}

	// delete product
	@RequestMapping(value = "/products/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id,
		final RedirectAttributes redirectAttributes) {

		productService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/users";

	}
	
	// update product
	@RequestMapping(value="/products/{id}/updateProduct",method=RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
		System.out.println("Inside update Product -- "+product.getId());
		if(product.getId() != null) {
			productService.updateProduct(product);
		}
		List<Product> producList = productService.getProductList();
		if(producList != null){
			return new ModelAndView("productList","productList",producList);
		}else {
			return new ModelAndView("productForm","product",new Product());
		}
	}
}
