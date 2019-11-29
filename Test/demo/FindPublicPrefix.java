package ruins.demo;

import java.util.Arrays;

/**
 * @author defang.yan
 * @date 19-11-1 下午3:41
 */

/*
 * 查找出  [cba,cbafhas,cbghk] 公共前缀
 */
public class FindPublicPrefix {
    public static void main(String[] args) {
        String[] string11 = {"cba","cbhasf","cbghk"};
        System.out.println("11111");
        System.out.println(new FindPublicPrefix().findPublicPrefix(string11));
    }

    public String findPublicPrefix(String[] strings ){
        if(!checkArgs(strings)){
            return "未找到";
        }
        int length = strings.length;
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(strings);
        System.out.println("开始:"+strings.toString());
        int firstLength = strings[0].length();//排序后第一个数的长度
        int lastLength = strings[length - 1].length();
        int min = Math.min(firstLength, lastLength);
        for (int i = 0; i<min ; i++){
            if (strings[0].charAt(i) == strings[length-1].charAt(i)){
                stringBuilder.append(strings[0].charAt(i));
            }
            else{
                break;
            }
        }


    return stringBuilder.toString();

    }
    public static Boolean checkArgs(String[] strings){
        boolean flag = false;

        if (strings != null){
            for (int i = 0 ; i < strings.length ; i++){
                if (strings[i].length() != 0 && strings[i] != null){
                    flag = true;
                }

            }
        }
        return flag;
    }
}
