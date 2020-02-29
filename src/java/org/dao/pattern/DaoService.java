/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.pattern;

import java.util.List;
import java.util.ArrayList;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
 */
public interface DaoService {

    public List<Book> getAllBooks();

    public void addBook(Book book);

    public Book getBookById(int id);

    public void modifyBook(Book book);

    public boolean deleteBook(Book book);

    public Book getBookByIsbn(String isbn);

    public Book getBookByName(String name);
}
