package org.dao.pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
*/

public class Main {

    static public void main(String[] args) {
        BookImple book = new BookImple();
        book.getAllBooks().stream().forEach(System.out::print);
    }
}
