/**
 * Created by huqiu on 17-3-8.
 */
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new LinkedHashMap<Character, Integer>();
        int maxlen = 0, len = 0;
        LinkedList<Character> ll = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mp.containsKey(ch)) {
                maxlen = len > maxlen? len:maxlen;
                for (char t : mp.keySet()) {
                    //mp.remove(t);
                    ll.add(t);
                    len--;
                    if (t == ch)
                        break;
                }
                for (char t : ll) {
                    mp.remove(t);
                }
                ll.clear();
            }
            mp.put(ch, i);
            len++;
        }
        maxlen = len > maxlen? len:maxlen;
        //System.out.println(maxlen);
        return maxlen;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.lengthOfLongestSubstring("abcabcbb");
//        sol.lengthOfLongestSubstring("bbbbb");
//        sol.lengthOfLongestSubstring("pwwkew");
        sol.lengthOfLongestSubstring("aab");
    }
}