package net.atos.suiviproduction.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "demandes_d_achat")
public class DemandeDAchat {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demande_d_achat_seq")
	@SequenceGenerator(name = "demande_d_achat_seq", sequenceName = "demande_d_achat_sequence", allocationSize = 1)
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
	private Integer numero;
	@Column(nullable = false)
	private Date date;
	private String description;
	@Column(nullable = false)
	private String statut;
	@Column(name = "numero_de_bon_de_commande", nullable = false)
	private Integer numeroDeBonDeCommande;
	@OneToOne
	@JoinColumn(name = "collaborateur_id")
	private Collaborateur collaborateur;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "demande_d_achat_id")
	private Set<Validation> validations = new HashSet<Validation>();

	public DemandeDAchat(Integer numero, Date date, String description, String statut, Integer numeroDeBonDeCommande,
			Collaborateur collaborateur, Set<Validation> validations) {
		super();
		this.numero = numero;
		this.date = date;
		this.description = description;
		this.statut = statut;
		this.numeroDeBonDeCommande = numeroDeBonDeCommande;
		this.collaborateur = collaborateur;
		this.validations = validations;
	}

	public Set<Validation> getValidations() {
		return validations;
	}

	public void setValidations(Set<Validation> validations) {
		this.validations = validations;
	}

	public DemandeDAchat() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Integer getNumeroDeBonDeCommande() {
		return numeroDeBonDeCommande;
	}

	public void setNumeroDeBonDeCommande(Integer numeroDeBonDeCommande) {
		this.numeroDeBonDeCommande = numeroDeBonDeCommande;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

}
