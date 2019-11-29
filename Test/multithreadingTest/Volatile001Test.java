package multithreadingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author defang.yan
 * @date 19-11-19 下午2:43
 */
public class Volatile001Test {
    /*volatile int*/AtomicInteger count = new AtomicInteger(0);
    /*synchronized*/ void m(){
        for (int i = 0; i < 10000 ; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Volatile001Test volatile001Test = new Volatile001Test();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(volatile001Test::m,"thread"+i));
        }
        //此处new了十个线程,若 count类型不为volatile类型,且m方法不为synchronized 关键字修饰的可以 看出结果 是无序的
        // PS  这你  我们可以用到原子类型  AtomicInteger  来替换 Int  结果也是一样的 说明   Atomic  具有原子性  同步数据  直接用Atomic类
        threads.forEach(thread -> thread.start());
        threads.forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(volatile001Test.count);
    }
}
//思考题    写一个程序证明 AtomicXXX类的多个方法并不构成原子性  (用到两个方法 不加锁   可能会被其他线程影响)