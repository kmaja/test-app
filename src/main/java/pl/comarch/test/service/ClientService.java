package pl.comarch.test.service;

import org.springframework.http.ResponseEntity;

public interface ClientService {

	ResponseEntity<?> getClientData(String clientId);

}