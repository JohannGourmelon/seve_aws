package fr.seve.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "configurations")
public class Configuration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String presentationText;
	
	@Column
	private String primaryColor;
	
	@Column
	private String secondaryColor;
	
	@Column
	private String tertiaryColor;
	
	@OneToOne(mappedBy = "configuration") 
    private AMAP amap;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPresentationText() {
		return presentationText;
	}

	public void setPresentationText(String presentationText) {
		this.presentationText = presentationText;
	}

    public AMAP getAmap() {
        return amap;
    }

    public void setAmap(AMAP amap) {
        this.amap = amap;
    }

	public String getPrimaryColor() {
		return primaryColor;
	}

	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public String getTertiaryColor() {
		return tertiaryColor;
	}

	public void setTertiaryColor(String tertiaryColor) {
		this.tertiaryColor = tertiaryColor;
	}
	
}
