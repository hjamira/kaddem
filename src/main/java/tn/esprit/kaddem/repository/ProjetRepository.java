package tn.esprit.kaddem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entity.Projet;
import tn.esprit.kaddem.entity.ProjetDetail;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {


}