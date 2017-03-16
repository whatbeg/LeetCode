#include <iostream>
#include <vector>
#include <cstdio>
#include <algorithm>
using namespace std;

int binarysearch(vector<int> nums, int target) {
    int low = 0, high = nums.size();
    while (low <= high) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    if (high < low) return -1;
}

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> vtmp;
        vtmp.insert(vtmp.end(), nums.begin(), nums.end());
        sort(nums.begin(), nums.end());
        int i = 0;
        for (i = 0;i < nums.size();i++) {
            int s = binarysearch(nums, target-nums[i]);
            if (s != i && s != -1) break;
        }
        vector<int> ans;
        for (int j = 0;j < vtmp.size();j++) {
            if (vtmp[j] == nums[i] || vtmp[j] == target-nums[i])
                ans.push_back(j);
        }
        return ans;
    }
};

int main()
{
    int arr[]={0,1,2,3,4,5};
    vector<int> nums(arr,arr+6);
    Solution s = Solution();
    s.twoSum(nums, 9);
    cout<<"Hello World"<<endl;
    return 0;
}
