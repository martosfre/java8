/**
 * 
 */
package com.matoosfe.example.java8.streams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.example.util.Book;

/**
 * Class to show how to order a book collections using streams
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         05/11/2020 - 10:36:21<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class SortExample {

	/**
	 * Method to sort books using the publicationYear attribute through the
	 * Comparable Interface
	 * 
	 * @param books
	 * @return
	 */
	public static List<Book> sortByPublicationYearComparable(List<Book> books) {
		return books.stream().sorted().collect(toList());
	}

	/**
	 * Method to sort books using the name attribute through the Comparator
	 * Interface
	 * 
	 * @param books
	 * @return
	 */
	public static List<Book> sortByNameComparator(List<Book> books) {
		return books.stream().sorted(Comparator.comparing(Book::getBooName)).collect(toList());
	}

	/**
	 * Method to sort books in descending order using the name attribute through the
	 * Comparator Interface
	 * 
	 * @param books
	 * @return
	 */
	public static List<Book> sortByNameComparatorInverse(List<Book> books) {
		return books.stream().sorted(comparing(Book::getBooName, (b1, b2) -> {
			return b2.compareTo(b1);
		})).collect(toList());

	}

	/**
	 * Method to sort books in descending order using the name attribute through the
	 * Comparator Interface
	 * 
	 * @param books
	 * @return
	 */
	public static List<Book> sortByNameComparatorInverseTwo(List<Book> books) {
		return books.stream().sorted(comparing(Book::getBooName).reversed()).collect(toList());

	}

	/**
	 * Method to sort books using multiple conditions through the Comparator
	 * Interface
	 * 
	 * @param books
	 * @return
	 */
	public static List<Book> sortByMultipleConditions(List<Book> books) {
		return books.stream().sorted(comparing(Book::getBooName).thenComparing(Book::getBooPublicationYear))
				.collect(toList());
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

		System.out.println("\n\n Sort Books using Comparable (Publication Year)");
		SortExample.sortByPublicationYearComparable(books).forEach(System.out::println);

		System.out.println("\n\n Sort Books using Comparator (Name)");
		SortExample.sortByNameComparator(books).forEach(System.out::println);

		System.out.println("\n\n Sort Books in descending order using Comparator (Name)");
		SortExample.sortByNameComparatorInverse(books).forEach(System.out::println);

		System.out.println("\n\n Sort Books in descending order using Comparator through reverse method (Name)");
		SortExample.sortByNameComparatorInverse(books).forEach(System.out::println);

		System.out.println("\n\n Sort Books using Comparator (Name, PublicationYear)");
		SortExample.sortByMultipleConditions(books).forEach(System.out::println);

	}
}
