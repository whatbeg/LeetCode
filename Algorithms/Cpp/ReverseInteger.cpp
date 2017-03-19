#include <iostream>
#include <cstdio>
#include <vector>
#include <string>
#include <cstring>
#include <sstream>
#include <algorithm>
using namespace std;

class Solution {
public:
    int reverse(int x) {
        if (x == 0) return 0;
        string num;
        stringstream ss;
        ss << x;
        ss >> num;
        int flag = 1;
        if (num[0] == '-') {
            flag = -1;
            num = num.substr(1);
        }
        std::reverse(num.begin(), num.end());
        for (int i = 0; i < num.length(); i++) {
            if (num[i] != '0') {
                num = num.substr(i);
                break;
            }
        }
        // cout << num << endl;
        if (num.size() > 10) return 0;
        if (num.size() == 10 && ((!flag && num > "2147483647") || (flag && num > "2147483648"))) return 0;
        std::stringstream out(num);
        out >> x;
        return x * flag;
    }
};

int main()
{
    Solution sol = Solution();
    cout << sol.reverse(-123) << endl;
    cout << sol.reverse(1230) << endl;
    cout << sol.reverse(1234567897) << endl;
    return 0;
}
