package threadsequence.solution2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Solution {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("First Thread");
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second Thread");
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Third Thread");
            }
        });
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.shutdown();
        //最好是手动创建线程池
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
    }
}
