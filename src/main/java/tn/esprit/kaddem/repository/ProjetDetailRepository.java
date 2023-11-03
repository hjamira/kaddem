package tn.esprit.kaddem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.kaddem.entity.ProjetDetail;

import java.util.List;

@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail, Long> {


    @Query("SELECT p FROM ProjetDetail p WHERE p.cout > :cp")
    List<ProjetDetail> récupererProjetDetailsSelonProjet(Long cp);

    @Modifying
    @Query("UPDATE ProjetDetail p SET p.cout=:cp ")
    void updateCout(Long cp);

    public List<ProjetDetail> findAllByDescriptionIsNotNull();

    // Liste ProjetDetails dont la description contient un mot donné
    public List<ProjetDetail> findAllByDescriptionContaining(String d);

    // Méthode semi prête qui récupère la  liste des ProjetDetails
    // liés à des projets avec un sujet précis,
    // LE résultat est ordonné par la technologie
    public List<ProjetDetail> findAllByProjet_SujetOrderByTechnologie(String sujet);

}