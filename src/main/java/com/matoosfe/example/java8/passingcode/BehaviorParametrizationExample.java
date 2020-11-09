/**
 * 
 */
package com.matoosfe.example.java8.passingcode;

import java.util.ArrayList;
import java.util.List;

import com.matoosfe.example.util.Book;

/**
 * 
 * Class to show how to work with behavior parameterization.
 * @author martosfre - Marco Toscano Freire <br>
 *         08/11/2020 - 23:29:31<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class BehaviorParametrizationExample {

	/**
	 * Method to filter books using predicates
	 * 
	 * @param books
	 * @param p
	 * @return
	 */
	public static List<Book> filterBooks(List<Book> books, BookPredicate p) {
		List<Book> booksRet = new ArrayList<Book>();
		for (Book book : books) {
			if (p.filter(book)) {
				booksRet.add(book);
			}
		}
		return booksRet;
	}

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "The Unique", "How to focus something and prioritize", 2012));
		books.add(new Book(2, "Como Ganarse a la gente",
				"Las habilidades que usted usa + las relaciones que usted elige", 2005));
		books.add(new Book(3, "Good to Great", "Why Some Companies Make the Leap and Others Don't", 2001));
		books.add(new Book(4, "Zero to One", "How to build your future", 2014));
		books.add(new Book(5, "Blue Oceans Strategy", "How to create uncontested Market Space", 2015));
		books.add(new Book(6, "Zero to One", "How to build your future", 2009));
		books.add(new Book(7, "Zero to One", "How to build your future", 2008));

		System.out.println("Book Collection Initial");
		books.forEach(System.out::println);

		System.out.println("\n\nFilter books by Description");
		BehaviorParametrizationExample.filterBooks(books, new BookCategoryPredicate()).forEach(System.out::println);

		System.out.println("\n\nFilter Books by Publication Year equals 2010 using Classes");
		BehaviorParametrizationExample.filterBooks(books, new BookPublicationYearPredicate())
				.forEach(System.out::println);

		System.out.println("\n\nFilter Books by Publication Year major to 2010 using Anonymous Classes");
		BehaviorParametrizationExample.filterBooks(books, new BookPredicate() {
			@Override
			public boolean filter(Book book) {
				return book.getBooPublicationYear() > 2010;
			}
		}).forEach(System.out::println);

		System.out.println("\n\nFilter Books by Publication Year minor to 2010 using Lambda");
		BehaviorParametrizationExample.filterBooks(books, (Book book) -> book.getBooPublicationYear() < 2010)
				.forEach(System.out::println);

	}

}
