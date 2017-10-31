package io.blace.microservices.fxspotservice.integration.services;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.TabularResult;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

import io.blace.microservices.fxspotservice.http.request.SpotArchiveRequest;
import io.blace.microservices.fxspotservice.mongo.fxspot.FxSpot;
import io.blace.microservices.fxspotservice.mongo.fxspot.FxSpotRepository;

@Service
public class SpotArchiveService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FxSpotRepository fxspotrepo;
	
	public Message<TabularResult> sourcequandlrates(Message<SpotArchiveRequest> request) {
		SpotArchiveRequest _request = (SpotArchiveRequest)request.getPayload();
		
		logger.info( "sourcequandlrates " + _request.toString());
		
		ClassicQuandlSession session = ClassicQuandlSession.create();
		TabularResult quandlresult = session.getDataSet(
		DataSetRequest.Builder
		.of(_request.getSource() + "/" + _request.getCode())
		.withStartDate(_request.getStart())
		.withEndDate(_request.getEnd())
		.build());
		
		Message<TabularResult> message = MessageBuilder.withPayload(quandlresult)
				.copyHeaders(request.getHeaders())
				.build();
		
		return message;
		
	}
	
	public void savetomongo(List<FxSpot> fxspots) throws ParseException {
		
		for( FxSpot fxspot : fxspots ) {
			if( fxspotrepo.findByDateAndPair(fxspot.getDate(), fxspot.getPair()) == null) {
				logger.info( "savetomongo " + fxspot.toString());
				fxspotrepo.save(fxspot);
			}
				
		}
	}
}
