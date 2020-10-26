/**
 * 
 */
package com.matoosfe.example.java8;

import java.util.Objects;

/**
 * Class to represents a Book Entity
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         18/10/2020 - 17:49:11<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 */
public class Book {
	private int booId;
	private String booName;
	private String booDescription;
	private int booPublicationYear;

	/**
	 * Constructor to create a empty book
	 */
	public Book() {

	}

	/**
	 * Constructor to create a book with all attributes
	 * @param booId
	 * @param booName
	 * @param booDescription
	 * @param booPublicationYear
	 */
	public Book(int booId, String booName, String booDescription, int booPublicationYear) {
		this.booId = booId;
		this.booName = booName;
		this.booDescription = booDescription;
		this.booPublicationYear = booPublicationYear;
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
	public int getBooPublicationYear() {
		return booPublicationYear;
	}

	/**
	 * @param booPublicationYear the booPublicationYear to set
	 */
	public void setBooPublicationYear(int booPublicationYear) {
		this.booPublicationYear = booPublicationYear;
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
	
	
}
