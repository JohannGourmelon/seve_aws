package fr.seve.entities;

import javax.persistence.*;

@Entity
@Table(name = "amap_spaces")
public class AmapSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "amap_id", nullable = false)
    private AMAP amap;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "configuration_id", nullable = false)
    private Configuration configuration;
    
	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private Subscription subscription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AMAP getAmap() {
        return amap;
    }

    public void setAmap(AMAP amap) {
        this.amap = amap;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

}
