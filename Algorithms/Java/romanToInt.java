/**
 * Created by huqiu on 17-9-19.
 */
import java.util.*;
import java.*;

public class Solution {
    String [] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    Integer [] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public int romanToInt(String s) {
        int len = integers.length;
        int res = 0, index = 0;
        int t;
        for (int i = 0; i < len; i++) {
            t = s.indexOf(roman[i], index);
            while( s.indexOf(roman[i], index) == index ) {
                res += integers[i];
                index += roman[i].length();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ca = sol.romanToInt("II");
        System.out.println(ca);
    }
}