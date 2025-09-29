def solution(n, w, num):
    num_col = (num - 1) % w
    left, right = divmod(n - num, 2 * w)
    return 1 + 2 * left + (1 if right >= 2 * (w - 1 - num_col) + 1 else 0)