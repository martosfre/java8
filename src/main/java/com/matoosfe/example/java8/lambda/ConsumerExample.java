/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.matoosfe.example.util.Book;

/**
 * Class to show how to use the Consumer Funtional Interface
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         14/12/2020 - 16:50:00<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class ConsumerExample {
	/**
	 * Method to execute operations on books collections
	 * 
	 * @param books
	 * @param criteria
	 */
	public static void execute(List<Book> books, Consumer<Book> criteria) {
		for (Book book : books) {
			criteria.accept(book);
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

		System.out.println("Convert the name of the book in uppercase");
		ConsumerExample.execute(books, b -> System.out.println(b.getBooName().toUpperCase()));

		System.out.println("\nConcat the name and publication year of books");
		ConsumerExample.execute(books, b -> System.out.println(b.getBooName() + "-" + b.getBooPublicationYear()));
	}
}
