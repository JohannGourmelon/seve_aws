package fr.seve.entities;

import javax.persistence.*;
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

//    @Column(nullable = true)
//    private Date availableDate;
//
//    @Column(nullable = true)
//    private Date purchaseDeadlineDate;
//
//    @Column(nullable = true)
//    private Date creationDate;
//
//    @Column(nullable = true)
//    private Date lastModifiedDate;
    
//    @Column(nullable = true)
//    private String imageUrl;

//    
//  @Enumerated(EnumType.STRING)
//  @Column(nullable = true)
//  private Category category;
    
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = true)
//    private Frequency frequency;

    // Relation avec Producteur
//    @ManyToOne
//    @JoinColumn(name = "producteur_id", nullable = true)
//    private Producteur producteur;

    // Getters et setters

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
    
//    public Frequency getFrequency() {
//        return frequency;
//    }
//
//    public void setFrequency(Frequency frequency) {
//        this.frequency = frequency;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

//    public Producteur getProducteur() {
//        return producteur;
//    }
//
//    public void setProducteur(Producteur producteur) {
//        this.producteur = producteur;
//    }
    
//    // Enum pour la fréquence
//    public enum Frequency {
//        WEEKLY,
//        BIMONTHLY,
//        MONTHLY
//    }
//
//    // Enum pour la catégorie
//    public enum Category {
//        FRUITS,
//        VEGETABLES,
//        MIXED
//    }
}
