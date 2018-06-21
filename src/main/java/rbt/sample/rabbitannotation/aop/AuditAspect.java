package rbt.sample.rabbitannotation.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rbt.sample.rabbitannotation.sender.QSenderController;

@Aspect
@Component
public class AuditAspect {
	
		@Autowired
		private QSenderController sender; 
	
	    @After("execution(* rbt.sample.rabbitannotation.sender.QSenderController.send (java.lang.String)) && args(xml)")
	    public void beforeSendMessage(String xml) {
	    	System.out.println("Message capture- " + LocalDateTime.now() +  " : " + xml);
	    	sender.sendAudit(xml);
	    }
}
