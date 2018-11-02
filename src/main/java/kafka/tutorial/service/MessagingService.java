package kafka.tutorial.service;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import kafka.tutorial.entity.Messages;
import kafka.tutorial.streams.MessageStream;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessagingService {

	private final MessageStream messageStreams;
	
	public MessagingService(MessageStream messageStreams) {
		this.messageStreams = messageStreams;
	}
	
	public void sendMessage(final Messages messages) {
		log.info("Sending messages {}", messages);
		MessageChannel messageChannel = messageStreams.outboundMessages();
		messageChannel.send(MessageBuilder
				.withPayload(messages)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
}