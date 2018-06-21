package rbt.sample.rabbitannotation.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbt.sample.rabbitannotation.sender.QSenderController;

@Component
public class QConsumerController {
	
	@Autowired
	protected QSenderController senderController;

	@RabbitListener(queues= {"${sample.inbound.queue.name}"})
	public void receiveInboundMessage(Message message) {
		String xml = new String(message.getBody()) ;
		System.out.println("Message read - " + LocalDateTime.now()  +" :  " + xml);
		senderController.send(xml);
	}
}
