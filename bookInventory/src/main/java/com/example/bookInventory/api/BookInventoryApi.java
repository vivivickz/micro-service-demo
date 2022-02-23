package com.example.bookInventory.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.bookInventory.model.Book;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookInventoryApi {

	protected Logger logger = Logger.getLogger(BookInventoryApi.class.getName());

	private List<Book> books;

	public BookInventoryApi() {
		books = new ArrayList<>();
		books.add(new Book(1, "java", "abcd", "15-11-2021", "STOCK"));
		books.add(new Book(2, "c++", "zxy", "16-11-2021", "LENT"));
	}

	@RequestMapping("/books")
	public List<Book> showAll() {
		logger.info("Book.findAll()");
		System.out.println("books-------------" + books);
		for (Book book : books)
			System.out.println(book);
		return books;
	}

	@RequestMapping("/books/add/{id}/{bookname}/{authorname}/{doa}/{status}")
	public List<Book> addBook(
			@PathVariable("id") int id,
			@PathVariable("bookname") String name,
			@PathVariable("authorname") String authName,
			@PathVariable("doa") String doa,
			@PathVariable("status") String status) {
		logger.info("Book.add()");
		books.add(new Book(id, name, authName, doa, status));
		return books;
	}

	
	@RequestMapping("/books/delete/{id}")
	public List<Book> deleteBook(
			@PathVariable("id") int id) {
		logger.info("Book.deleteing() " + id);
		for (Book x : books) {
			if (x.getId()==id){
				books.remove(x);
				break;
			}
		}
		return books;
	}
	
	@RequestMapping("/books/name/{name}")
	public Book findByName(@PathVariable("name") String name) {
		logger.info(String.format("Book.findByName(%s)", name));
		return books.stream().filter(it -> it.getBookName().equals(name)).findFirst().get();
	}

	@RequestMapping("/books/{id}")
	public Book findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Book.findById(%s)", id));
		System.out.println("id-------------" + id);
		Book book = books.stream().filter(it -> it.getId().intValue() == id.intValue()).findFirst().get();
		System.out.println("id-------------" + book);
		return book;
	}

	@RequestMapping("/books/change/{id}/{status}")
	public List<Book> changeStatus(
			@PathVariable("id") int id,
			@PathVariable("status") String status) {
		logger.info("Book.changingstatus() for " + id + " to " + status);
		for (Book x : books) {
			if (x.getId()==id){
				x.setStatus(status);
				break;
			}
		}
		return books;
	}

}
