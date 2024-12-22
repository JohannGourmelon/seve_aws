package fr.seve.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

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

	public SaasUser getSaasUser() {
		return saasUser;
	}

	public void setSaasUser(SaasUser saasUser) {
		this.saasUser = saasUser;
	}

	//Relation Configuration
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(
	    name = "amap_spaces",
	    joinColumns = @JoinColumn(name = "amap_id"),
	    inverseJoinColumns = @JoinColumn(name = "configuration_id")
	)
	private Configuration configuration;
	

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

	
    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
	

}
