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
    bool checkPerfectNumber(int num) {
        if (Facsum(num)-num == num) return true;
        return false;
    }
    int Facsum(int n)
    {
        int res = 1;
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                int cnt = 1;
                do
                {
                    n /= i;
                    cnt *= i;
                }while(n%i==0);
                res = res*(cnt*i-1)/(i-1);
            }
        }
        if(n > 1)
            res *= (n+1);
        return res;
    }
};


int main()
{
    Solution sol = Solution();
    cout << sol.checkPerfectNumber(28) << endl;
    cout << sol.checkPerfectNumber(2) << endl;
    return 0;
}
