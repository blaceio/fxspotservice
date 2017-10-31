package io.blace.microservices.fxspotservice.mongo.spotcodes;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface FxspotcodesRepository extends MongoRepository<Fxspotcodes, String> {
	List<Fxspotcodes> findAll();
}
