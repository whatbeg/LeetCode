/**
 * Created by huqiu on 17-9-19.
 */
import java.util.*;
import java.*;

public class Solution {
    String [] ten = {"I", "X", "C", "M"};
    String [] five = {"V", "L", "D"};
    public String subtrans(int num, int digits, int offset) {
        String s = "";
        if (num == 0) return s;
        if (digits == 1) {
            if (num == 9) return ten[digits - 1 + offset] + ten[digits + offset];
            else if (num >= 5) {
                s += five[digits - 1 + offset];
                for (int i = 0; i < num-5; i++) s += ten[digits - 1 + offset];
                return s;
            }
            else if (num == 4) return ten[digits - 1 + offset] + five[digits - 1 + offset];
            else {
                for (int i = 0; i < num; i++) s += ten[digits - 1 + offset];
                return s;
            }
        }
        else {
            for (int i = 0; i < digits - 1; i++) num /= 10;
            return subtrans(num, 1, digits - 1);
        }
    }
    public String intToRoman(int num) {
        String [] result = new String[5];
        int base = 1;
        int i = 0;
        while (num > 0) {
            int k = num % 10;
            result[i] = subtrans(k * base, i+1, i);
            base *= 10;
            i ++;
            num /= 10;
        }
        String res = "";
        for (int j = i-1; j >= 0; j--) {
            res += result[j];
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ca = sol.intToRoman(3999);
        System.out.println(ca);
    }
}