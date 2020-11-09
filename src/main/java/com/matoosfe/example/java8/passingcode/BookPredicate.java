/**
 * 
 */
package com.matoosfe.example.java8.passingcode;

import com.matoosfe.example.util.Book;

/**
 * 
 * Interface to manages Book's predicates 
 * @author martosfre - Marco Toscano Freire <br>
 * 08/11/2020 - 23:47:16<br>
 * <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 * Quito - Ecuador
 *
 */
public interface BookPredicate {
	boolean filter(Book book);
}
