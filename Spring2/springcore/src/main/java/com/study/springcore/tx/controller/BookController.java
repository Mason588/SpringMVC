package com.study.springcore.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;
import com.study.springcore.tx.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	public void buyBook(Integer wid, Integer bid) {
		try {
				bookService.buyOne(wid, bid);
				System.out.println("One buybook OK!");
		}catch (InsufficientQuantity e) {
			System.err.println("No Stock!"+ e);
		}catch (InsufficientAmount e) {
			System.err.println("No Cash!" + e);
		}
	}
	
	public void buyBooks(Integer wid, Integer... bids) {
		try {
			bookService.buyMany(wid, bids);
			System.out.println("many buybooks OK!");
		}catch (InsufficientQuantity e) {
			System.err.println("No Stock!"+ e);
		}catch (InsufficientAmount e) {
			System.err.println("No Cash!" + e);
		}
	}
}
