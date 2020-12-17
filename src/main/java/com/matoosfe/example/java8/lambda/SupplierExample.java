/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.time.LocalDate;
import java.util.function.Supplier;

import com.matoosfe.example.util.Book;

/**
 * 
 * @author martosfre - Marco Toscano Freire <br>
 * 15/12/2020 - 18:45:49<br>
 * <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 * Quito - Ecuador
 *
 */
public class SupplierExample {
	
	public static<T> T create(Supplier<T> supplier){
		return supplier.get();
	}

	public static void main(String[] args) {
		Book book = SupplierExample.create(Book::new);
		String name = SupplierExample.create(() -> "Marco Toscano");
		LocalDate date = SupplierExample.create(() -> LocalDate.now());
		
		System.out.println("Print book:" +  book);
		System.out.println("Print name:" +  name);
		System.out.println("Print date:" +  date);
	}
}
