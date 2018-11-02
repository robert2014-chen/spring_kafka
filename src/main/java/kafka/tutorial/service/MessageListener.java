package kafka.tutorial.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import kafka.tutorial.entity.Messages;
import kafka.tutorial.streams.MessageStream;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageListener {

	@StreamListener(MessageStream.INPUT)
	public void handleGreetings(@Payload Messages message) {
		log.info("Received message: {}", message);
	}
}