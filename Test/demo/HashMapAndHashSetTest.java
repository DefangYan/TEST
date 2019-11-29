package ruins.demo;

import java.util.HashMap;

/**
 * @author defang.yan
 * @date 19-10-28 上午10:05
 */
public class HashMapAndHashSetTest {
    public static void main(String[] args) {
        HashMap<String, String> objectObjectHashMap = new HashMap<String ,String>();
        objectObjectHashMap.put("san", "张三");
        objectObjectHashMap.put("si", "李四");
        objectObjectHashMap.put("wu", "王五");
        objectObjectHashMap.put("wang", "老王");
        objectObjectHashMap.put("wang", "老王2");// 老王被覆盖
        objectObjectHashMap.put("lao", "老王");
        for (String key: objectObjectHashMap.keySet()
             ) {
            System.out.println(key+ objectObjectHashMap.get(key));
        }

    }
}
