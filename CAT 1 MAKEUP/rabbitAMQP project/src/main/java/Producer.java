import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.lang.SerializationUtils;

public class Producer extends ClientPoint {

    public Producer(String clientPointName) throws IOException{
        super(clientPointName);
    }

    public void sendMessage(HashMap object) throws IOException {
        channel.basicPublish("",clientPointName, null, SerializationUtils.serialize(object));
    }
}