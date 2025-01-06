package fr.seve.entities;

import javax.persistence.*;

@Entity
public class AmapProducerUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private AmapUser amapUser;

    @Column(nullable = false)
    private String rib;

    @Column(nullable = false)
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AmapUser getAmapUser() {
        return amapUser;
    }

    public void setAmapUser(AmapUser amapUser) {
        this.amapUser = amapUser;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
