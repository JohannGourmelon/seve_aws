package fr.seve.entities;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "boxes")
public class Box {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private String name;

	@Column(nullable = true)
	private String description;

	@Column(nullable = true)
	private double price;

	@Column(nullable = true)
	private int stock;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = true)
	private Date availableDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = true)
	private Date purchaseDeadlineDate;

	@Column(nullable = true)
	private String creationDate;

	@Column(nullable = true)
	private String lastModifiedDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private Category category;

	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private Frequency frequency;

//    @Column(nullable = true)
//    private String imageUrl;

	// Relation avec Producteur
//    @ManyToOne
//    @JoinColumn(name = "producteur_id", nullable = true)
//    private Producteur producteur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public Date getPurchaseDeadlineDate() {
		return purchaseDeadlineDate;
	}

	public void setPurchaseDeadlineDate(Date purchaseDeadlineDate) {
		this.purchaseDeadlineDate = purchaseDeadlineDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getFormattedAvailableDate() {
		if (availableDate != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(availableDate);
		}
		return "";
	}

	public String getFormattedPurchaseDeadlineDate() {
		if (purchaseDeadlineDate != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(purchaseDeadlineDate);
		}
		return "";
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

//    public Producteur getProducteur() {
//        return producteur;
//    }
//
//    public void setProducteur(Producteur producteur) {
//        this.producteur = producteur;
//    }

	// Enum pour la fréquence
	public enum Frequency {
		WEEKLY("Hebdomadaire"), BIMONTHLY("Bimensuel"), MONTHLY("Mensuel");

		private final String displayName;

		Frequency(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

	// Enum pour la catégorie
	public enum Category {
		FRUITS("Fruits"), VEGETABLES("Légumes"), MIXED("Mixte");

		private final String displayName;

		Category(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return displayName;
		}
	}

}
