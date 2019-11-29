package ruins.demo;

/**
 * @author defang.yan
 * @date 19-11-4 上午11:27
 */

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

/**
 * 打印  *
 *     ***
 *    *****
 *   *******打印三角形   可以看出 高为 第几行 底边为第几列2N+1
 */
public class AgeVirtualMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
//        int n = 3;
        System.out.println(args.length);
        for (int i = 1; i <= args.length; i++) {
            for (int j =1 ; j<=args.length-i; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= i*2-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
//        System.out.println(args.length+"?????aaa");
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");
        namesMap.forEach((nameKey, nameValue) -> System.out.println(nameKey + " "+nameValue));
        namesMap.entrySet().forEach(integerStringEntry -> System.out.println(integerStringEntry.getKey()));
    }
}
