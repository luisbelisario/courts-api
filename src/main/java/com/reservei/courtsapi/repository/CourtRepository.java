package com.reservei.courtsapi.repository;

import com.reservei.courtsapi.domain.model.Court;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends MongoRepository<Court, String> {

}
