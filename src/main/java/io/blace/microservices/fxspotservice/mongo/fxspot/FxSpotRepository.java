package io.blace.microservices.fxspotservice.mongo.fxspot;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FxSpotRepository extends MongoRepository<FxSpot, String> {
	FxSpot findByDateAndPair( Date date, String pair);
	FxSpot findByRisk(String risk);
	FxSpot findByRiskOrBase(String ccy);
}
