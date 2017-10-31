package io.blace.microservices.fxspotservice.integration.transformers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.jimmoores.quandl.Row;
import com.jimmoores.quandl.TabularResult;

import io.blace.microservices.fxspotservice.mongo.fxspot.FxSpot;

@Service
public class SpotArchiveTransform {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<FxSpot> quandltofxspot(Message<TabularResult> result) throws ParseException {
		TabularResult _result = (TabularResult)result.getPayload();

		logger.info( "quandltofxspot " + _result.toString());
		
		String ccypair = result.getHeaders().get("pair").toString();
		String base = ccypair.substring(0, 3);
		String risk = ccypair.substring(ccypair.length() - 3);
		
		List<FxSpot> fxspots = new ArrayList<FxSpot>();
		
		for (final Row row : _result) {
			  FxSpot fxspot = new FxSpot();
			  fxspot.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(row.getLocalDate("Date").toString()));
			  fxspot.setPair(ccypair);
			  fxspot.setBase(base);
			  fxspot.setRisk(risk);
			  fxspot.setRate(row.getDouble("Value"));
			  fxspot.setLastupdated(new Date());
			  
			  fxspots.add(fxspot);
		} 
		
		return fxspots;
	}
}
