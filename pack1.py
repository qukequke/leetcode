def pack1(w, v, C):
    dp = [[0 for _ in range(C+1)] for _ in range(len(w)+1)]
    for i in range(1, len(w)+1):
        for j in range(1, C+1):
            if j < w[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i-1]]+ v[i-1])
#     print(dp)
    for i in dp:
        print(i)
pack1([2,2,6,5,4], [6,3,5,4,6], 10)
print('')
pack1([2,3,4,5], [3,4,5,6], 8)