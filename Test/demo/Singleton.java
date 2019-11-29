package ruins.demo;


import java.util.HashMap;
import java.util.Map;

/**
 * @author defang.yan
 * @date 19-10-29 下午4:25
 */
public class Singleton {
    private volatile static Singleton singleton ;
    Singleton(){

    }
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getSingleton());
        System.out.println(Singleton.getSingleton());

        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(7, "James");
        namesMap.keySet().forEach(key -> System.out.println(key));
    }

}
