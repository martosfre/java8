/**
 * 
 */
package com.matoosfe.example.java8.streams;

import java.util.Optional;

import com.matoosfe.example.util.Author;
import com.matoosfe.example.util.Book;
import com.matoosfe.example.util.EnumOptional;

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
	public static Optional<Book> createOptional(Book book, EnumOptional option) {
		Optional<Book> optBook = null;
		if (option == EnumOptional.OPTIONAL_OF) {
			optBook = Optional.of(book);
		} else if (option == EnumOptional.OPTIONAL_NULLABLE) {
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

	public static String getNameByDefault() {
		System.out.println("Generic author");
		return "Generic Author";
	}

	public static void main(String[] args) {
		Book book = new Book(1, "The Unique", "How to focus something and prioritize", 2012,
				new Author(1, "Peter Kraig"));
		Book bookTwo = null;

		System.out.println("\nCreate Optional object from a object with value");
		System.out.println("Book One:" + OptionalExample.createOptional(book, EnumOptional.OPTIONAL_OF));
		System.out.println("Book Two:" + OptionalExample.createOptional(book, EnumOptional.OPTIONAL_NULLABLE));
		System.out.println("Book Three:" + OptionalExample.createOptional(book, EnumOptional.OPTIONAL_EMPTY));

		System.out.println("\nCreate Optional object from a null object");
//		System.out.println("Book One:" + OptionalExample.createOptional(bookTwo, EnumOptional.OPTIONAL_OF)); //fail
		System.out.println("Book Two:" + OptionalExample.createOptional(bookTwo, EnumOptional.OPTIONAL_NULLABLE));

		System.out.println("\n\nVerify both object null and not null before Java 8");
		OptionalExample.verifyNullBefore(book);
		OptionalExample.verifyNullBefore(bookTwo);

		System.out.println("\n\nVerify both object null and not null in Java 8");
		OptionalExample.verifyNullAfter(book);
		OptionalExample.verifyNullAfter(bookTwo);

		System.out.println("\n\nDifferences between orElse and orElseGet with null object");
		Optional.ofNullable(bookTwo).map(b -> b.getAuthor()).map(a -> a.getAutName())
				.orElse(OptionalExample.getNameByDefault());
		Optional.ofNullable(bookTwo).map(b -> b.getAuthor()).map(a -> a.getAutName())
		.orElseGet(OptionalExample::getNameByDefault);
		
		System.out.println("\n\nDifferences between orElse and orElseGet without null object");
		Optional.ofNullable(book).map(b -> b.getAuthor()).map(a -> a.getAutName())
				.orElse(OptionalExample.getNameByDefault());
		Optional.ofNullable(book).map(b -> b.getAuthor()).map(a -> a.getAutName())
		.orElseGet(OptionalExample::getNameByDefault);

	}
}
