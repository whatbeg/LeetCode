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
    int myAtoi(string str) {
        long MAX_INT = 2147483647, MIN_INT = -2147483648;
        int flag = 1, Tag = 1;
        int i = 0;
        if (str == "") return 0;
        for (i = 0; i < str.length(); i++) {
            if (str[i] != ' ') break;
        }
        str = str.substr(i);
        if (str == "") return 0;
        for (i = str.length()-1; i >= 0; i--) {
            if (str[i] != ' ') break;
        }
        str = str.substr(0, i+1);
        if (str == "") return 0;
        for (i = 0; i < str.length(); i++) {
            if (str[i] == '+' || str[i] == '-') {
                for (int j = i+1; j < str.length(); j++) {
                    if (str[j] == '-' || str[j] == '+') return 0;
                }
            }
        }
        while (str != "" && (str[0] == '-' || str[0] == '+')) {
            if (str[0] == '-') {
                flag *= -1;
                str = str.substr(1);
            }
            if (str == "") return 0;
            if (str[0] == '+') {
                flag *= 1;
                str = str.substr(1);
            }
            if (str == "") return 0;
        }
        for (i = 0; i < str.length(); i++) {
            if (!(str[i] >= '0' && str[i] <= '9')) {
                Tag = 0;
                break;
            }
        }
        if (!Tag)
            str = str.substr(0, i);
        if (str == "") return 0;
        long mul = 1, tmp = 0;
        int overflow = 0;
        for (i = str.length()-1; i >= 0; i--) {
            tmp += mul * (str[i] - '0');
            mul *= 10;
            if (tmp*flag > MAX_INT) {
                overflow = 1;
                break;
            }
            else if (tmp*flag < MIN_INT) {
                overflow = 2;
                break;
            }
        }
        if (overflow == 1) return MAX_INT;
        if (overflow == 2) return MIN_INT;
        return (int)tmp*flag;
    }
};

int main()
{
    Solution sol = Solution();
    cout << sol.myAtoi("-123456789123453  ") << endl;
    cout << sol.myAtoi("-2334 ") << endl;
    cout << sol.myAtoi("-0012a32") << endl;
    cout << sol.myAtoi("    +++-1  ") << endl;
    return 0;
}
