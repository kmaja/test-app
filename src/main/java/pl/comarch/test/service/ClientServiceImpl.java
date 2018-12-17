package pl.comarch.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pl.comarch.test.model.MyClient;
import pl.comarch.test.model.MyError;

@Service
public class ClientServiceImpl implements ClientService {
	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Value("${test.client.name:Jonny}")
	private String clientName;
	@Value("${test.client.surname:English}")
	private String clientSurname;

	@Override
	public ResponseEntity<?> getClientData(String clientId) {
		logger.debug("getClientData: {}", clientId);
		Long id;
		try {
			id = Long.decode(clientId);
		} catch (NumberFormatException ex) {
			MyError err = new MyError();
			err.setInfo(String.format("can't convert input: %s", clientId));
			err.setMessage(ex.getMessage());
			err.setNumber(3); // conversion error for input data
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
		}
		MyClient client = new MyClient();
		client.setId(id);
		client.setAge((short) 25);
		client.setName(String.format("%s-%d", clientName, id));
		client.setSurname(clientSurname);
		return ResponseEntity.ok(client);
	}
}
