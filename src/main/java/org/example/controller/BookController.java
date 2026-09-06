package org.example.controller;

import io.javalin.Javalin;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import io.javalin.http.Context;

import java.util.List;

public class BookController {
    public BookRepository repository;

    public BookController(BookRepository repository){
        this.repository = repository;
    }

    public void getBooks(Context ctx){
        List<Book> books = repository.getAllBooks();
        ctx.json(books).status(201);
    }

    public void getBookById(Context ctx){
        String idPars = ctx.pathParam("id");
        int id = Integer.parseInt(idPars);

        Book book =repository.getBookById(id);
        if(book!= null){
            ctx.json(book).status(200);
        }else{
            ctx.status(404).result("Not Found!");
        }
    }
    public void getAllByAuthor(Context ctx){
        String authorPars = ctx.pathParam("author");
        List <Book> books = repository.getAllByAuthor(authorPars);
        if (books!=null){
            ctx.json(books).status(200);
        }else{
            ctx.result("Not Found!").status(200);
        }

    }

    public void postBook(Context ctx){
        Book newBook = ctx.bodyAsClass(Book.class);
        repository.addBook(newBook);
        ctx.json(newBook).status(201);
    }

    public void deleteBook(Context ctx){
        String idPars = ctx.pathParam("id");
        int id = Integer.parseInt(idPars);
       List <Book> books = repository.deleteById(id);
       if(books!=null){
           ctx.json(books).status(200);
       }else {
           ctx.result("Not Found!").status(404);

       }
    }


}
