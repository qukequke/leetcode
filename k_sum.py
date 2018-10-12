def k_sum(nums, i, s):
	if s == 0:
		return True
	elif i == 0:
		return nums[i] == s
	elif nums[i] > s:
		return k_sum(nums, i-1, s)
	else:
		return k_sum(nums, i-1, s) or k_sum(nums, i-1, s-nums[i])
print(k_sum([3,34,4,12,5,2], 5, 10))
print(k_sum([3,34,4,12,5,2], 5, 11))
print(k_sum([3,34,4,12,5,2], 5, 12))
print(k_sum([3,34,4,12,5,2], 5, 13))
# print(k_sum([4,34,4,12,5,2], 5, 26))
# print(k_sum([4,34,4,12,5,2], 5, 26))
