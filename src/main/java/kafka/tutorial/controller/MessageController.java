package kafka.tutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kafka.tutorial.entity.Messages;
import kafka.tutorial.service.MessagingService;

@RestController
public class MessageController {
	
	private final MessagingService messagingService;

//	@Autowired
    public MessageController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }
	
    @GetMapping("/messages")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void messages(@RequestParam("message") String message) {
    	Messages msg = Messages.builder().message(message).timestamp(System.currentTimeMillis()).build();
    	messagingService.sendMessage(msg);
    }
}