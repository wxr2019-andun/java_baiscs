package Arithmetic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:wuxinrui
 * Date:2019-09-10  18:23
 * Description:
 */

public class TestClass {
    public static int number(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            //char数组下标
            char alpha = s.charAt(end);
            //若出现重复数据 则Start（开始位）=当前下标
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            //最长子串距离
            ans = Math.max(ans, end - start + 1);
            System.out.println("ans: "+ans);
            //上传key值 和value值
            map.put(s.charAt(end), end + 1);
            System.out.println(map.toString());
            System.out.println("start: "+start+"  "+"end:  "+end);
        }
        return ans;
    }
    //public static int lengthOfLongestSubstring(String s) {
    //    int n = s.length();
    //    int ans = 0;
    //    for (int i = 0; i < n; i++)
    //        for (int j = i + 1; j <= n; j++)
    //            if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
    //    return ans;
    //}
    //
    //public static boolean allUnique(String s, int start, int end) {
    //    Set<Character> set = new HashSet<>();
    //    for (int i = start; i < end; i++) {
    //        Character ch = s.charAt(i);
    //        if (set.contains(ch)) return false;
    //        set.add(ch);
    //    }
    //    return true;
    //}
class TestClassTwo{
        private int[] x;
        private char[] y;
        private List<TestClassThree> list;

    }

    class TestClassTwos{
        private int[] x;
        private char[] y;
        private List<TestClassThree> list;

    }
    class  TestClassThree{
        private Integer pointer;
    }

    public static void main(String[] args) {
        //String s="asdasfasdasf";
        //String s1="sadjhgqbdishqw";
        //System.out.println(number(s1));

        //System.out.println(lengthOfLongestSubstring(s));
        //int x =10,y=20;
        //System.out.println(Math.max(x,y));
        //TestClassTwo two =  twos(TestClassTwos.class);

    }
}
