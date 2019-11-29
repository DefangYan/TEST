package ruins.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author defang.yan
 * @date 19-11-12 上午10:11
 */
public class AtomicTest {
    static void getTest(){
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Thread thread = new Thread(() -> {
            final int i = atomicInteger.get();
            System.out.println(Thread.currentThread().getName() + "------------currentValue" + i);
            
        });

    }
}
