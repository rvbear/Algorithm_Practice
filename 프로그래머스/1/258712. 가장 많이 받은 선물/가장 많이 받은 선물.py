def solution(friends, gifts):
    friend_arr = {v: i for i, v in enumerate(friends)}
    n = len(friends)
    degree = [0] * n
    answer = [0] * n
    graph = [[0] * n for i in range(n)]
    
    for gift in gifts:
        give, take = gift.split()
        graph[friend_arr[give]][friend_arr[take]] += 1
        
    for i in range(n):
        degree[i] = sum(graph[i]) - sum([g[i] for g in graph])
        
    for i in range(n):
        for j in range(n):
            if graph[i][j] > graph[j][i]:
                answer[i] += 1
            elif graph[i][j] == graph[j][i] and degree[i] > degree[j]:
                answer[i] += 1
    
    return max(answer)