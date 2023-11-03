package tn.esprit.kaddem.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entity.ProjetDetail;
import tn.esprit.kaddem.repository.ProjetDetailRepository;

import java.util.List;

@Service
@Slf4j
public class ProjetDetailServiceImpl implements IProjetDetailService {

    @Autowired
    ProjetDetailRepository projetDetailRepository;

    //@Scheduled(fixedDelay = 10000)
    // @Scheduled(fixedDelay = 10000)
    public List<ProjetDetail> retrieveAllProjetDetails() {

        //log.info("In Method : retrieveAllProjetDetails ");

        List<ProjetDetail> listProjetDetails = projetDetailRepository.findAll();
        for (ProjetDetail projetDetail : listProjetDetails) {
            log.info("j'affiche un prjetDetail : " + projetDetail);
        }

        //log.info("Out of Method : retrieveAllProjetDetails ");

        return listProjetDetails;
    }

    public ProjetDetail retrieveProjetDetail(Long projetDetailId) {
        //log.info("In Method retrieveProjetDetail");
        ProjetDetail projetdetail = projetDetailRepository.findById(projetDetailId).get();
        log.info("je veux afficher ce proejt detail : " + projetdetail);
        //log.info("Out of Method retrieveProjetDetail");
        return projetdetail;
    }

    public ProjetDetail addProjetDetail(ProjetDetail p) {
        //log.info("In method addProjetDetail ");
        ProjetDetail projetDetail = projetDetailRepository.save(p);
        //log.info("Out method addProjetDetail ");
        return projetDetail;
    }

    public void removeProjetDetail(Long projetDetailId) {
        //log.info("In Method removeProjetDetail");
        projetDetailRepository.deleteById(projetDetailId);
        //log.info("Out of Method removeProjetDetail");
    }

    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail) {
        //log.info("In Method modifyProjetDetail");
        ProjetDetail tmp = projetDetailRepository.save(projetDetail);
        //log.info("Out of Method modifyProjetDetail");
        return tmp;
    }

}
