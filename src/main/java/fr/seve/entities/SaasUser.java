package fr.seve.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;







@Entity
@Table(name="saasUsers")
public class SaasUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=true)
	private String firstname; 
	
	@Column(nullable=false, unique=false) 

	
	private String email;
	
	@Column(nullable=true)
	private String password; 
	
	@Column
	private String phone; 
	
	@Column
	private String createDate; 
	
	@Column
	private String lastModifyDate; 
	
	
	@Column
	private SaasUserLevel saasUserLevel; 
	
	private Subscription subscription;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
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

	public String getCreateDate() {
		return createDate;
	}

	public String getLastModifyDate() {
		return lastModifyDate;
	}

	public SaasUserLevel getSaasUserLevel() {
		return saasUserLevel;
	}
	
	public Subscription getSubscription() {
		return subscription;
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

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public void setCreateDate(String localDate) {
		this.createDate = localDate;
	}

	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
}
