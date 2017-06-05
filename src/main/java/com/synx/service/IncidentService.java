package com.synx.service;

import com.synx.dao.IncidentRepository;
import com.synx.dao.UserRepository;
import com.synx.model.Incident;
import com.synx.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public List<Incident> findAll() {
        List<Incident> incidents = new ArrayList<>();
        for(Incident incident : incidentRepository.findAll()){
            incidents.add(incident);
        }
        return incidents;
    }

    public Incident findUser(int id) {
        return incidentRepository.findOne(id);
    }

    public void save(Incident incident){
        incidentRepository.save(incident);
    }

    public void delete(int id){
        incidentRepository.delete(id);
    }
}
