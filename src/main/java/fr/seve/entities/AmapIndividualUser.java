package fr.seve.entities;

import javax.persistence.*;

@Entity
public class AmapIndividualUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private AmapUser amapUser;

    @Column(nullable = false)
    private boolean isVolunteer;

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

    public boolean isVolunteer() {
        return isVolunteer;
    }

    public void setVolunteer(boolean isVolunteer) {
        this.isVolunteer = isVolunteer;
    }
}
