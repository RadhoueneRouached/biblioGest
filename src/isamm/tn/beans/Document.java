package isamm.tn.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Document extends Support {

	private String titre;
	private String description;
	private String auteur;
	private int numEdition;
	private String dateSorie;
	private int exemplaire;
	private List<Adherent> adherents = new ArrayList<Adherent>();
	private Administrateur administrateur; 

	
	public Document() {
		super();
	}

	
	@Column(length = 100, nullable = false)
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Column(length = 250, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 200, nullable = false)
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Column(nullable = false)
	public int getNumEdition() {
		return numEdition;
	}

	public void setNumEdition(int numEdition) {
		this.numEdition = numEdition;
	}

	
	@Column(nullable=false)
	public String getDateSorie() {
		return dateSorie;
	}

	public void setDateSorie(String dateSorie) {
		this.dateSorie = dateSorie;
	}

	@Column(nullable = false)
	public int getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(int exemplaire) {
		this.exemplaire = exemplaire;
	}

	@ManyToMany
	@JoinTable(name = "Emprunt", joinColumns = { @JoinColumn(name = "id_support") }, inverseJoinColumns = { @JoinColumn(name = "id_adherent") })
	public List<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(List<Adherent> adherents) {
		this.adherents = adherents;
	}
	@ManyToOne
	@JoinColumn(name="id_admin" , nullable=false)
	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

}
