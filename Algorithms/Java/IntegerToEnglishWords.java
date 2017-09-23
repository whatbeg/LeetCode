/**
 * Created by huqiu on 17-9-19.
 */
import java.util.*;
import java.*;

public class Solution {
    String [] digit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String [] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String digit3toWords(int num) {
        String res = "";
        if (num / 100 > 0) {
            res += digit[num / 100 - 1] + " Hundred";
        }
        int mod = num % 100;
        if (mod > 0 && mod < 20) {
            res += " " + digit[mod - 1];
        }
        else if (mod >= 20) {
            res += " " + tens[mod / 10 - 1] + (mod % 10 == 0 ? "" : " " + digit[mod % 10 - 1]);
        }
        return res;
    }
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String ans [] = new String[5];
        String [] prefix = {"", " Thousand ", " Million ", " Billion "};
        int i = 0, c = 0;
        while (num > 0) {
            if (num % 1000 > 0)
                ans[i++] = digit3toWords(num % 1000) + prefix[c];
            num /= 1000;
            c++;
        }
        StringBuilder res = new StringBuilder();
        for (int j = i-1; j >= 0; j--) {
            res.append(ans[j]);
        }
        String result = res.toString();
        int len = result.length();
        if (result.charAt(0) == ' ' && result.charAt(len-1) == ' ') {
            result = result.substring(1, len-1);
        }
        else if (result.charAt(0) == ' ') {
            result = result.substring(1);
        }
        else if (result.charAt(len-1) == ' ') {
            result = result.substring(0, len-1);
        }
        return result.replace("  ", " ");
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ca = sol.numberToWords(1000001);
        System.out.println(ca);
        String s = "A  B c".replace("  ", " ");
        System.out.println(s);
    }
}