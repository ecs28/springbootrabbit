package rbt.sample.rabbitannotation.consumer;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import rbt.sample.rabbitannotation.sender.QSenderController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class QConsumerControllerTest {

	
	private QConsumerController service = new QConsumerController();
	
	//mock rabbit
	@MockBean
	private RabbitAdmin rabbitAdmin;
	
	@MockBean
	private QSenderController sender;
	
	@Before
	public void setUp() {
		service.senderController =  sender;
	}
	
	
	@Test
	public void sendValidXmlMsg_test() {
		Message message = new Message("<a><aa></aa></a>".getBytes(), null);
		service.receiveInboundMessage(message);
		assertTrue(true);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void sendNullMsg_test() {
		Message message = new Message(null, null);
		service.receiveInboundMessage(message);
		assertTrue(true);
	}

}
