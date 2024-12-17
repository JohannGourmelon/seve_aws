package fr.seve.entities;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="saasUsers")
public class SaasUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=true)
	private String firstName; 
	
	@Column(nullable=false, unique=false) 
	private String email;
	
	@Column(nullable=true)
	private String password; 
	
	@Column
	private String phone; 
	
	@Column
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate createDate; 
	
//	@Column
//	@DateTimeFormat(pattern="dd-MM-yyyy")
//	private Date lastModifyDate; 
//	
	
	@Column
	private SaasUserLevel saasUserLevel; 

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

//	public Date getLastModifyDate() {
//		return lastModifyDate;
//	}

	public SaasUserLevel getSaasUserLevel() {
		return saasUserLevel;
	}

	public void setSaasUserLevel(SaasUserLevel saasUserLevel) {
		this.saasUserLevel = saasUserLevel;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCreateDate(LocalDate localDate) {
		this.createDate = localDate;
	}

//	public void setLastModifyDate(Date lastModifyDate) {
//		this.lastModifyDate = lastModifyDate;
//	}


	
}
