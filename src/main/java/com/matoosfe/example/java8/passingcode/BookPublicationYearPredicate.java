/**
 * 
 */
package com.matoosfe.example.java8.passingcode;

import com.matoosfe.example.util.Book;

/**
 * Class to filter books that publication year attrbute are major to 2010 
 * @author martosfre - Marco Toscano Freire <br>
 * 08/11/2020 - 23:46:00<br>
 * <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 * Quito - Ecuador
 *
 */
public class BookPublicationYearPredicate implements BookPredicate {

	@Override
	public boolean filter(Book book) {
		return book.getBooPublicationYear() > 2010;
	}

}
