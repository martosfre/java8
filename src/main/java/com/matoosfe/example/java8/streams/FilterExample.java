/**
 * 
 */
package com.matoosfe.example.java8.streams;

import java.util.List;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

import com.matoosfe.example.java8.Book;

/**
 * 
 * Class to show how to work with the Streams using the filter operation
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         25/10/2020 - 21:55:41<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class FilterExample {

	/**
	 * Method to filter the books by year.
	 * 
	 * @param books
	 * @param year
	 * @return
	 */
	public static List<Book> filterBooksByYear(List<Book> books, Integer year) {
		return books.stream().filter(b -> b.getBooPublicationYear() > year).collect(toList());
	}

	/**
	 * Method to filter the books by year without duplicates. The Book is considered
	 * duplicated when the name and year attributes are the same. You must configure
	 * through the Book's hashCode and equals methods.
	 * 
	 * @param books
	 * @param year
	 * @return
	 */
	public static List<Book> filterBooksByYearUnique(List<Book> books, Integer year) {
		return books.stream().filter(b -> b.getBooPublicationYear() > year).distinct().collect(toList());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "The Unique", "How to focus something and prioritize", 2012));
		books.add(new Book(2, "Como Ganarse a la gente",
				"Las habilidades que usted usa + las relaciones que usted elige", 2005));
		books.add(new Book(3, "Good to Great", "Why Some Companies Make the Leap and Others Don't", 2001));
		books.add(new Book(4, "Zero to One", "How to build your future", 2014));
		books.add(new Book(5, "Blue Oceans Strategy", "How to create uncontested Market Space", 2005));
		books.add(new Book(6, "Zero to One", "How to build your future", 2014));

		System.out.println("Book Collections Initial");
		books.stream().forEach(System.out::println);

		System.out.println("\n\nFilter Books by Year:" + 2012);
		FilterExample.filterBooksByYear(books, 2012).forEach(System.out::println);

		System.out.println("\n\nFilter Books by Year:" + 2012 + " without duplicates");
		FilterExample.filterBooksByYearUnique(books, 2012).forEach(System.out::println);

	}

}
