package org.example;

import io.javalin.Javalin;
import org.example.controller.BookController;
import org.example.entity.Book;
import org.example.repository.BookRepository;

public class Main {
    public static void main(String[] args) {

       BookRepository repository = new BookRepository();
       repository.addBook(new Book("Yuska","How to become millioner"));
        repository.addBook(new Book("Yuska","1C FINANSE"));

       repository.addBook(new Book("James Bond","C++"));
        BookController bookController = new BookController(repository);

        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello!!"));
            config.routes.get("/books",bookController::getBooks);
            config.routes.get("/books/findById/{id}",bookController::getBookById);
            config.routes.get("/books/findByAuthor/{author}",bookController::getAllByAuthor);


            config.routes.post("/books",bookController::postBook);


            config.routes.delete("/books/{id}",bookController::deleteBook);


        });
        app.start(7070);


    }
}