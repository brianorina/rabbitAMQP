import java.util.HashMap;

public class Main {
    public Main() throws Exception{

        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer producer = new Producer("queue");

        for (int i = 2; i < 50; i++) {
            HashMap<String, Integer> message = new HashMap<String, Integer>();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("New Message "+ i +" sent.");
        }
    }


    public static void main(String[] args) throws Exception{
        new Main();
    }
}