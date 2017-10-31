package io.blace.microservices.fxspotservice.http;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.blace.microservices.fxspotservice.http.request.FxSpotRequest;
import io.blace.microservices.fxspotservice.mongo.fxspot.FxSpot;

@RestController
public class FxSpotRestController {

    @CrossOrigin
    @PostMapping("/fxspot")
    public ResponseEntity<FxSpot> orderreports(@RequestBody FxSpotRequest request) {
    	
    		Query q2 = new Query();
    		q2.sort().on("date", Order.DESCENDING);
    		q2.addCriteria(where("name").is(name).and("date").lte(date));
    		q2.limit(1);
    	
    		Message<OrderRequest> message = MessageBuilder.withPayload(request).build();
    		OrderSummary ordersummary = ordergateway.send(message);
    		
    		return new ResponseEntity<OrderSummary>(ordersummary, new HttpHeaders(), HttpStatus.OK);
    }
}
