package producercomsumer.solution1;

import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public static class Message {
        private int id;
        private Object message;

        public Message(int id, Object message) {
            this.id = id;
            this.message = message;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }
    }

    public static class MessageQueue {
        private LinkedList<Message> queue;
        private int capacity;

        public MessageQueue(int capacity) {
            this.capacity = capacity;
            queue = new LinkedList<>();
        }

        public Message take() {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("没货了");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = queue.removeFirst();
                queue.notifyAll();
                return message;
            }
        }
        public void put(Message message){
            synchronized (queue){
                while (queue.size()==capacity){
                    System.out.println("队列满了！");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(message);
                queue.notifyAll();
            }
        }
    }
}
