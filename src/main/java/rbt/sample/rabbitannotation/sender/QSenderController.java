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
	protected Queue inboundQueue;
	
	
	@Autowired
	protected RabbitTemplate rabbitTemplate;
	
	
	public void send(String xml) {
		sendMessage(outboundQueue, xml);
	}
	
	
	public void sendAudit(String xml) {
		sendMessage(auditQueue, xml);
	}

	
	public void sendInbound(String xml) {
		sendMessage(inboundQueue, xml);
	}

	
	protected void sendMessage(Queue queue, String message) {
		rabbitTemplate.convertSendAndReceive(queue.getName(), message);
		System.out.println("Message sent - " + queue.getName() + " - " + LocalDateTime.now()  +" :  " + message);
	}
	
}
