/**
 * 
 */
package com.matoosfe.example.java8.passingcode;

import com.matoosfe.example.util.Book;

/**
 * Class to filter books that description attribute start with "How" word.
 * @author martosfre - Marco Toscano Freire <br>
 * 08/11/2020 - 23:50:38<br>
 * <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 * Quito - Ecuador
 *
 */
public class BookCategoryPredicate implements BookPredicate {

	@Override
	public boolean filter(Book book) {
		return book.getBooDescription().startsWith("How");
	}

}
