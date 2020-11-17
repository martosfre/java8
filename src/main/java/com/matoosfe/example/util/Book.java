/**
 * 
 */
package com.matoosfe.example.util;

import java.util.Objects;

/**
 * Class to represents a Book Entity
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         18/10/2020 - 17:49:11<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 */
public class Book implements Comparable<Book> {
	private int booId;
	private String booName;
	private String booDescription;
	private Integer booPublicationYear;
	private Author author;

	/**
	 * Constructor to create a empty book
	 */
	public Book() {

	}

	/**
	 * Constructor to create a book with all attributes except author
	 * 
	 * @param booId
	 * @param booName
	 * @param booDescription
	 * @param booPublicationYear
	 */
	public Book(int booId, String booName, String booDescription, Integer booPublicationYear) {
		this.booId = booId;
		this.booName = booName;
		this.booDescription = booDescription;
		this.booPublicationYear = booPublicationYear;
	}
	
	

	/**
	 * Constructor to create a book with all attributes.
	 * @param booId
	 * @param booName
	 * @param booDescription
	 * @param booPublicationYear
	 * @param author
	 */
	public Book(int booId, String booName, String booDescription, Integer booPublicationYear, Author author) {
		this.booId = booId;
		this.booName = booName;
		this.booDescription = booDescription;
		this.booPublicationYear = booPublicationYear;
		this.author = author;
	}

	/**
	 * @return the booId
	 */
	public int getBooId() {
		return booId;
	}

	/**
	 * @param booId the booId to set
	 */
	public void setBooId(int booId) {
		this.booId = booId;
	}

	/**
	 * @return the booName
	 */
	public String getBooName() {
		return booName;
	}

	/**
	 * @param booName the booName to set
	 */
	public void setBooName(String booName) {
		this.booName = booName;
	}

	/**
	 * @return the booDescription
	 */
	public String getBooDescription() {
		return booDescription;
	}

	/**
	 * @param booDescription the booDescription to set
	 */
	public void setBooDescription(String booDescription) {
		this.booDescription = booDescription;
	}

	/**
	 * @return the booPublicationYear
	 */
	public Integer getBooPublicationYear() {
		return booPublicationYear;
	}

	/**
	 * @param booPublicationYear the booPublicationYear to set
	 */
	public void setBooPublicationYear(Integer booPublicationYear) {
		this.booPublicationYear = booPublicationYear;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booName, booPublicationYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(booName, other.booName) && booPublicationYear == other.booPublicationYear;
	}

	@Override
	public String toString() {
		return "Book [booId=" + booId + ", booName=" + booName + ", booDescription=" + booDescription
				+ ", booPublicationYear=" + booPublicationYear + "]";
	}

	/**
	 * Method to order books by publication year
	 */
	@Override
	public int compareTo(Book o) {
		return booPublicationYear - o.getBooPublicationYear();
	}

}
