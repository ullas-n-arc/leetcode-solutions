from math import inf
class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        # res = inf
        d = {}

        def solve(tar):

            res = inf

            if tar in d:
                return d[tar]

            if tar == 0:
                return 0
            if tar < 0:
                return inf
            for ele in coins:
                if ele <= tar:
                    res = min(res, 1 + solve(tar-ele))
                # else:
                #     res=min(res,solve(tar))
            d[tar] = res
            return res

        res =  solve(amount)
        if res == inf: return -1
        return res 
