package kdu.quesone;

import kdu.ConsoleLogger;

public class MessageReceiver implements Runnable {
    private final String receiverNumber;
    private final MessageQueue messageQueue;
    public MessageReceiver(MessageQueue messageQueue, String receiverNumber){
        this.receiverNumber = receiverNumber;
        this.messageQueue = messageQueue;
    }

    @Override
    public synchronized void run(){
        ConsoleLogger.infoMethod("It is from " + receiverNumber + ": " + messageQueue.receiveMessage());
    }

}
