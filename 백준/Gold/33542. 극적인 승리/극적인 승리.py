import sys
input = sys.stdin.readline

A, B = map(int, input().split())
left_idx, right_idx = {}, {}
N = int(input())

for i in range(1, N + 1): 
    L, R = map(int, input().split())
    if L not in left_idx:
        left_idx[L] = [] 
    if R not in right_idx:
        right_idx[R] = []
    left_idx[L].append(i) # 만약 같은 값을 가진 과녁이 있을경우 처리 {value : index1,index2}
    right_idx[R].append(i)

target_left, target_right = list(left_idx.keys()), list(right_idx.keys())  

target_left.sort()
target_right.sort(reverse = True) # 둘 다 내림차순,오름차순 하는것 보다 각각 내림차순, 오름차순하는게 더 빠름

l, r = 0, 0  #과녁 인덱스 설정 
score, ans   = float("inf"), [-1, -1]
l_len, r_len = len(target_left), len(target_right) 

while l < l_len and r < r_len:
    s_dif = B + target_left[l] + target_right[r] # 점수 후보군 저장

    if A < s_dif : # 점수 후보군이 A보다 클경우
        if s_dif < score : # 점수 후보군이 score보다 작을경우
            x, y = -1, -1
            for i in left_idx[target_left[l]]:
                for j in right_idx[target_right[r]]:
                    if i != j: #인덱스가 같은경우 예외처리
                        x, y = i, j
                        break
            if x > 0:
                score = s_dif #최소값 갱신
                ans = [x, y] #최소값 인덱스 저장
        
        if r < r_len - 1: #최소값을 찾기 위해 내림차순한 r의 인덱스를 증가
            r += 1
        else: # r값중에 제일 작은 수 도달하면 l값 증가 시켜서 최소값 찾음
            l += 1
            
    else: # 점수 후보군이 A보다 작을 경우 
        l += 1 # 점수 후보군 < A 일 경우 l 증가 

for i in target_left[::-1]: # 왼손만 사용했을 경우가 양손을 사용해서 얻은 점수보다 최적값일 경우 처리
    if A < B + i:
        if B + i < score:
            score = B + i
            ans = [left_idx[i][0], -1]
    else:
        break

for i in target_right: # 오른른손만 사용했을 경우가 양손을 사용해서 얻은 점수보다 최적값일 경우 처리
    if A < B + i:
        if B + i < score:
            score = B + i
            ans = [-1, right_idx[i][0]]
    else:
        break

if A < B:
    print(-1, -1)
elif ans != [-1, -1]:
    print(*ans)
else:
    print('No')