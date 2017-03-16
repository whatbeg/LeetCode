/**
 * Created by huqiu on 17-3-8.
 */
import java.util.*;

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxi = 1;
        int tags = 0, tagt = 0;
        for (int i = 0; i < n; i++) {
            int left = extend(i, i, s);
            if ((i-left)*2+1 > maxi) {
                maxi = (i-left)*2+1;
                tags = left;
                tagt = left + maxi - 1;
            }
        }
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                int left = extend(i, i+1, s);
                if ((i-left)*2+2 > maxi) {
                    maxi = (i-left)*2+2;
                    tags = left;
                    tagt = left + maxi - 1;
                }
            }
        }
        System.out.println(s.substring(tags, tagt+1));
        return s.substring(tags, tagt+1);
    }
    public int extend(int center1, int center2, String s) {
        int j = center2;
        int n = s.length();
        int tags = center1;
        for (int i = center1; i >= 0 && j < n; i--, j++) {
            if (s.charAt(i) == s.charAt(j))
                tags = i;
            else break;
        }
        return tags;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindrome("babad");
        sol.longestPalindrome("cbbd");
        sol.longestPalindrome("abcda");
        sol.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        sol.longestPalindrome("a");
    }
}