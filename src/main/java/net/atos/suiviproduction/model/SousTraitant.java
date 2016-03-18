package net.atos.suiviproduction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sous_traitants")
public class SousTraitant {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sous_traitant_seq")
	@SequenceGenerator(name = "sous_traitant_seq", sequenceName = "sous_traitant_sequence", allocationSize = 1)
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
	@Size(min = 2, max = 20, message = "Entrez le nom (min 2 max 20 char)")
	@Pattern(regexp = "[A-Za-z ]*", message = "Le nom ne doit contenir que des lettres et des espaces.")
	private String nom;
	@Column(nullable = false)
	@Size(min = 2, max = 20, message = "Entrez le prénom (min 2 max 20 char)")
	@Pattern(regexp = "[A-Za-z ]*", message = "Le prénom ne doit contenir que des lettres et des espaces.")
	private String prenom;
	private String sexe;
	@Column(name = "numero_de_telephone", nullable = false)
	private String numeroDeTelephone;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_recrutement", nullable = false)
	private Date dateRecrutement;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profil_id")
	private Profil profil;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipe_id")
	private Equipe equipe;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "societe_id")
	private Societe societe;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cv_id")
	private CV cV;

	public CV getcV() {
		return cV;
	}

	public void setcV(CV cV) {
		this.cV = cV;
	}

	public SousTraitant() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public Date getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}
}
