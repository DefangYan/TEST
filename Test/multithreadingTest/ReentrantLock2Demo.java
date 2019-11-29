package multithreadingTest;

/**
 * @author defang.yan
 * @date 19-11-20 上午11:34
 */
public class ReentrantLock2Demo{


    public static void main(String[] args) {
        int m = 0;
        int n = 0;
        for (int i = 0; i < 100; i++) {
            m = m++;
            n = ++n;
        }
        System.out.println(m);
        System.out.println(n);
        System.out.println(m+n);
    }
}
