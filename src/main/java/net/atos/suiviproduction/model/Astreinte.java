package net.atos.suiviproduction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "astreintes")
public class Astreinte {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "astreinte_seq")
	@SequenceGenerator(name = "astreinte_seq", sequenceName = "astreinte_sequence", allocationSize = 1)
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

	@Column(unique = true, nullable = false)
	private String reference;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;
	@Column(name = "nombre_heures", nullable = false)
	private Double nombreHeures;
	@Column(nullable = false)
	private String type;
	@OneToOne
	@JoinColumn(name = "collaborateur_id")
	private Collaborateur collaborateur;

	public Astreinte(String reference, Date date, Double nombreHeures, String type, Collaborateur collaborateur) {
		super();
		this.reference = reference;
		this.date = date;
		this.nombreHeures = nombreHeures;
		this.type = type;
		this.collaborateur = collaborateur;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Astreinte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getNombreHeures() {
		return nombreHeures;
	}

	public void setNombreHeures(Double nombreHeures) {
		this.nombreHeures = nombreHeures;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Astreinte(String reference, Date date, Double nombreHeures, String type) {
		super();
		this.reference = reference;
		this.date = date;
		this.nombreHeures = nombreHeures;
		this.type = type;
	}

}
