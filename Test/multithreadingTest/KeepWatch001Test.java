package multithreadingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author defang.yan
 * @date 19-11-20 上午9:58
 */
public class KeepWatch001Test {

    volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        KeepWatch001Test keepWatch001Test = new KeepWatch001Test();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("T2线程启动");
            if(keepWatch001Test.size()!= 8){
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("T2结束");
        },"T2").start();

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("T1线程启动");
            for (int i = 0; i < 10; i++) {
                keepWatch001Test.add(new Object());
                System.out.println("add" + i);
                if (keepWatch001Test.size() == 8) {
                    countDownLatch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        ,"T1").start();



    }
}
