#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (s == "") return "";
        if (numRows == 1) return s;
        string res = "";
        int len = s.length();
        int n = numRows;
        for (int i = 1; i <= len; i+=2*n-2)
            res += s[i-1];
        int x = 4;
        for (int row = 2; row < n; row++) {
            if (row <= len)
                res += s[row-1];
            int y = row;
            for (int j = 1; ; j++) {
                if (y+(2*n-x) <= len)
                    res += s[y+(2*n-x)-1];
                if (y+(2*n-2) <= len)
                    res += s[y+(2*n-2)-1];
                else break;
                y += 2*n-2;
            }
            x += 2;
        }
        for (int i = n; i <= len; i+=2*n-2)
            res += s[i-1];
        return res;
    }
};


int main()
{
    Solution sol = Solution();
    string s = "";
    // cout << sol.convert("PAYPALISHIRING", 3) << endl;
    cout << sol.convert("A", 1) << endl;
    cout << sol.convert("AB", 1) << endl;
    return 0;
}
