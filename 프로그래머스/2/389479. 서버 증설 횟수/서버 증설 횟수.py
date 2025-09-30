def solution(players, m, k):
    server = [0] * 24
    answer = 0
    
    for i in range(0, 24):
        need_server = (players[i] - m) // m + 1 if players[i] >= m else 0
        server_count = 0
        
        for j in range(max(0, i - k + 1), i):
            server_count += server[j]
        
        server[i] = max(0, need_server - server_count)
        answer += server[i]
    
    return answer