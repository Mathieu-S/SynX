package com.synx.dao;

import com.synx.model.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
}
