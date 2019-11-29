package ruins.demo;

/**
 * @author defang.yan
 * @date 19-10-30 下午4:14
 */


import java.util.Calendar;
import java.util.Scanner;

/**
 *  求某年2月份 天数
 */
public class GetDaysTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份:");
        int i = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(i,11,1);
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.get(Calendar.DATE));
    }
}
