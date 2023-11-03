package tn.esprit.kaddem.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant projet (Clé primaire)

    private String sujet;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private ProjetDetail projetDetail;

    @ManyToMany(mappedBy = "projets", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Equipe> equipes;

}
