package fr.seve.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
		
	private LocalDateTime date; 
	private BigDecimal total; 
	
	
//	@ManyToOne
//	@JoinColumn(name = "client_id")
//	private Client client;

	
//	@OneToOne(mappedBy = "command", cascade = CascadeType.ALL)
//	private Facture facture; 
	
	@ManyToMany
	@JoinTable(
	        name = "order_products",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "box_id")
	    )
	
	private List<Box> boxes = new ArrayList<>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public List<Box> getBoxes() {
		return boxes;
	}


	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
	}

}
