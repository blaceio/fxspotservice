package io.blace.microservices.fxspotservice.integration.gateway;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import io.blace.microservices.fxspotservice.http.request.SpotArchiveRequest;

@Component
public interface SpotArchiveGateway {  
	 public void send(Message<SpotArchiveRequest> message);  
}