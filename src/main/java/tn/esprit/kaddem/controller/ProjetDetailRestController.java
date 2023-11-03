package tn.esprit.kaddem.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entity.ProjetDetail;
import tn.esprit.kaddem.service.IProjetDetailService;
import tn.esprit.kaddem.service.ProjetDetailServiceImpl;

import java.util.List;

@Tag(name = "Web Services pour la gestion de Projet Details")
@RestController
@RequestMapping("/projet-detail")
public class ProjetDetailRestController {

    @Autowired
    IProjetDetailService projetDetailService;

    // http://localhost:8089/kaddem/projet-detail/retrieve-all-projetdetails

    @Operation(description = "Ceci récupère la liste de tous les Projets-Détails")
    @GetMapping("/retrieve-all-projetdetails")
    public List<ProjetDetail> getProjetDetails() {
        List<ProjetDetail> listProjetDetails = projetDetailService.retrieveAllProjetDetails();
        return listProjetDetails;
    }


    // http://localhost:8089/exam/projet-detail/retrieve-proejt-detail/8
    @GetMapping("/retrieve-proejt-detail/{projet-detail-id}")
    public ProjetDetail retrieveProjetDetail(@PathVariable("projet-detail-id") Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailService.retrieveProjetDetail(projetDetailId);
        return projetDetail;
    }

    // http://localhost:8089/exam/projet-detail/add-proejt-detail
    @PostMapping("/add-proejt-detail")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail p) {
        ProjetDetail projetDetail = projetDetailService.addProjetDetail(p);
        return projetDetail;
    }

    // http://localhost:8089/exqam/projet-detail/remove-proejt-detail/{projet-detail-id}
    @DeleteMapping("/remove-proejt-detail/{projet-detail-id}")
    public void removeProjetDetail(@PathVariable("projet-detail-id") Long projetDetailId) {
        projetDetailService.removeProjetDetail(projetDetailId);
    }

    // http://localhost:8089/exam/projet-detail/modify-proejt-detail
    @PutMapping("/modify-proejt-detail")
    public ProjetDetail modifyProjetDetail(@RequestBody ProjetDetail p) {
        ProjetDetail projetDetail = projetDetailService.modifyProjetDetail(p);
        return projetDetail;
    }

}
