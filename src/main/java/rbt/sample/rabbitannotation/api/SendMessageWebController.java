package rbt.sample.rabbitannotation.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rbt.sample.rabbitannotation.sender.QSenderController;

@RestController
public class SendMessageWebController {
	
	@Autowired
	private QSenderController sender;
	
	//mapping root method	
	@RequestMapping(value = "/send/{message}")
	public String index(@PathVariable String message) {
		sender.sendInbound(message);
		return "Message sent : " + LocalDateTime.now();
	}
	

}
