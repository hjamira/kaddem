package tn.esprit.kaddem.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entity.Projet;
import tn.esprit.kaddem.service.IProjetService;

import java.util.List;

@Tag(name = "Web Services pour la gestion de Projets")
@RestController
@RequestMapping("/projet")
public class ProjetRestController {

    @Autowired
    IProjetService projetService;

    // http://localhost:8089/kaddem/projet/retrieve-all-projets

    @Operation(description = "Ceci récupère la liste de tous les Projets")
    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        List<Projet> listProjets = projetService.retrieveAllProjets();
        return listProjets;
    }


    // http://localhost:8089/exam/projet/retrieve-projet/8
    @GetMapping("/retrieve-projet/{projet-id}")
    public Projet retrieveProjet(@PathVariable("projet-id") Long proejtId) {
        Projet projet = projetService.retrieveProjet(proejtId);
        return projet;
    }

    // http://localhost:8089/exam/projet/add-projet
    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet p) {
        Projet projet = projetService.addProjet(p);
        return projet;
    }

    // http://localhost:8089/exam/projet/remove-projet/{projet-id}
    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") Long proejtId) {
        projetService.removeProjet(proejtId);
    }

    // http://localhost:8089/exam/projet/modify-projet
    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet p) {
        Projet projet = projetService.modifyProjet(p);
        return projet;
    }

    // http://localhost:8089/exam/projet/ajouter-projet-et-projet-detail
    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet p) {
        Projet projet = projetService.addProjetAndProjetDetailAndAssign(p);
        return projet;
    }

    // http://localhost:8089/exam/projet/affecter-projet-projet-details/1/1
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecgterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId, @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
    }

    // http://localhost:8089/exam/projet/affecter-projet-projet-details/1
    @PostMapping("/ajouter-projet-affecter-projet-details/{projet-details-id}")
    public void ajouterProjetEtaffecterProjetDetail(@RequestBody Projet p, @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetService.addProjetAndAssignProjetToProjetDetail(p, proejtDetailsId);
    }

}
