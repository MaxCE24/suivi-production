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
@Table(name = "validations")
public class Validation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "validation_seq")
	@SequenceGenerator(name = "validation_seq", sequenceName = "validation_sequence", allocationSize = 1)
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

	@OneToOne
	@JoinColumn(name = "collaborateur_id")
	private Collaborateur valideur;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;
	@OneToOne
	@JoinColumn(name = "demande_d_achat_id")
	private DemandeDAchat demandeDAchat;

	public Validation(Collaborateur valideur, Date date, DemandeDAchat demandeDAchat) {
		super();
		this.valideur = valideur;
		this.date = date;
		this.demandeDAchat = demandeDAchat;
	}

	public Validation() {
		super();
	}

	public DemandeDAchat getDemandeDAchat() {
		return demandeDAchat;
	}

	public void setDemandeDAchat(DemandeDAchat demandeDAchat) {
		this.demandeDAchat = demandeDAchat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collaborateur getValideur() {
		return valideur;
	}

	public void setValideur(Collaborateur valideur) {
		this.valideur = valideur;
	}

}
