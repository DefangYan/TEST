package ruins.demo;

import java.util.*;

/**
 * @author defang.yan
 * @date 19-10-24 上午11:17
 */
public class QuenTest  {
    public static void main(String[] args) {
        sout(args);
        Queue <Integer>objects  = new LinkedList<>();
        ((LinkedList<Integer>) objects).add(0,null);
        ((LinkedList<Integer>) objects).add(1,2);
        ((LinkedList<Integer>) objects).add(2,4);
        HashSet<Object> objects1 = new HashSet<>();


        objects.forEach(integer -> System.out.println(integer));
        System.out.println("_____________________________");
        objects.remove();
        objects.forEach(integer -> System.out.println( integer));
    }

    private static void sout(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

}
