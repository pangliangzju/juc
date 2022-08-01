package print.solution1;

public class Solution {
    public static void main(String[] args) {
        WaitNotify wt=new WaitNotify(5,1);
        new Thread(()->{
            wt.print("a",1,2);
        }).start();
        new Thread(()->{
            wt.print("b",2,3);
        }).start();
        new Thread(()->{
            wt.print("c",3,1);
        }).start();
    }
    public static class WaitNotify{
        private int loopNum;
        private int flag;

        public WaitNotify(int loopNum, int flag) {
            this.loopNum = loopNum;
            this.flag = flag;
        }

        public void print(String str,int currentFlag,int nextFlag){
            for (int i = 0; i < loopNum; i++) {
                synchronized (this){
                    while (flag!=currentFlag){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(str+" ");
                    flag=nextFlag;
                    notifyAll();
                }
            }
        }
    }
}
