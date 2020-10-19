/**
 * 
 */
package com.matoosfe.example.java8.streams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.example.java8.Book;

/**
 * 
 * Class to show the Streams API utilization in Java 8.
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         18/10/2020 - 17:48:23<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 */
public class CollectionsExample {

	/**
	 * Method to filter books by publication year.
	 * 
	 * @param books
	 * @param publicationYear
	 * @return
	 */
	public static List<Book> filterElementsByYear(List<Book> books, int publicationYear) {
		List<Book> filBooks = new ArrayList<>();
		for (Book book : books) {
			if (book.getBooPublicationYear() >= publicationYear) {
				filBooks.add(book);
			}
		}
		return filBooks;
	}

	/**
	 * Method to print books
	 * 
	 * @param books
	 */
	public static void printBooks(List<Book> books) {
		for (Book book : books) {
			System.out.println(book.getBooName() + " - " + book.getBooPublicationYear());
		}
	}

	/**
	 * Method to process a book collection to filter, sort, and print its values by
	 * publication year using Streams.
	 * 
	 * @param books
	 * @param publicationYear
	 */
	public static void processBooks(List<Book> books, int publicationYear) {
		books.stream().filter(b -> b.getBooPublicationYear() <= publicationYear)
				.sorted(comparing(Book::getBooPublicationYear)).collect(toList())
				.forEach(b -> System.out.println(b.getBooName() + " - " + b.getBooPublicationYear()));
	}

	/**
	 * Method to process a book collection in a parallel way to filter, sort, and
	 * print its values by publication year
	 * 
	 * @param books
	 * @param publicationYear
	 */
	public static void processBooksParallel(List<Book> books, int publicationYear) {
		books.parallelStream().filter(b -> b.getBooPublicationYear() <= publicationYear)
				.sorted(comparing(Book::getBooPublicationYear)).collect(toList())
				.forEach(b -> System.out.println(b.getBooName() + " - " + b.getBooPublicationYear()));
	}

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "The Unique", "How to focus something and prioritize", 2012));
		books.add(new Book(2, "Como Ganarse a la gente",
				"Las habilidades que usted usa + las relaciones que usted elige", 2005));
		books.add(new Book(3, "Good to Great", "Why Some Companies Make the Leap and Others Don't", 2001));
		books.add(new Book(4, "Zero to One", "How to build your future", 2014));
		books.add(new Book(5, "Blue Oceans Strategy", "How to create uncontested Market Space", 2005));

		System.out.println("Book Collections Initial");
		CollectionsExample.printBooks(books);

		System.out.println("\n\nProcess book collection to filter, order, and print it values with Java7");
		List<Book> filterBooks = CollectionsExample.filterElementsByYear(books, 2005);
		Collections.sort(filterBooks, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return Integer.compare(o1.getBooPublicationYear(), o2.getBooPublicationYear());
			}
		});
		CollectionsExample.printBooks(filterBooks);

		System.out.println("\n\nProcess book collection to filter, order and print its values with Java8");
		CollectionsExample.processBooks(books, 2005);

		System.out.println(
				"\n\nProcess book collection in a parallel way to filter, order, and print its values with Java8");
		CollectionsExample.processBooksParallel(books, 2005);

	}
}
