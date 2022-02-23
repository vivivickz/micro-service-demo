package com.example.bookPurchase.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.bookPurchase.intercomm.BookInventoryClient;
import com.example.bookPurchase.model.Book;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BookPurchaseApi {

	protected Logger logger = Logger.getLogger(BookInventoryClient.class.getName());
	private List<Book> books;

	public BookPurchaseApi() {
		this.books = new ArrayList<>();
	}

	@Autowired
	private BookInventoryClient client;

	@RequestMapping("/books/add/{id}/{bookname}/{authorname}/{doa}/{status}")
	public ModelAndView addBook(
			@PathVariable("id") int id,
			@PathVariable("bookname") String name,
			@PathVariable("authorname") String authName,
			@PathVariable("doa") String doa,
			@PathVariable("status") String status) {
		books = client.addBook(id, name, authName, doa, status);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Landing");
		mv.addObject("message", "Added Book");
		mv.addObject("books", books);
		return mv;
	}

	@RequestMapping("/books/delete/{id}")
	public ModelAndView changeStatus(
			@PathVariable("id") int id) {
		books = client.deleteBook(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Landing");
		mv.addObject("message", "deleted book " + id);
		mv.addObject("books", books);
		return mv;
	}

	@RequestMapping("/books")
	public ModelAndView showAll() {
		books = client.showAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Landing");
		mv.addObject("message", "Showing Books");
		mv.addObject("books", books);
		return mv;
	}
}
