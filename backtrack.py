import copy

result = []
def backtrack(nums):
    def permute():
        track = []
        _backtrack(track)
        return result
    
    def _backtrack(track):
        if len(track) == len(nums):
            result.append(copy.deepcopy(track))
            return
        
        for i in range(len(nums)):
            if nums[i] in track:
                continue
            track.append(nums[i])
            _backtrack(track)
            track.pop()
    return permute

b = backtrack([1,2,3])
print(b())