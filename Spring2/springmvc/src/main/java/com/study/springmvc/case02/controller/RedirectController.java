package com.study.springmvc.case02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/case02/redirect")
public class RedirectController {
	//重定向 redirect:
	//由 server端發出命令 redirect命令(會放在header 中 )給 client 端，並由 client端去執行
	// 所以 client端的瀏覽器網址會改變
	// 重定向可以指向內網與外網
	
	@RequestMapping("/demo1")
	public String demo1() {
		return "redirect:/index.jsp";
	}
	
	//Lab<Demo2) 我要透過 redirect: 重定向到 show_time.jsp 要如何寫?
	
	@RequestMapping("/demo2")
	public String demo2() {
		return "redirect: ../time/now";
	}
	
	@RequestMapping("/demo3")
	public String demo3() {
		return "redirect:https://www.youtube.com/watch?v=vXK5zsEPkVg";
	}
	
	//重定向帶參數I
	@RequestMapping("/demo4")
	public String demo4() {
		return "/case02/show_param.jsp?username=Newt&age=18";
	}
	
	//重定向帶參數II
	@RequestMapping("/demo5")
	public String demo5(RedirectAttributes attr) {
		attr.addAttribute("username", "Anita");
		attr.addAttribute("age", "18");
		return "/case02/show_param.jsp?username=Newt&age=19";
	
	}
	
	//重定向帶參數III
	//http://localhost:8013/springmvc/mvc/case02/redirect/saveOrder?name=iPhone&price=25000&qty=5
		@RequestMapping("/saveOrder")
		public String saveOrder(@RequestParam("name") String name, 
								@RequestParam("price") Integer price,
								@RequestParam("qty") Integer qty,
								RedirectAttributes attr) {
			attr.addFlashAttribute("name", name);
			attr.addFlashAttribute("price", price);
			attr.addFlashAttribute("qty", qty);
			
			return "redirect:./success";
			
		}
		
		@RequestMapping("/success")
		public String saveOrder() {
			return "case02/order_ok";
		}
			
			
		
	

}
