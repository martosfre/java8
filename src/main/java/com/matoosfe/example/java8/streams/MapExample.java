/**
 * 
 */
package com.matoosfe.example.java8.streams;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.matoosfe.example.java8.Book;

/**
 * Class to show how to work with the Streams using the map operation
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         26/10/2020 - 17:41:31<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class MapExample {

	/**
	 * Method to retrieve the description in Uppercase format from book Collection.
	 * 
	 * @param books
	 * @return
	 */
	public static List<String> getBookDescription(List<Book> books) {
		return books.stream().map(Book::getBooDescription).map(String::toUpperCase).collect(toList());
	}

	/**
	 * Method to retrieve all words from Book description greater than a value.
	 * 
	 * @param books
	 * @param wordSize
	 * @return
	 */
	public static List<String> getSplitBookDescription(List<Book> books, int wordSize) {
		return books.stream().map(Book::getBooDescription).map(b -> b.split(" ")).flatMap(Arrays::stream)
				.filter(b -> b.length() > wordSize).collect(toList());
	}

	/**
	 * Method to return the square of number list.
	 * 
	 * @param numbers
	 * @return
	 */
	public static List<Integer> getSquareNumbers(List<Integer> numbers) {
		return numbers.stream().map(n -> n * n).collect(toList());
	}

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

		System.out.println("\n\nRetrieve only the description from Book Collection");
		MapExample.getBookDescription(books).forEach(System.out::println);

		System.out.println("\n\nRetrieve all words from Book description with word size greater than 5");
		MapExample.getSplitBookDescription(books, 5).forEach(System.out::println);

		System.out.println("\n\nNumbers List:");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.stream().forEach(System.out::println);

		System.out.println("\n\nSquare Number List");
		MapExample.getSquareNumbers(numbers).forEach(System.out::println);

	}
}
