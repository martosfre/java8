/**
 * 
 */
package com.matoosfe.example.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.matoosfe.example.util.Employee;

/**
 * 
 * Class to show how to read and write on a file using streams
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         24/11/2020 - 17:06:17<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class StreamFileExample {
	/**
	 * Method to read a file and return a employee collection from it
	 * 
	 * @param pathFile
	 * @return
	 * @throws Exception
	 */
	public static List<Employee> readFile(String pathFile) throws Exception {
		List<Employee> employees = new ArrayList<>();
		try (Stream<String> streamFile = Files.lines(Paths.get(pathFile))) {
			employees = streamFile.map(line -> line.split(",")).map(array -> {
				return new Employee(array[2], array[0], array[1], array[4], array[3], array[5]);
			}).collect(Collectors.toList());
		} catch (IOException io) {
			throw new Exception("Error to read the file:" + io.getMessage());
		}
		return employees;
	}

	public static void main(String[] args) {
		String pathFile = "/Users/martosfre/Downloads/empleados.csv";
		try {
			StreamFileExample.readFile(pathFile).forEach(System.out::println);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
