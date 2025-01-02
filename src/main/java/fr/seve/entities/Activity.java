package fr.seve.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "activities")
public class Activity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private double price;

	@Column
	private int maxParticipant;

	@Column
	private int availableSpace;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column
	private LocalDateTime dateAndTime;

	@Column
	private String place;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate creationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = true)
	private LocalDate lastModifiedDate;

//	@Column(nullable = true)
//	private String imageUrl;
//
//	@ManyToOne
//	@JoinColumn(name = "producteur_id", nullable = true)
//	private Producer producer;

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

	public int getMaxParticipant() {
		return maxParticipant;
	}

	public void setMaxParticipant(int maxParticipant) {
		this.maxParticipant = maxParticipant;
	}

	public int getAvailableSpace() {
		return availableSpace;
	}

	public void setAvailableSpace(int availableSpace) {
		this.availableSpace = availableSpace;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	public Producer getProducer() {
//		return producer;
//	}
//
//	public void setProducer(Producer producer) {
//		this.producer = producer;
//	}
	
	// Formattage des dates
	
		private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		public String getFormattedDateAndTime() {
		    return dateAndTime != null ? dateAndTime.format(FORMATTER) : "";
		}
		
		public String getFormattedCreationDate() {
		    return creationDate != null ? creationDate.format(FORMATTER) : "";
		}

		public String getFormattedLastModifiedDate() {
		    return lastModifiedDate != null ? lastModifiedDate.format(FORMATTER) : "";
		}
	
	

}
