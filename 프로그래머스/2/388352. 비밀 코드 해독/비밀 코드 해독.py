from itertools import combinations

def solution(n, q, ans):
    mb, result = [], []
    l = [i for i in range(1, n+1)]
    
    for i in combinations(l, 5):
        mb.append(i);
    
    for i in mb:
        if all(len(set(i).intersection(set(q[k]))) == ans[k] for k in range(len(q))):
            result.append(i)

    return len(result)
