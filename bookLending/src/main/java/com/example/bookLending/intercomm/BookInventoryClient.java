package com.example.bookLending.intercomm;

import java.util.ArrayList;
import java.util.List;

import com.example.bookLending.model.Book;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "BOOKINVENTORY")
public interface BookInventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/books/change/{id}/{status}")
    public List<Book> changeStatus(
            @PathVariable("id") int id,
            @PathVariable("status") String status);

    @RequestMapping("/books")
    public List<Book> showAll();

    @Component
    static class FeignClientFallbackFactory implements FallbackFactory<BookInventoryClient> {
        @Override
        public BookInventoryClient create(Throwable cause) {
            System.out.println("-------------FALLBACK Executed-------------");
            return new BookInventoryClient() {
                @Override
                public List<Book> showAll() {
                    List<Book> lst = new ArrayList<>();
                    Book b = new Book(0, "0", "0", "0", "UNKNOWN");
                    lst.add(b);
                    return lst;
                }
                @Override
                public List<Book> changeStatus(int id, String status) {
                    List<Book> lst = new ArrayList<>();
                    Book b = new Book(0, "0", "0", "0", "UNKNOWN");
                    lst.add(b);
                    return lst;
                }
            };
        }
    }
}