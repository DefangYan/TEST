package ruins.demo;

/**
 * @author defang.yan
 * @date 19-10-29 上午10:45
 */
public class DeadLockDemo {
    private static Object object1 = new Object();
    private static Object object2 = new Object();
    public static void main(String[] args) {
        new Thread(()-> {
            synchronized (object1){
                System.out.println(Thread.currentThread()+"get object1");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread() + "waiting get object2");
            synchronized (object2) {
                System.out.println(Thread.currentThread() + "get object2");
            }
        },"线程1").start();

        new Thread(() -> {
            synchronized (object2) {
                System.out.println(Thread.currentThread() + "get object2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get object1");
                synchronized (object1) {
                    System.out.println(Thread.currentThread() + "get object1");
                }
            }
        }, "线程 2").start();

    }

}


