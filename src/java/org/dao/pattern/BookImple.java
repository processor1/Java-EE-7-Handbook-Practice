/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.pattern;

import java.util.List;
import javax.inject.Inject;
import javax.enterprise.context.ApplicationScoped;
import javax.annotation.PostConstruct;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
 */

@javax.inject.Named
public class BookImple implements DaoService {

    
    List<Book> books=new java.util.ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book getBookById(int id) {
        return books.get(id);
    }

    @Override
    public void modifyBook(Book book) {

    }

    @Override
    public boolean deleteBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(book)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book book = null;

        boolean conndition = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                book = books.get(i);
            }
        }
        return book;
    }

    @Override
    public Book getBookByName(String name) {
        Book book = null;

        boolean conndition = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)) {
                book = books.get(i);
            }
        }
        return book;
    }

    @PostConstruct
    public void initBook() {
        Book b1 = new Book();
        b1.setIsbn("11023");
        b1.setName("Java Development Mobile");
        b1.setPrice(102.00);

        Book b2 = new Book();
        b2.setIsbn("10029");
        b2.setName("Science & Technology");
        b2.setPrice(1029.01);

        Book b3 = new Book();
        b3.setIsbn("10923");
        b3.setName("Farming Logics");
        b3.setPrice(1029.102);

        Book b4 = new Book();
        b4.setIsbn("20912");
        b4.setName("Love Me Not ");
        b4.setPrice(109.201);

        Book b5 = new Book();
        b5.setIsbn("102");
        b5.setName("Google Marketing");
        b5.setPrice(100.023);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);

    }
}
