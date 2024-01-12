package kdu.quesone;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageQueue {
        private Deque<String> deque;

        public void addMessage(String message){
            deque.add(message);
        }

        public MessageQueue() {
            deque = new ArrayDeque<>();
        }
        public synchronized String receiveMessage(){
            while (true){
                if (!deque.isEmpty()){
                    return deque.poll();
                }
            }
        }

}
