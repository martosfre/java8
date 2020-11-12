/**
 * 
 */
package com.matoosfe.example.java8.streams;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.matoosfe.example.util.Book;

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
	 * Methodo to filter the books by year and return a subset of them.
	 * 
	 * @param books
	 * @param year
	 * @param numberOfBooks
	 * @return
	 */
	public static List<Book> filterLimitBookByYear(List<Book> books, Integer year, Integer numberOfBooks) {
		return books.stream().filter(b -> b.getBooPublicationYear() < year).limit(numberOfBooks).collect(toList());
	}

	/**
	 * Method to filter the books by year and skip a number of elements.
	 * 
	 * @param books
	 * @param year
	 * @param skipNumber
	 * @return
	 */
	public static List<Book> filterBooksByYear(List<Book> books, Integer year, int skipNumber) {
		return books.stream().filter(b -> b.getBooPublicationYear() > 2002).skip(skipNumber).collect(toList());
	}

	/**
	 * Method to verify that string begin with a letter
	 * 
	 * @param value
	 * @return
	 */
	public static boolean filterBooksByName(Book book) {
		return book.getBooName().startsWith("Z");
	}

	/**
	 * Method to filter the odd numbers without duplicates and print them from a
	 * list of numbers.
	 * 
	 * @param numbers
	 */
	public static void filterImparNumberWithoutDuplicates(List<Integer> numbers) {
		numbers.stream().filter(n -> n % 2 != 0).distinct().forEach(System.out::println);
	}

	/**
	 * Method to filter the odd numbers without duplicates, order and print them
	 * from a list of numbers
	 * 
	 * @param numbers
	 * @param des
	 */
	public static void filterImparNumberOrderWithoutDuplicates(List<Integer> numbers, boolean des) {
		if (des) {
			numbers.stream().filter(n -> n % 2 != 0).distinct().sorted(Comparator.reverseOrder())
					.forEach(System.out::println);
		} else {
			numbers.stream().filter(n -> n % 2 != 0).distinct().sorted(comparingInt(n -> n))
					.forEach(System.out::println);
		}
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

		System.out.println("\n\nFilter Books by Year older than:" + 2012);
		FilterExample.filterBooksByYear(books, 2012).forEach(System.out::println);

		System.out.println("\n\nFilter Books by Year older than:" + 2012 + " without duplicates");
		FilterExample.filterBooksByYearUnique(books, 2012).forEach(System.out::println);

		System.out.println("\n\nFilter Books by Year less than:" + 2006 + " and choose the first two books");
		FilterExample.filterLimitBookByYear(books, 2006, 2).forEach(System.out::println);

		System.out.println("\n\nFilter Books by Year older than:" + 2002 + " and skip the first two books");
		FilterExample.filterBooksByYear(books, 2002, 2).forEach(System.out::println);

		System.out.println("\n\nFilter Books by Name that begin with a letter");
		books.stream().filter(FilterExample::filterBooksByName).forEach(System.out::println);

		System.out.println("\n\nFilter the odd numbers without duplicates and print from a number list ");
		List<Integer> numberList = Arrays.asList(7, 8, 9, 10, 11, 12, 13, 15, 15, 16, 17, 1, 2, 3, 4, 5, 6, 19, 19, 20);
		FilterExample.filterImparNumberWithoutDuplicates(numberList);

		System.out.println(
				"\n\nFilter the odd numbers without duplicates, order descendent and print from a number list ");
		FilterExample.filterImparNumberOrderWithoutDuplicates(numberList, true);

		System.out.println(
				"\n\nFilter the odd numbers without duplicates, order ascendent and print from a number list ");
		FilterExample.filterImparNumberOrderWithoutDuplicates(numberList, false);

	}

}
