/**
 * 
 */
package com.matoosfe.example.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * 
 * Class to show how to use the BinaryOpertor Functional Interface
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         15/12/2020 - 16:08:50<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class BinaryOperatorExample {

	/**
	 * Method to map a List<T> to a List<R>
	 * 
	 * @param <T>
	 * @param <R>
	 * @param list
	 * @param fun
	 * @return
	 */
	public static <T> List<T> map(List<T> list, BinaryOperator<T> fun, T t1) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			result.add(fun.apply(t, t1));
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("Add a value to number list");
		BinaryOperatorExample.map(numbers, (n1, n2) -> n1 + n2, 4).forEach(System.out::println);
		System.out.println("Obtain a even number list");
		BinaryOperatorExample.map(numbers, (n1,  n2) -> n1 % n2 == 0 ? n1 : 0, 2).forEach(System.out::println);
	}
}
