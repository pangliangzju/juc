package producercomsumer.practice;

import java.util.LinkedList;

public class MessageQueue {
    private int capacity;
    private LinkedList<Message> queue;

    public MessageQueue(int capacity){
        this.capacity=capacity;
        queue=new LinkedList<>();
    }

    public void put(Message message){
        synchronized (queue){
            while (queue.size()==capacity){
                System.out.println("队列已满！");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }
    public Message get(){
        synchronized (queue){
            while (queue.isEmpty()){
                System.out.println("队列为空！");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message=queue.pollFirst();
            queue.notifyAll();
            return message;
        }
    }
}
