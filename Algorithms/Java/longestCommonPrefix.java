/**
 * Created by huqiu on 17-9-19.
 */
import java.util.*;
import java.*;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minlength = (1 << 30);
        for (int i = 0; i < strs.length; i++) minlength = Math.min(minlength, strs[i].length());
        int c = 0, i, j;
        for (i = 0; i < minlength; i++) {
            for (j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i))
                    break;
            }
            if (j == strs.length) c++;
            else break;
            j = 0;
        }
        return strs[0].substring(0, c);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String [] strs = {"A"};
        String ca = sol.longestCommonPrefix(strs);
        System.out.println(ca);
    }
}