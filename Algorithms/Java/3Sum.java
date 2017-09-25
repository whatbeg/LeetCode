/**
 * Created by huqiu on 17-9-19.
 */
import java.util.*;
import java.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        count.clear();
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                c = count.get(nums[i]);
                count.replace(nums[i], c + 1);
            }
            else count.put(nums[i], 1);
        }
        List<Integer> keys = new ArrayList<>();
        keys.addAll(count.keySet());
        if (count.containsKey(0) && count.get(0) >= 3)
            result.add(Arrays.asList(0, 0, 0));
        for (int i = 0; i < keys.size(); i++) {
            for (int j = i+1; j < keys.size(); j++) {
                int a = keys.get(i);
                int b = keys.get(j);
                if ((a!=(-a-b) && b!=(-a-b) && count.containsKey(-a-b)) ||
                        (a==(-a-b) && b==(-a-b) && count.get(-a-b) >= 3) ||
                        (a==(-a-b) && b!=(-a-b) && count.get(-a-b) >= 2) ||
                        (a!=(-a-b) && b==(-a-b) && count.get(-a-b) >= 2)) {
                    List<Integer> sa = Arrays.asList(a, b, -a-b);
                    Collections.sort(sa);
                    result.add(sa);
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] strs = {0, 0, 0};
        List<List<Integer>> ca = sol.threeSum(strs);
        System.out.println(ca);
    }
}