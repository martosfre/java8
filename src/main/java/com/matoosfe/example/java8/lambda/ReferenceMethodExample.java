/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.matoosfe.example.util.Book;

/**
 * Class to show the use the reference methods
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         16/12/2020 - 19:56:35<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class ReferenceMethodExample {

	/**
	 * Static method that validate the name of book
	 * 
	 * @param book
	 * @return
	 */
	public static boolean validateBookName(Book book) {
		return book.getBooName().startsWith("Z");
	}

	/**
	 * Instance Method to print a book
	 * 
	 * @param book
	 */
	public void print(Book book) {
		System.out.println("Book:" + book.getBooName() + "-" + book.getBooPublicationYear());
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

		System.out.println("Reference Method using static method");
		PredicateExample.filter(books, b -> b.getBooName().startsWith("Z")).forEach(b -> System.out.println(b));
		PredicateExample.filter(books, ReferenceMethodExample::validateBookName).forEach(b -> System.out.println(b));

		System.out.println("\nReference Method using instance method of arbitrary object");
		List<String> names = Arrays.asList("Marco", "Evelyn", "Jimy", "Eliana", "Kenji", "Valentina", "Alejandro",
				"Anahi");
		BinaryOperatorExample.map(names, (n1, n2) -> n1.concat(n2), " T.").forEach(System.out::println);
		BinaryOperatorExample.map(names, String::concat, " T.").forEach(System.out::println);

		System.out.println("\nReference Method using instance method of existing object");
		ReferenceMethodExample reference = new ReferenceMethodExample();
		ConsumerExample.execute(books, reference::print);
		
		System.out.println("\nReference Method using constructor");
		Book book = SupplierExample.create(Book::new);
		System.out.println(book);
		
		

	}

}
