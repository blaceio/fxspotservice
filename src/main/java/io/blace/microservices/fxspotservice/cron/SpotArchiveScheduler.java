package io.blace.microservices.fxspotservice.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDate;

import io.blace.microservices.fxspotservice.http.request.SpotArchiveRequest;
import io.blace.microservices.fxspotservice.integration.gateway.SpotArchiveGateway;
import io.blace.microservices.fxspotservice.mongo.spotcodes.Fxspotcodes;
import io.blace.microservices.fxspotservice.mongo.spotcodes.FxspotcodesRepository;

@Service
public class SpotArchiveScheduler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FxspotcodesRepository fxspotcodesrepo;
	
	@Autowired
	private SpotArchiveGateway spotarchivegateway;
	
	@Scheduled(cron="0/60 * * * * *")
	public void triggerarchive() {
		
		logger.info("Spot Archive Triggered");
		
		LocalDate today = LocalDate.now();
	    LocalDate fivedaysback = today.minusDays(7);

		for( Fxspotcodes fxspotcode : fxspotcodesrepo.findAll()) {
			SpotArchiveRequest spotarchiverequest = new SpotArchiveRequest();
			spotarchiverequest.setStart(fivedaysback);
			spotarchiverequest.setEnd(today);
			spotarchiverequest.setPair(fxspotcode.getPair());
			spotarchiverequest.setCode(fxspotcode.getCode());
			spotarchiverequest.setSource(fxspotcode.getSource());
			spotarchiverequest.setUrl(fxspotcode.getUrl());
			
			Message<SpotArchiveRequest> message = MessageBuilder.withPayload(spotarchiverequest)
					.setHeader("pair", fxspotcode.getPair())
					.build();
			
			spotarchivegateway.send(message);
		}
	}
	
}
