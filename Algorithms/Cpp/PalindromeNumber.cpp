#include <iostream>
#include <cstdio>
#include <vector>
#include <string>
#include <cstring>
#include <cmath>
#include <sstream>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int i;
        long mod = 10;
        long xx = x;
        for (i = 0; i < 11; i++) {
            if (xx / mod == 0) break;
            mod *= 10;
        }
        // cout << mod << endl;
        long low = 10, high = mod / 10, denom = 1;
        // cout << low << " " << high << endl;
        while (low <= high) {
            // cout << (xx/high)%10 << " " << (xx%low)/denom << endl;
            if ((xx/high)%10 != (xx%low)/denom) return false;
            low *= 10;
            high /= 10;
            denom *= 10;
        }
        return true;
    }
};


int main()
{
    Solution sol = Solution();
    cout << sol.isPalindrome(-1) << endl;
    cout << sol.isPalindrome(-1234) << endl;
    cout << sol.isPalindrome(1221) << endl;
    return 0;
}
