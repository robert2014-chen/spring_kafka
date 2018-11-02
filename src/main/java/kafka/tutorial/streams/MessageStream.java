/**
 * 
 */
package kafka.tutorial.streams;

/**
 * @author akhaurishekhar
 */

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel; 

public interface MessageStream {
	
	String INPUT = "messages-in";
    String OUTPUT = "messages-out";
    
    @Input(INPUT)
    SubscribableChannel inboundMessages();
    
    @Output(OUTPUT)
    MessageChannel outboundMessages();
    
}