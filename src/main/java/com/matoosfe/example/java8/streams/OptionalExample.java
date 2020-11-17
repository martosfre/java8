/**
 * 
 */
package com.matoosfe.example.java8.streams;

import java.util.Optional;

import com.matoosfe.example.util.Author;
import com.matoosfe.example.util.Book;

/**
 * 
 * Class to show how to use the Optional class
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         17/11/2020 - 12:07:48<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class OptionalExample {

	/**
	 * Method to create Optional object from a Book object
	 * 
	 * @param book
	 * @param opc
	 * @return
	 */
	public static Optional<Book> createOptional(Book book, int opc) {
		Optional<Book> optBook = null;
		if (opc == 1) {
			optBook = Optional.of(book);
		} else if (opc == 2) {
			optBook = Optional.ofNullable(book);
		} else {
			optBook = Optional.empty();
		}
		return optBook;
	}

	/**
	 * Method to verify null objects before Java 8
	 * 
	 * @param book
	 */
	public static void verifyNullBefore(Book book) {
		if (book != null) {
			Author author = book.getAuthor();
			if (author != null) {
				System.out.println("Author Name:" + author.getAutName());
			}
		}
	}

	/**
	 * Method to verify null object in Java 8
	 * 
	 * @param book
	 */
	public static void verifyNullAfter(Book book) {
		Optional.ofNullable(book).map(Book::getAuthor)
				.ifPresent(a -> System.out.println("Author Name:" + a.getAutName()));
	}

	public static void main(String[] args) {
		Book book = new Book(1, "The Unique", "How to focus something and prioritize", 2012,
				new Author(1, "Peter Kraig"));
		Book bookTwo = null;

		System.out.println("Book One:" + OptionalExample.createOptional(book, 1));
		System.out.println("Book Two:" + OptionalExample.createOptional(book, 2));
		System.out.println("Book Three:" + OptionalExample.createOptional(book, 3));

		System.out.println("\n\nVerify both object null and not null before Java 8");
		OptionalExample.verifyNullBefore(book);
		OptionalExample.verifyNullBefore(bookTwo);

		System.out.println("\n\nVerify both object null and not null in Java 8");
		OptionalExample.verifyNullAfter(book);
		OptionalExample.verifyNullAfter(bookTwo);

	}
}
