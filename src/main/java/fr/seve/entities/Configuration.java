package fr.seve.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.seve.entities.Box.Category;

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
	
    @Enumerated(EnumType.STRING)
    @Column
    private Police police;
	
	@Column
	private Boolean isRoundedBorders;
	
	@OneToOne(mappedBy = "configuration", cascade = CascadeType.ALL, orphanRemoval = true)
	private AmapSpace amapSpace;

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

	public AmapSpace getAmapSpace() {
	    return amapSpace;
	}

	public void setAmapSpace(AmapSpace amapSpace) {
	    this.amapSpace = amapSpace;
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

	public Police getPolice() {
		return police;
	}

	public void setPolice(Police police) {
		this.police = police;
	}

	public Boolean getIsRoundedBorders() {
	    return isRoundedBorders;
	}

	public void setIsRoundedBorders(Boolean isRoundedBorders) {
	    this.isRoundedBorders = isRoundedBorders;
	}
	
	public enum Police {
	    ARIAL("Arial"),
	    BASKERVILLE("Baskerville"),
	    CALIBRI("Calibri"),
	    COURIER_NEW("Courier New"),
	    CONSOLAS("Consolas"),
	    FUTURA("Futura"),
	    GARAMOND("Garamond"),
	    GEORGIA("Georgia"),
	    HELVETICA("Helvetica"),
	    LATO("Lato"),
	    OPEN_SANS("Open Sans"),
	    PALATINO("Palatino"),
	    ROBOTO("Roboto"),
	    TIMES_NEW_ROMAN("Times New Roman"),
	    VERDANA("Verdana");

	    private final String displayName;

	    Police(String displayName) {
	        this.displayName = displayName;
	    }

	    public String getDisplayName() {
	        return displayName;
	    }
	}


	
}
