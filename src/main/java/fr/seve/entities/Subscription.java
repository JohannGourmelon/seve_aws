package fr.seve.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscription")
public class Subscription {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column
	private String price;
	@Column
	private String description;
	@Column
	private String subscribeDate;
	@Column
	private SubStatus substatus;
	
	private int functionId; 
	
	
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	
	public String getSubscribeDate() {
		return subscribeDate;
	}

	public SubStatus getSubstatus() {
		return substatus;
	}

	

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public void setSubscribeDate(String subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public void setSubstatus(SubStatus substatus) {
		this.substatus = substatus;
	}
}
