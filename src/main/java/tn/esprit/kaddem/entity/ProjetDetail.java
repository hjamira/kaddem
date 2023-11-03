package tn.esprit.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjetDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant projet detail (Clé primaire)

    private String description;

    private String technologie;

    private Long cout;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @OneToOne(mappedBy = "projetDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Projet projet;

}
