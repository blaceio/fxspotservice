package io.blace.microservices.fxspotservice.http;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.blace.microservices.fxspotservice.dateutil.DateUtil;
import io.blace.microservices.fxspotservice.http.request.FxSpotRequest;
import io.blace.microservices.fxspotservice.mongo.fxspot.FxSpot;
import io.blace.microservices.fxspotservice.mongo.fxspot.FxSpotRepository;

@RestController
public class FxSpotRestController {

	@Autowired
	private FxSpotRepository fxspotrepo;
	
	@Autowired
	private DateUtil dateutil;
	
    @CrossOrigin
    @PostMapping("/fxspotbydateandpair")
    public ResponseEntity<FxSpot> fxspotbydateandpair(@RequestBody FxSpotRequest request) {
    		List<FxSpot> fxspot = fxspotrepo.findByDateAndPair(dateutil.getEndOfDay(request.getDate()), request.getCcypair(), new PageRequest(0, 1, new Sort( new Order(Direction.DESC, "date")))).getContent();
    		return new ResponseEntity<FxSpot>(fxspot.get(0), new HttpHeaders(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping("/fxspotbydateandrisk")
    public ResponseEntity<FxSpot> fxspotbydateandrisk(@RequestBody FxSpotRequest request) {
    		List<FxSpot> fxspot = fxspotrepo.findByDateAndRisk(dateutil.getEndOfDay(request.getDate()), request.getCcy(), new PageRequest(0, 1, new Sort( new Order(Direction.DESC, "date")))).getContent();
    		return new ResponseEntity<FxSpot>(fxspot.get(0), new HttpHeaders(), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping("/fxspotbydateandriskorbase")
    public ResponseEntity<FxSpot> fxspotbydateandriskorbase(@RequestBody FxSpotRequest request) {
    		List<FxSpot> fxspot = fxspotrepo.findByDateAndRiskOrBase(dateutil.getEndOfDay(request.getDate()), request.getCcy(), new PageRequest(0, 1, new Sort( new Order(Direction.DESC, "date")))).getContent();
    		return new ResponseEntity<FxSpot>(fxspot.get(0), new HttpHeaders(), HttpStatus.OK);
    }
}
