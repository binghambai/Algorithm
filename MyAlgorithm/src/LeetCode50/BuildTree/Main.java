package LeetCode50.BuildTree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Map<Integer, Integer> map = new HashMap<Integer, Integer>(){
        {
            put(1, 31);
            put(3, 31);
            put(5, 31);
            put(7, 31);
            put(8, 31);
            put(10, 31);
            put(12, 31);
        }
    };
    public enum Test{
        A,B,C;
    }
    public static void main(String[] args) {
        String[] strings = new String[]{"test1, test2, test3"};
        System.out.println(Arrays.asList(Test.values()).subList(0, 3));
    }
    public static String t(String date) {
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        String year = date.substring(0, 4);
        String hourAndMinute = date.substring(8);
        if (month == 12 && (day + 1) >31) {
            return (Integer.parseInt(year) + 1) + "0101" + hourAndMinute;
        } else if ((map.containsKey(month) && ((day + 1) > 31))
                || ((!map.containsKey(month))&&((day + 1) > 30))
                || (month == 2 && Integer.parseInt(year)%4 == 0 && (day + 1) > 29)
                || (month == 2 && Integer.parseInt(year)%4 != 0 && (day + 1) > 28)) {
            return year + "0" + (month + 1) + "01"+ hourAndMinute;
        }
        return year  + "0" + month + (day + 1) + hourAndMinute;

    }

    public static int test(String s) {
        if (s == null || s.length() <= 0) return 0;
        int fast = 0, low = 0, maxLength = 0;
        int len = s.length();
        char [] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(;fast< len; fast++) {
            if (!map.containsKey(chars[fast])) {
                map.put(chars[fast], fast);
                maxLength = Math.max(maxLength, fast - low + 1);
            } else {
                while(map.containsKey(chars[fast])) {
                    map.remove(chars[low]);
                    low++;
                }
                fast--;
                maxLength = Math.max(maxLength, fast - low + 1);
            }
        }
        return maxLength;
    }
}
