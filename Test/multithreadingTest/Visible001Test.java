package multithreadingTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author defang.yan
 * @date 19-11-19 下午3:11
 */
public class Visible001Test {
    /*volatile*/ AtomicBoolean flag = new AtomicBoolean(true);// 这里的volatile  具有可见性   ,证明 Atomic 是否具有 可见性   证明  具有可见性

    void m(){
        System.out.println("start");
        if(flag.get()==true){

        }
        System.out.println("end");
    }


    public static void main(String[] args) {
        Visible001Test visible001Test = new Visible001Test();
        new Thread(visible001Test :: m).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        visible001Test.flag.set(false);
    }
}
