package fr.seve.entities;

import javax.persistence.*;

@Entity
@Table(name = "amap_spaces")
public class AmapSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "amap_id", nullable = false)
    private AMAP amap;

    @OneToOne
    @JoinColumn(name = "configuration_id", nullable = false)
    private Configuration configuration;

    @OneToOne
    @JoinColumn(name = "saas_user_id", nullable = false)
    private SaasUser saasUser;


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

    public SaasUser getSaasUser() {
        return saasUser;
    }

    public void setSaasUser(SaasUser saasUser) {
        this.saasUser = saasUser;
    }
}
