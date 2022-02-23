package com.example.bookLending.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.bookLending.model.Book;
import com.example.bookLending.intercomm.BookInventoryClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BookLendingApi {

	protected Logger logger = Logger.getLogger(BookInventoryClient.class.getName());

	@Autowired
	private BookInventoryClient client;

	private List<Book> books;

	public BookLendingApi() {
		this.books = new ArrayList<>();
	}

	@RequestMapping("/books/change/{id}/{status}")
	public ModelAndView changeStatus(
			@PathVariable("id") int id,
			@PathVariable("status") String status) {
		books = client.changeStatus(id, status);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Landing");
		mv.addObject("message", "Changed Book status to " + status);
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
