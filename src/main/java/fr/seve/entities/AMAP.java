package fr.seve.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "amaps")
public class AMAP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(nullable = true)
	private String name;

	@Column(nullable = true)
	private String address;

	@Column(nullable = true)
	private String siret;

	// Relation avec SaasUser
	@OneToOne(mappedBy = "amap", cascade = CascadeType.ALL, orphanRemoval = true)
	private SaasUser saasUser;
	
	// Relation avec AmapSpace
	@OneToOne(mappedBy = "amap", cascade = CascadeType.ALL, orphanRemoval = true)
	private AmapSpace amapSpace;
	

	public SaasUser getSaasUser() {
		return saasUser;
	}

	public void setSaasUser(SaasUser saasUser) {
		this.saasUser = saasUser;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	
	public AmapSpace getAmapSpace() {
	    return amapSpace;
	}

	public void setAmapSpace(AmapSpace amapSpace) {
	    this.amapSpace = amapSpace;
	}
	

}
