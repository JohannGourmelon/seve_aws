package fr.seve.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "amaps")
public class AMAP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable=false)
	private String nom;
	
	@Column(nullable=false)
	private String blason;
	
	@Column
	private String valeurs;
	
	

	public Long getId() {
		return Id;
	}

	public String getNom() {
		return nom;
	}

	public String getBlason() {
		return blason;
	}

	public String getValeurs() {
		return valeurs;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setBlason(String blason) {
		this.blason = blason;
	}

	public void setValeurs(String valeur) {
		this.valeurs = valeur;
	}

	
}
