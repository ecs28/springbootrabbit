package rbt.sample.rabbitannotation.sender;

import java.time.LocalDateTime;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QSenderController {

	@Autowired
	protected Queue outboundQueue;
	
	@Autowired
	protected Queue auditQueue;
	
	@Autowired
	protected RabbitTemplate rabbitTemplate;
	
	
	public void send(String xml) {
		rabbitTemplate.convertSendAndReceive(outboundQueue.getName(), xml);
		System.out.println("Message sent - " + LocalDateTime.now()  +" :  " + xml);
	}
	
	
	public void sendAudit(String xml) {
		rabbitTemplate.convertSendAndReceive(auditQueue.getName(), xml);
		System.out.println("[Audit] Message sent - " + LocalDateTime.now()  +" :  " + xml);
	}
	
}
