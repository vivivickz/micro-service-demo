package com.example.bookPurchase.intercomm;

import java.util.List;

import com.example.bookPurchase.model.Book;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "BOOKINVENTORY")
public interface BookInventoryClient {

    @RequestMapping("/books/add/{id}/{bookname}/{authorname}/{doa}/{status}")
    public List<Book> addBook(
            @PathVariable("id") int id,
            @PathVariable("bookname") String name,
            @PathVariable("authorname") String authName,
            @PathVariable("doa") String doa,
            @PathVariable("status") String status);

    @RequestMapping("/books/delete/{id}")
    public List<Book> deleteBook(
            @PathVariable("id") int id);

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
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public List<Book> addBook(int id, String name, String authName, String doa, String status) {
                    // TODO Auto-generated method stub
                    return null;
                }

                @Override
                public List<Book> deleteBook(int id) {
                    // TODO Auto-generated method stub
                    return null;
                }
            };
        }
    }
}