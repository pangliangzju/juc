package threadsequence.solution3;

public class Solution {
    public static void main(String[] args) {
        Thread T1= new Thread(()->{
            System.out.println("T1");
        });
        Thread T2= new Thread(()->{
            System.out.println("T2");
            try {
                T1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread T3=new Thread(()->{
            System.out.println("T3");
            try {
                T2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        T1.start();
        T2.start();
        T3.start();
    }
}
