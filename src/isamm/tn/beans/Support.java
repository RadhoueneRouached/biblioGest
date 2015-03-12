package isamm.tn.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Support {

	private int id_support;
	private String type;

	
	public Support() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId_support() {
		return id_support;
	}

	public void setId_support(int id_support) {
		this.id_support = id_support;
	}

	@Column(length = 20, nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
