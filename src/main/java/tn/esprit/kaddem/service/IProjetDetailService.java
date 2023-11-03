package tn.esprit.kaddem.service;

import tn.esprit.kaddem.entity.ProjetDetail;

import java.util.List;

public interface IProjetDetailService {

    public List<ProjetDetail> retrieveAllProjetDetails();

    public ProjetDetail retrieveProjetDetail(Long projetDetailId);

    public ProjetDetail addProjetDetail(ProjetDetail p);

    public void removeProjetDetail(Long projetDetailId);

    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail);


}
