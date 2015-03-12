package isamm.tn.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class Adresse {

private int id_adresse;
	private int numRue;
	private String rue;
	private String cite;
	private String ville;
	private Adherent adherent;
	
	
	public Adresse(){}
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "adresse_PK")
	public int getId_adresse() {
		return id_adresse;
	}

	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}
	@Column(nullable = false)
	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	@Column(length = 50,nullable = false)
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Column(length = 50,nullable = false)
	public String getCite() {
		return cite;
	}

	public void setCite(String cite) {
		this.cite = cite;
	}

	@Column(length = 50,nullable = false)
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	@OneToOne
	@PrimaryKeyJoinColumn
	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

}
