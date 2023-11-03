package tn.esprit.kaddem.service;

import tn.esprit.kaddem.entity.Projet;

import java.util.List;

public interface IProjetService {

    public List<Projet> retrieveAllProjets();

    public Projet retrieveProjet(Long projetId);

    public Projet addProjet(Projet p);

    public void removeProjet(Long projetId);

    public Projet modifyProjet(Projet projet);

    public void assignProjetDetailToProjet(Long ProjetDetailId, Long projetId);

    public void assignProjetToEquipe(Long projetId, Long equipeId);

    public Projet addProjetAndProjetDetailAndAssign(Projet projet);

    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);


}
