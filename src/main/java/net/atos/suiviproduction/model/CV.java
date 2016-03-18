package net.atos.suiviproduction.model;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cvs")
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cv_seq")
	@SequenceGenerator(name = "cv_seq", sequenceName = "cv_sequence", allocationSize = 1)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		Astreinte that = (Astreinte) obj;

		return this.id.equals(that.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	private File cV;

	public CV(File cV) {
		this.cV = cV;
	}

	public CV() {
	}

	public static boolean isValid(File candidate) {
		return true;
	}

	public File getcV() {
		return cV;
	}

	public void setcV(File cV) {
		this.cV = cV;
	}

}
