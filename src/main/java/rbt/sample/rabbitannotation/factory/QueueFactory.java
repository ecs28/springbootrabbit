package rbt.sample.rabbitannotation.factory;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueFactory {

	//outbound parameters
	@Value("${sample.outbound.queue.name}")
	protected String outboundQueueName;
	
	@Value("${sample.outbound.queue.durable:false}")
	protected boolean outboundQueueDurable;
	
	//inbound parameters
	@Value("${sample.inbound.queue.name}")
	protected String inboundQueueName;
	
	@Value("${sample.inbound.queue.durable:false}")
	protected boolean inboundQueueDurable;
		
	@Value("${sample.inbound.queue.maxthreads:1}")
	protected int maxThreads;
	

	//audit parameters
	@Value("${sample.audit.queue.name}")
	protected String auditQueueName;
	
	@Value("${sample.audit.queue.durable:false}")
	protected boolean auditQueueDurable;
	
	//queue beans
	@Bean
    public Queue outboundQueue() {
        return new Queue(outboundQueueName, outboundQueueDurable);
    }

	@Bean
    public Queue auditQueue() {
        return new Queue(auditQueueName, auditQueueDurable);
    }
	
	@Bean
    public Queue inboundQueue() {
        return new Queue(inboundQueueName, inboundQueueDurable);
    }
}
