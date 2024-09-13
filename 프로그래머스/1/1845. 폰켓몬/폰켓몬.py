def solution(nums):
    s = set(nums)
    answer = min(len(s), len(nums)/2)
    return answer