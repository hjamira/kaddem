package tn.esprit.kaddem.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entity.Equipe;
import tn.esprit.kaddem.entity.Projet;
import tn.esprit.kaddem.entity.ProjetDetail;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.ProjetDetailRepository;
import tn.esprit.kaddem.repository.ProjetRepository;

import java.util.List;

@Service
@Slf4j
public class ProjetServiceImpl implements IProjetService {
    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    ProjetDetailRepository projetDetailRepository;
    @Autowired
    EquipeRepository equipeRepository;

    @Scheduled(fixedDelay = 10000)
    public List<Projet> retrieveAllProjets() {

        //log.info("In Method : retrieveAllProjets ");

        List<Projet> listProjets = projetRepository.findAll();
        for (Projet projet : listProjets) {
            log.info("j'affiche un prjet : " + projet);
        }

        //log.info("Out of Method : retrieveAllProjets ");

        return listProjets;

    }

    public Projet retrieveProjet(Long projetId) {
        return projetRepository.findById(projetId).get();
    }

    public Projet addProjet(Projet p) {
        return projetRepository.save(p);
    }

    public void removeProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }

    public Projet modifyProjet(Projet projet) {
        return projetRepository.save(projet);
    }


    // Projet et ProjetDeail déjà créés :
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        // on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    // Projet et Equipe déjà dans la base :
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        // on set le fils dans le parent  :
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    // Projet et ProjetDeail ne sont pas encore créés (cascade) :
    // Dans le JSON on met le Projet et le Projet Detail
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }

    // Projet Detail déjà dans la base
    // Ajouter Produit et Affecter Projt Detail à ce projet :
    // Projet et ProjetDeail déjà créés :
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        // on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    // Désaffecter ProjetDetail d'un Projet :
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }

    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        // on enlève le fils du parent :
        equipe.getProjets().remove(projet);
        projetRepository.save(projet);
    }

}
