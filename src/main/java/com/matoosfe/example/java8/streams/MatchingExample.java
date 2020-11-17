/**
 * 
 */
package com.matoosfe.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.matoosfe.example.util.Book;

/**
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         16/11/2020 - 12:40:47<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class MatchingExample {

	/**
	 * Method to verify if at least one book of the collections with the book name
	 * sent.
	 * 
	 * @param books
	 * @param bookName
	 * @return
	 */
	public static boolean verifyAnyBookName(List<Book> books, String bookName) {
		return books.stream().anyMatch(b -> b.getBooName().equals(bookName));
	}

	/**
	 * Method to verify that all books meet the submitted criteria
	 * 
	 * @param books
	 * @param publicationYear
	 * @return
	 */
	public static boolean verifyAllBook(List<Book> books, int publicationYear) {
		return books.stream().allMatch(b -> b.getBooPublicationYear() > publicationYear);
	}

	/**
	 * Method to verify that all books don't meet the submitted criteria
	 * 
	 * @param books
	 * @param publicationYear
	 * @return
	 */
	public static boolean verifyAllBookNot(List<Book> books, int publicationYear) {
		return books.stream().noneMatch(b -> b.getBooPublicationYear() > publicationYear);
	}
	
	public static Optional<Book> findAnyBook(List<Book> books, String bookName){
		return books.stream().filter(b -> b.getBooName().equals(bookName)).findAny();
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

		System.out.println("\n\nFind at least one element with a book name sent");
		System.out.println("Is there any Book with title as 'Good to Great': "
				+ MatchingExample.verifyAnyBookName(books, "Good to Great"));
		System.out.println("Is there any Book with title as 'Dream Magic': "
				+ MatchingExample.verifyAnyBookName(books, "Dream Magic"));

		System.out.println("\n\nVerify if all books was published later of specific year");
		System.out.println("Was all books published later 2010:" + MatchingExample.verifyAllBook(books, 2010));
		System.out.println("Was all books published later 2000:" + MatchingExample.verifyAllBook(books, 2000));

		System.out.println("\n\nVerify if all books was not published later of specific year");
		System.out.println(
				"Verify that don't exist books published later 2020:" + MatchingExample.verifyAllBookNot(books, 2020));
		
		System.out.println("\n\nFind any book with the name 'Zero to One'");
		System.out.println("Book found:" + MatchingExample.findAnyBook(books, "Zero to One"));

	}

}
