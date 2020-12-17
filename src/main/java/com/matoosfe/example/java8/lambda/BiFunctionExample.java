/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import com.matoosfe.example.util.Book;

/**
 * 
 * Class to show how to use the BiFunctional Functional Interface
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         15/12/2020 - 16:08:50<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class BiFunctionExample {

	/**
	 * Method to map a List<T> to a List<R>
	 * 
	 * @param <T>
	 * @param <R>
	 * @param list
	 * @param fun
	 * @return
	 */
	public static <T, U, R> List<R> map(List<T> list, BiFunction<T, U, R> fun, U value) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(fun.apply(t, value));
		}
		return result;
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

		System.out.println("Map a Book list to a Name List");
		BiFunctionExample.map(books, (Book s, String v) -> s.getBooName().concat(v), "-EC")
				.forEach(System.out::println);
		System.out.println("\nUpdated the publication year of the book");
		BiFunctionExample.map(books, (Book b, Integer v) -> b.getBooPublicationYear() + v, 5)
				.forEach(System.out::println);

	}
}
