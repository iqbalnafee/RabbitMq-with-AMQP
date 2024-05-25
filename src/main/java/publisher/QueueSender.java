package publisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class QueueSender {

    private final static String QUEUE_NAME = "hello";
    //private final static String host = "141.13.5.134";
    private final static String host = "localhost";
    //private final static String ROUTING_KEY = "helloMessageQueue";
    private final static String ROUTING_KEY = QUEUE_NAME;

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false,
                    false, false, null);
            String message = "Hello World 4.0!";
            channel.basicPublish("", ROUTING_KEY,
                    null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        }

    }


}
