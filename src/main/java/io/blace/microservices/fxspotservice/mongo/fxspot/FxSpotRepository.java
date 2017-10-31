package io.blace.microservices.fxspotservice.mongo.fxspot;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FxSpotRepository extends MongoRepository<FxSpot, String> {
	
	@Query("{'pair': ?1, 'date': {$lte: ?0}}")
	Page<FxSpot> findByDateAndPair( Date date, String pair, Pageable pageable);
	
	@Query("{'risk': ?1, 'date': {$lte: ?0}}")
	Page<FxSpot> findByDateAndRisk( Date date, String risk, Pageable pageable);

	@Query("{ $or: [{'risk': ?1}, {'base': ?1}], 'date': {$lte: ?0}}")
	Page<FxSpot> findByDateAndRiskOrBase( Date date, String ccy, Pageable pageable);
	
	FxSpot findByDateAndPair( Date date, String pair);

}
