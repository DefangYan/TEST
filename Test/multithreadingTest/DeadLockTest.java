package multithreadingTest;

/**
 * @author defang.yan
 * @date 19-11-19 上午10:32
 */
public class DeadLockTest {
    public static void main(String[] args) {
        DeadLock deadLock0 = new DeadLock(1);
        DeadLock deadLock1 = new DeadLock(0);
        new Thread(deadLock0).start();
        new Thread(deadLock1).start();
    }

    static class DeadLock implements Runnable{
        private int value;

        private static Object o1 = new Object(),o2 = new Object();
        @Override
        public void run() {
            if (value == 1){
                synchronized (o1){
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("这是lock0调用o1");
                    synchronized (o2){
                        System.out.println("这是lock0调用o2");
                    }

                }

            }
            if (value == 0){
                synchronized (o2){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("这是lock1调用o2");

                    synchronized (o1){
                        System.out.println("这是lock1调用o1");
                    }
                }

            }
        }

        public DeadLock(int value) {
           this.value=value;
        }
    }

}
