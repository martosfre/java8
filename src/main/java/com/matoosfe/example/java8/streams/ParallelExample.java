/**
 * 
 */
package com.matoosfe.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.matoosfe.example.util.Book;

/**
 * 
 * Class to show how to work with streams in parallel mode
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         11/11/2020 - 22:28:20<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class ParallelExample {

	/**
	 * Method to print numbers in a range using streams in both normal and parallel
	 * mode.
	 * 
	 * @param min
	 * @param max
	 */
	public static void printNumber(int min, int max) {
		System.out.println("Normal");
		IntStream numberRange = IntStream.range(min, max);
		long ini = System.currentTimeMillis();
		numberRange.forEach(x -> System.out.println("Thread:" + Thread.currentThread() + ":" + x));
		long fin = System.currentTimeMillis() - ini;
		System.out.println("Finished:" + fin);

		System.out.println("\n---------------------------");

		System.out.println("Parallel");
		IntStream numberRangeTwo = IntStream.range(min, max);
		ini = System.currentTimeMillis();
		numberRangeTwo.parallel().forEach(x -> System.out.println("Thread:" + Thread.currentThread() + ":" + x));
		fin = System.currentTimeMillis() - ini;
		System.out.println("Finished:" + fin);
	}
	

	/**
	 * Method to print the elements of collection using streams in both normal and
	 * parallel mode
	 * 
	 * @param books
	 */
	public static void printCollections(List<Book> books) {
		System.out.println("Normal");
		long ini = System.currentTimeMillis();
		books.stream().forEach(e -> System.out.println("Thread:" + Thread.currentThread() + ":" + e));
		long fin = System.currentTimeMillis() - ini;
		System.out.println("Finished:" + fin);

		System.out.println("\n--------------------------------");

		System.out.println("Parallel");
		ini = System.currentTimeMillis();
		books.parallelStream().forEach(e -> System.out.println("Thread:" + Thread.currentThread() + ":" + e));
		fin = System.currentTimeMillis() - ini;
		System.out.println("Finished:" + fin);
	}

	public static void main(String[] args) {
		System.out.println("Print numbers ");
		ParallelExample.printNumber(1, 20);

		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "The Unique", "How to focus something and prioritize", 2012));
		books.add(new Book(2, "Como Ganarse a la gente",
				"Las habilidades que usted usa + las relaciones que usted elige", 2005));
		books.add(new Book(3, "Good to Great", "Why Some Companies Make the Leap and Others Don't", 2001));
		books.add(new Book(4, "Zero to One", "How to build your future", 2014));
		books.add(new Book(5, "Blue Oceans Strategy", "How to create uncontested Market Space", 2015));
		books.add(new Book(6, "Zero to One", "How to build your future", 2009));
		books.add(new Book(7, "Zero to One", "How to build your future", 2008));
		System.out.println("\n\nPrint elements of Collection");
		ParallelExample.printCollections(books);
	}
}
