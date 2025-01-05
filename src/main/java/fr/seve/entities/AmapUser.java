package fr.seve.entities;

import javax.persistence.*;

import fr.seve.entities.enums.AmapUserRole;
import fr.seve.entities.enums.AmapUserType;

@Entity
public class AmapUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String createDate;

    @Column(nullable = false)
    private String lastModifyDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AmapUserRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AmapUserType type;

    // Relation avec AmapSpace
    @ManyToOne
    @JoinColumn(name = "amapSpace_id", nullable = false)
    private AmapSpace amapSpace;

    // Relations OneToOne avec les sous-types
    @OneToOne(mappedBy = "amapUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private AmapIndividualUser individualUser;

    @OneToOne(mappedBy = "amapUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private AmapWorksComitteeUser worksComitteeUser;

    @OneToOne(mappedBy = "amapUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private AmapProducerUser producerUser;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String string) {
        this.createDate = string;
    }

    public String getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(String string) {
        this.lastModifyDate = string;
    }

    public AmapUserRole getRole() {
        return role;
    }

    public void setRole(AmapUserRole role) {
        this.role = role;
    }

    public AmapUserType getType() {
        return type;
    }

    public void setType(AmapUserType type) {
        this.type = type;
    }

    public AmapSpace getAmapSpace() {
        return amapSpace;
    }

    public void setAmapSpace(AmapSpace amapSpace) {
        this.amapSpace = amapSpace;
    }

    public AmapIndividualUser getIndividualUser() {
        return individualUser;
    }

    public void setIndividualUser(AmapIndividualUser individualUser) {
        this.individualUser = individualUser;
    }

    public AmapWorksComitteeUser getWorksComitteeUser() {
        return worksComitteeUser;
    }

    public void setWorksComittee(AmapWorksComitteeUser worksComitteeUser) {
        this.worksComitteeUser = worksComitteeUser;
    }

    public AmapProducerUser getProducerUser() {
        return producerUser;
    }

    public void setProducerUser(AmapProducerUser producerUser) {
        this.producerUser = producerUser;
    }
}
