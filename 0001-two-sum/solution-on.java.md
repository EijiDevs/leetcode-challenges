# Intuition
The key insight is that for each number in the array, we already know exactly what its
complement must be (`target - nums[i]`). Instead of searching for it linearly on every
step (O(n²)), we can store all numbers in a HashMap for O(1) lookups.

# Approach
Two-pass HashMap:
1. **First pass:** build a `Map<Integer, List<Integer>>` storing each value → list of indices
   where it appears. Using a list handles duplicates (e.g. `[3, 3]` with target `6`).
2. **Second pass:** for each element compute `complement = target - nums[i]`, check if it
   exists in the map, and make sure we are not reusing the same index. To distinguish the
   duplicate case, if the complement list has only one index and it equals `i`, we skip it;
   otherwise we pick the other index.

# Complexity
- Time complexity: $$O(n)$$ - two independent linear passes over the array; each map
  operation (put / get / containsKey) is $$O(1)$$ amortized.

- Space complexity: $$O(n)$$ - the HashMap stores at most *n* entries (one per element).

# Code
```java []
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numero = nums[i];
            numsMap.putIfAbsent(numero, new ArrayList<>());
            numsMap.get(numero).add(i);
        }

        int sumA = 0;
        int sumB = 0;


        for (short i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (!numsMap.containsKey(complement)) continue;
            List<Integer> complementIndexes = numsMap.get(complement);
            if (complementIndexes.size() == 1 && complementIndexes.get(0) == i) continue;
              
            sumA = i;
            sumB = (complementIndexes.get(0) == i) ? complementIndexes.get(1) : complementIndexes.get(0);
        }
        
        return new int[]{sumA, sumB};
    }
}
```