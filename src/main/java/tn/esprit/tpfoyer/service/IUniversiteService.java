package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite retrieveUniversite(Long universiteId);
    Universite addUniversite(Universite u);
    Universite modifyUniversite(Universite universite);
    void removeUniversite(Long universiteId);
    List<Universite> findByLocation(String location);
    List<Universite> findByNomUniversite(String nomUniversite);
}
