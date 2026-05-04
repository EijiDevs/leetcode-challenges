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