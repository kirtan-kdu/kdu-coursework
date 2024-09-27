package kdu.quesone;

import kdu.ConsoleLogger;

public class MessageSender implements Runnable {
    private final String message;
    private final MessageQueue messageQueue;
    public MessageSender(MessageQueue messageQueue, String message){
        this.message = message;
        this.messageQueue = messageQueue;
    }


    @Override
    public synchronized void run(){
        messageQueue.addMessage(message);
        ConsoleLogger.infoMethod(message + " is appended to message queue");
    }
}
