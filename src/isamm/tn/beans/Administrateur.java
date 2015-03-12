package isamm.tn.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Administrateur {

	private int id_admin;
	private String login;
	private String motDePass;
	private List<Adherent> adherents;
	private List<Document> documents;

	public Administrateur(){}
	public Administrateur(int id_admin, String login, String motDePass) {
		super();
		this.id_admin = id_admin;
		this.login = login;
		this.motDePass = motDePass;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	@Column(length = 50, nullable = false)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(length = 100, nullable = false)
	public String getMotDePass() {
		return motDePass;
	}

	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	@OneToMany(targetEntity = Adherent.class, mappedBy = "administrateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(List<Adherent> adherents) {
		this.adherents = adherents;
	}
	@OneToMany(targetEntity = Document.class, mappedBy = "administrateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}
