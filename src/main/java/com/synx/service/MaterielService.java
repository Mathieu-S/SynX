package com.synx.service;

import com.synx.dao.MaterielRepository;
import com.synx.model.Materiel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MaterielService {

    private final MaterielRepository materielRepository;

    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    public List<Materiel> findAll() {
        List<Materiel> materiels = new ArrayList<>();
        for(Materiel materiel : materielRepository.findAll()){
            materiels.add(materiel);
        }
        return materiels;
    }

    public Materiel findMateriel(int id) {
        return materielRepository.findOne(id);
    }

    public void save(Materiel materiel){
        materielRepository.save(materiel);
    }

    public void delete(int id){
        materielRepository.delete(id);
    }
}
