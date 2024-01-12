package kdu.questwo;

import kdu.quesone.MessageQueue;
import kdu.quesone.MessageReceiver;
import kdu.quesone.MessageSender;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue();


        ExecutorService executorService = Executors.newFixedThreadPool(6);

        // Can also create using loops for multiple threads
        executorService.execute(new MessageSender(messageQueue,"First message"));
        executorService.execute(new MessageSender(messageQueue,"Second message"));
        executorService.execute(new MessageSender(messageQueue,"Third message"));

        executorService.execute(new MessageReceiver(messageQueue,"First Receiver"));
        executorService.execute(new MessageReceiver(messageQueue,"Second Receiver"));
        executorService.execute(new MessageReceiver(messageQueue,"Third Receiver"));


        executorService.shutdown();

    }
}
