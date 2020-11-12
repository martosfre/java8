/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.matoosfe.example.util.Book;

/**
 * 
 * Class to show how to use lambda expressions.
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         09/11/2020 - 13:19:31<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class LamdaExample {
	
	public static List<String> filter(List<String> names, Predicate<String> p){
		List<String> namesVal = new ArrayList<String>();
		for (String cad : names) {
			if(p.test(cad)) {
				namesVal.add(cad);
			}
		}
		
		return namesVal;
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

		System.out.println("\nSort books with a Comparator using Anonymus Implementation");
		Comparator<Book> bookByPublicationYear = new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getBooPublicationYear().compareTo(o2.getBooPublicationYear());
			}
		};
		Collections.sort(books, bookByPublicationYear);
		books.forEach(System.out::println);

		System.out.println("\n\nSort books with a Comparator using labda expression ");
		Comparator<Book> bookByPubicationYearLambda = (Book o1, Book o2) -> o1.getBooPublicationYear()
				.compareTo(o2.getBooPublicationYear());
		Collections.sort(books, bookByPubicationYearLambda);
		books.forEach(System.out::println);
		
		
		Predicate<String> preFilExt = (String s) -> s.endsWith("txt");
		List<String> fileList = Arrays.asList("taxes.txt", "contract.doc", "montain.png");
		LamdaExample.filter(fileList, preFilExt).forEach(System.out::println);;
		
		
		
		
		
		
		
		
		
				
	}
}
