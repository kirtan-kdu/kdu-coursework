package kdu.quesone;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue();

        // Can also initialize with loops for bigger threadpool
        Thread senderThread1 = new Thread(new MessageSender(messageQueue,"First message"));
        Thread senderThread2 = new Thread(new MessageSender(messageQueue,"Second message"));
        Thread senderThread3 = new Thread(new MessageSender(messageQueue,"Third message"));

        Thread receiverThread1 = new Thread(new MessageReceiver(messageQueue,"First Receiver"));
        Thread receiverThread2 = new Thread(new MessageReceiver(messageQueue,"Second Receiver"));
        Thread receiverThread3 = new Thread(new MessageReceiver(messageQueue,"Third Receiver"));

        senderThread1.start();
        receiverThread1.start();

        senderThread2.start();
        receiverThread2.start();

        senderThread3.start();
        receiverThread3.start();

    }
}