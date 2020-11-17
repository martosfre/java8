/**
 * 
 */
package com.matoosfe.example.util;

/**
 * 
 * Class to represent the author entity
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         17/11/2020 - 12:29:04<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class Author {
	private int autId;
	private String autName;

	/**
	 * @param autId
	 * @param autName
	 */
	public Author(int autId, String autName) {
		this.autId = autId;
		this.autName = autName;
	}

	/**
	 * @return the autId
	 */
	public int getAutId() {
		return autId;
	}

	/**
	 * @param autId the autId to set
	 */
	public void setAutId(int autId) {
		this.autId = autId;
	}

	/**
	 * @return the autName
	 */
	public String getAutName() {
		return autName;
	}

	/**
	 * @param autName the autName to set
	 */
	public void setAutName(String autName) {
		this.autName = autName;
	}

}
