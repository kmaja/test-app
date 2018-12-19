package pl.comarch.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.comarch.test.model.NyBox;
import pl.comarch.test.service.ClientService;

@RestController
@RequestMapping(path = "/test-app/v1")
public class TestController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(path = "/client/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getClientData(@PathVariable(name = "id") String clientId) {
		return clientService.getClientData(clientId);
	}
	
	@RequestMapping(path = "/box", method = RequestMethod.GET, produces = "application/json")
	public NyBox getBox() {
		NyBox box = new NyBox();
		box.setDlugosc(1);
		box.setSzerokosc(2);
		box.setRodzaj("karton");
		return box;
	}
	

}
