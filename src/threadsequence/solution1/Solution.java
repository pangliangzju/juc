package threadsequence.solution1;

/**
 * 让三个线程按顺序执行
 * 第一种方法① 使用 Thread.join() 方法
 *
 * @author somnu
 */
public class Solution {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("First Thread");
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second Thread");
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Third Thread");
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
