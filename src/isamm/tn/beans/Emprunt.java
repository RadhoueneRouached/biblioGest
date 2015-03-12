package isamm.tn.beans;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Emprunt {

	private int id_emp;
	private Date dateDeb;
	private Date dateFin;
	private int confirme=0;
	private Byte depasse;
	private Adherent adherent;
	private Document document;
	
	public Emprunt (){}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	@Column(nullable = false)
	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	@Column(nullable = false)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	@Column(nullable=false)
	public Byte getDepasse() {
		return depasse;
	}

	public void setDepasse(Byte depasse) {
		this.depasse = depasse;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_adherent")
	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_support")
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	@Column
	public int getConfirme() {
		return confirme;
	}

	public void setConfirme(int confirme) {
		this.confirme = confirme;
	}


}
