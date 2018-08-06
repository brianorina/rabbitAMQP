import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class ClientPoint {

    protected Channel channel;
    protected Connection connection;
    protected String clientPointName;

    public ClientPoint(String clientpointName) throws IOException{
        this.clientPointName = clientpointName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        //Create a queue for the channel
        channel.queueDeclare(clientpointName, false, false, false, null);
    }

    public void close() throws IOException{
        this.channel.close();
        this.connection.close();
    }
}
