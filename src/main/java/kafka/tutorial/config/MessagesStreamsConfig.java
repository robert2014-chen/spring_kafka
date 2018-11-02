/**
 * 
 */
package kafka.tutorial.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import kafka.tutorial.streams.MessageStream;

/**
 * @author akhaurishekhar
 */

@EnableBinding(MessageStream.class)
public class MessagesStreamsConfig {
	
	
}