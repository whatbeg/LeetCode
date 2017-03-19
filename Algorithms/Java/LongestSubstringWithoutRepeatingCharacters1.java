/**
 * Created by huqiu on 17-3-8.
 */
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int maxlen = 0, start = 0;
        for (int i = 0;i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mp.containsKey(ch)) {
                int t = mp.get(ch);
                start = Math.max(t+1, start);
            }
            maxlen = Math.max(maxlen, i-start+1);
            mp.put(ch, i);
        }
        System.out.println(maxlen);
        return maxlen;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.lengthOfLongestSubstring("abcabcbb");
        sol.lengthOfLongestSubstring("bbbbb");
        sol.lengthOfLongestSubstring("pwwkew");
        sol.lengthOfLongestSubstring("aab");
        sol.lengthOfLongestSubstring("");
    }
}