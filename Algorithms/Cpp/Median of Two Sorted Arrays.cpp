#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        if (m == 0) return (nums2[(n - 1) / 2] + nums2[n - (n - 1) / 2 - 1]) / 2.0;
        int low = 0, high = m;
        int i = 0, j = 1;
        while (low <= high) {
            i = (low + high) / 2;
            j = (m + n + 1) / 2 - i;
            if ((i == 0 || j == n || nums1[i - 1] <= nums2[j]) && (j == 0 || i == m || nums2[j - 1] <= nums1[i]))
                break;
            else if (j > 0 && i < m && nums2[j - 1] > nums1[i])
                low = i + 1;
            else if (i > 0 && j < n && nums1[i - 1] > nums2[j])
                high = i - 1;
        }
        int max_left;
        if (i == 0) max_left = nums2[j - 1];
        else if (j == 0) max_left = nums1[i - 1];
        else max_left = max(nums1[i - 1], nums2[j - 1]);
        if ((m + n) % 2 == 1) {
            return max_left;
        } else {
            int min_right;
            if (i == m) min_right = nums2[j];
            else if (j == n) min_right = nums1[i];
            else min_right = min(nums1[i], nums2[j]);
            return (max_left + min_right) / 2.0;
        }
    }
};


int main()
{
    Solution sol = Solution();
    int n1[] = {1, 3};
    int n2[] = {2};
    vector<int> a(n1, n1+2);
    vector<int> b(n2, n2+1);
    cout << sol.findMedianSortedArrays(a, b) << endl;
    return 0;
}
