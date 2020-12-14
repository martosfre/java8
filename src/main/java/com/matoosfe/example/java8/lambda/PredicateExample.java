/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.matoosfe.example.util.Book;

/**
 * Class to show how filter elements using the Predicate Functional Interface
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         12/12/2020 - 22:11:09<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class PredicateExample {

	/**
	 * Method to filter books by a predicate
	 * 
	 * @param books
	 * @param criteria
	 * @return
	 */
	public static List<Book> filter(List<Book> books, Predicate<Book> criteria) {
		List<Book> booksRet = new ArrayList<>();
		for (Book book : books) {
			if (criteria.test(book)) {
				booksRet.add(book);
			}
		}
		return booksRet;
	}

	/**
	 * Method to filter books by two predicates with AND operators.
	 * 
	 * @param books
	 * @param criteriaOne
	 * @param criteriaTwo
	 * @return
	 */
	public static List<Book> filterAnd(List<Book> books, Predicate<Book> criteriaOne, Predicate<Book> criteriaTwo) {
		List<Book> booksRet = new ArrayList<>();
		for (Book book : books) {
			if (criteriaOne.and(criteriaTwo).test(book)) {
				booksRet.add(book);
			}
		}
		return booksRet;
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

		Predicate<Book> criteriaPublicationYear = b -> b.getBooPublicationYear() > 2005;
		System.out.println(criteriaPublicationYear.test(books.get(0)) + ":" + books.get(0));

		System.out.println("\nFilter books that name start with Zero word");
		PredicateExample.filter(books, b -> b.getBooName().startsWith("Zero")).forEach(b -> System.out.println(b));

		System.out.println("\nFilter books with a publication year grater than 2005");
		PredicateExample.filter(books, b -> b.getBooPublicationYear() > 2005).forEach(b -> System.out.println(b));

		System.out.println("\nFilter books with the two predicates above");
		PredicateExample.filterAnd(books, b -> b.getBooName().startsWith("Zero"), b -> b.getBooPublicationYear() > 2005)
				.forEach(b -> System.out.println(b));
		
	}
}
