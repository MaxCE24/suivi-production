package net.atos.suiviproduction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profils")
public class Profil {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profil_seq")
	@SequenceGenerator(name = "profil_seq", sequenceName = "profil_sequence", allocationSize = 1)
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

	@Column(nullable = false)
	@Size(min = 1, max = 25, message = "Entrez le libellé (max 25 char)")
	private String libelle;

	public Profil() {
		super();
	}

	public Profil(Integer id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
