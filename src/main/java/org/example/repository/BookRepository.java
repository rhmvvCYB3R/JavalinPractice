package org.example.repository;

import org.example.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List <Book> books = new ArrayList<>();


    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int id){
        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllByAuthor(String author){
        for(Book book : books){
            if(book.getAuthor().toLowerCase().equals(author.toLowerCase())){
                return books;
            }
        }
        return null;
    }



    public void addBook(Book book){
        books.add(book);
    }


}
