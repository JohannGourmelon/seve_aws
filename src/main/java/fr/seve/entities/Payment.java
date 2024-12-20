package fr.seve.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String cardNumber;
	
	
	@Column
	private String cardDate;
	
	@Column
	private String cvv;
	
	@Column
	private String cardName;

	public Long getId() {
		return Id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardDate() {
		return cardDate;
	}

	public String getCvv() {
		return cvv;
	}

	public String getCardName() {
		return cardName;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCardDate(String cardDate) {
		this.cardDate = cardDate;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

}
