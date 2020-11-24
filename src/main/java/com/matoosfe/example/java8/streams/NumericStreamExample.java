/**
 * 
 */
package com.matoosfe.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.matoosfe.example.util.Book;

/**
 * 
 * Class to show how to use numeric streams
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         24/11/2020 - 12:24:40<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class NumericStreamExample {

	/**
	 * Method to generate a number list using a range
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static List<Integer> generateNumbers(int min, int max) {
		return IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList());
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

		System.out.println("\n\nMax Publication Year of Books:"
				+ books.stream().mapToInt(Book::getBooPublicationYear).max().orElse(0));
	}
}
