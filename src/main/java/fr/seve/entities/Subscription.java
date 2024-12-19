package fr.seve.entities;

import java.util.List;

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
	
	private String name;
	
	private String price;
	
	private String description;
	
	private String subscribeDate;
	
	private SubStatus substatus;
	
	List<Function> functions;
	
	
	

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

	public List<Function> getFunctions() {
		return functions;
	}
	public String getSubscribeDate() {
		return subscribeDate;
	}

	public SubStatus getSubstatus() {
		return substatus;
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

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	
	public void setSubscribeDate(String subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public void setSubstatus(SubStatus substatus) {
		this.substatus = substatus;
	}
}
