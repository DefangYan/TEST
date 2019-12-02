package multithreadingTest;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author defang.yan
 * @date 19-11-18 下午3:59
 */
public class ThreadTest extends Thread {
    //private int count = 10;
public void a(){
    System.out.println("bb" );
}
//    @Override
//    public synchronized void run() {
//       // count --;
//        //System.out.println(Thread.currentThread().getName()+"count"+count);
//        synchronized(this) {
//            while (true) {
//                notify();
//                if (count <= 100) {
//                    System.out.println(Thread.currentThread().getName() + count);
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    count++;
//                } else {
//                    break;
//                }
//                try {
//                    wait();
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    }

    private static ReentrantLock reentrantLock =new ReentrantLock(true);//公平锁

    static Queue<String> tikets = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            reentrantLock.lock();
            try{
                System.out.println(Thread.currentThread().getName());
            }
            finally{
            reentrantLock.unlock();
            }

            tikets.poll();
        }

    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
//        new Thread(threadTest,"甲").start();
//        new Thread(threadTest,"乙").start();
        new Thread(threadTest).start();
        new Thread(threadTest).start();
    }


}
class ThreadTest1 extends Thread {

    private static ReentrantLock reentrantLock1 =new ReentrantLock(true);//公平锁
    @Override
    public void run() {
        for (int i = 0; i <=100 ; i++) {
            reentrantLock1.lock();
            try{
                System.out.println(Thread.currentThread().getName());
            }
            finally{
                reentrantLock1.unlock();
            }
        }

    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        new Thread(threadTest).start();
        new Thread(threadTest).start();
    }


}