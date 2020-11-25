/**
 * 
 */
package com.matoosfe.example.util;

/**
 * 
 * @author martosfre - Marco Toscano Freire <br>
 *         24/11/2020 - 17:14:25<br>
 *         <a href="mailto:cursos@matoosfe.com">Course Information</a><br>
 *         Quito - Ecuador
 *
 */
public class Employee {

	private String empIde;
	private String empNam;
	private String empLas;
	private String empAddr;
	private String empPho;
	private String empAge;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empIde
	 * @param empNam
	 * @param empLas
	 * @param empAddr
	 * @param empPho
	 * @param empAge
	 */
	public Employee(String empIde, String empNam, String empLas, String empAddr, String empPho, String empAge) {
		this.empIde = empIde;
		this.empNam = empNam;
		this.empLas = empLas;
		this.empAddr = empAddr;
		this.empPho = empPho;
		this.empAge = empAge;
	}

	/**
	 * @return the empIde
	 */
	public String getEmpIde() {
		return empIde;
	}

	/**
	 * @param empIde the empIde to set
	 */
	public void setEmpIde(String empIde) {
		this.empIde = empIde;
	}

	/**
	 * @return the empNam
	 */
	public String getEmpNam() {
		return empNam;
	}

	/**
	 * @param empNam the empNam to set
	 */
	public void setEmpNam(String empNam) {
		this.empNam = empNam;
	}

	/**
	 * @return the empLas
	 */
	public String getEmpLas() {
		return empLas;
	}

	/**
	 * @param empLas the empLas to set
	 */
	public void setEmpLas(String empLas) {
		this.empLas = empLas;
	}

	/**
	 * @return the empAddr
	 */
	public String getEmpAddr() {
		return empAddr;
	}

	/**
	 * @param empAddr the empAddr to set
	 */
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	/**
	 * @return the empPho
	 */
	public String getEmpPho() {
		return empPho;
	}

	/**
	 * @param empPho the empPho to set
	 */
	public void setEmpPho(String empPho) {
		this.empPho = empPho;
	}

	/**
	 * @return the empAge
	 */
	public String getEmpAge() {
		return empAge;
	}

	/**
	 * @param empAge the empAge to set
	 */
	public void setEmpAge(String empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "Employee [empIde=" + empIde + ", empNam=" + empNam + ", empLas=" + empLas + ", empAddr=" + empAddr
				+ ", empPho=" + empPho + ", empAge=" + empAge + "]";
	}

}
