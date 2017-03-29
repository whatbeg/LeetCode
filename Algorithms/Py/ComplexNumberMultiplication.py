
class Solution(object):
    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        alis = a.split('+')
        alis[1] = alis[1][:-1]
        blis = b.split('+')
        blis[1] = blis[1][:-1]
        alis = map(int, alis)
        blis = map(int, blis)
        re = alis[0]*blis[0] - alis[1]*blis[1]
        im = alis[0]*blis[1] + alis[1]*blis[0]
        return "{}+{}i".format(re, im)

