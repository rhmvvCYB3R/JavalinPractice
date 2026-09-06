package org.example.entity;
import java.util.concurrent.atomic.AtomicInteger;
public class Book {
    private int id;
    private String author;
    private String name;

    private static final AtomicInteger counter = new AtomicInteger(0);



    public Book(String author,String name){
        this.id = counter.incrementAndGet();
        this.author = author;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }
}
