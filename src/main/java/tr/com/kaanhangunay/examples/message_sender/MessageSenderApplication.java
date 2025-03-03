package tr.com.kaanhangunay.examples.message_sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.com.kaanhangunay.examples.messages.ExampleMessage;
import tr.com.kaanhangunay.examples.models.Destination;
import tr.com.kaanhangunay.examples.models.QueueMessageType;
import tr.com.kaanhangunay.examples.service.MessageSenderService;

@SpringBootApplication
public class MessageSenderApplication implements CommandLineRunner {

  @Autowired private MessageSenderService messageSenderService;

  public static void main(String[] args) {
    SpringApplication.run(MessageSenderApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ExampleMessage exampleMessage = new ExampleMessage();
    exampleMessage.setMessage("Test Message");
    messageSenderService.to(
        QueueMessageType.EXAMPLE_MESSAGE, exampleMessage, Destination.MESSAGE_RECEIVER);
  }
}
