/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import com.matoosfe.example.util.Book;

/**
 * Class to show how filter elements using the BiPredicate Functional Interface
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         12/12/2020 - 22:11:09<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class BiPredicateExample {

	/**
	 * Method to filter the books by BiPredicate
	 * 
	 * @param books
	 * @param criteria
	 * @return
	 */
	public static List<Book> filter(List<Book> books, BiPredicate<String, String> criteria) {
		List<Book> booksRet = new ArrayList<>();
		for (Book book : books) {
			if (criteria.test(book.getBooName(), book.getBooDescription())) {
				booksRet.add(book);
			}
		}
		return booksRet;
	}

	/**
	 * Generic method to filter values using reference method
	 * 
	 * @param <T>
	 * @param <U>
	 * @param values
	 * @param referenceMethod
	 * @param valueTwo
	 * @return
	 */
	public static <T, U> List<T> filterBy(List<T> values, BiPredicate<T, U> referenceMethod, U valueTwo) {
		List<T> valuesRet = new ArrayList<>();
		for (T value : values) {
			if (referenceMethod.test(value, valueTwo)) {
				valuesRet.add(value);
			}
		}
		return valuesRet;
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
		books.add(new Book(7, "Zero to Millon", "How to build your money", 2004));
		books.add(new Book(8, "Los milagros existen", "Los milagros existen", 2020));

		System.out.println("\nFilter books where the name and description attributes are the same");
		BiPredicateExample.filter(books, (n, d) -> n.equals(d)).forEach(b -> System.out.println(b));

		System.out.println("\nFilter books where the name start with Z and the description size is major than 23");
		BiPredicateExample.filter(books, (n, d) -> n.startsWith("Z") && d.trim().length() > 23)
				.forEach(b -> System.out.println(b));

		System.out.println("\nFilter the names that end in vowel e");
		BiPredicateExample.filterBy(books, (Book book, String cadena) -> book.getBooName().endsWith(cadena), "e")
				.forEach(b -> System.out.println(b));

		System.out.println("\nFilter the names that contain the vowel o");
		List<String> names = Arrays.asList("Carlos", "Marco", "Freddy", "Ana", "Carmen", "Patricio");
		BiPredicateExample.filterBy(names, String::contains, "o").forEach(b -> System.out.println(b));

		System.out.println("\nFilter the names that end in vowel o");
		BiPredicateExample.filterBy(names, String::endsWith, "o").forEach(b -> System.out.println(b));

	}
}
