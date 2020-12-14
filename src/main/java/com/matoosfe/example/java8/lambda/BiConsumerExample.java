/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import com.matoosfe.example.util.Book;

/**
 * 
 * Class to show how to use the BiConsumer Funtional Interface
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         14/12/2020 - 17:56:00<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class BiConsumerExample {

	/**
	 * Method to execute an operation on books collections using a value
	 * 
	 * @param <T>
	 * @param <U>
	 * @param values
	 * @param criteria
	 * @param value
	 */
	public static <T, U> void execute(List<T> values, BiConsumer<T, U> criteria, U value) {
		for (T t : values) {
			criteria.accept(t, value);
		}
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

		System.out.println("Concat the names of books with the Aguilar Editorial");
		BiConsumerExample.execute(books,
				(Book book, String cadena) -> System.out.println(book.getBooName().concat(cadena)), " - Aguilar");

		System.out.println("\nObtain the three letters of the names of the books");
		BiConsumerExample.execute(books,
				(Book book, Integer number) -> System.out.println(book.getBooName().substring(0, number)), 5);
		
	}
}
