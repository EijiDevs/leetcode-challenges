class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sumA = 0;
        int sumB = 0;
        for (short i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            int firstOccurrence = findFirstOccurrence(nums, complement, i);
            if (firstOccurrence == -1) continue;

            sumA = i;
            sumB = firstOccurrence;
        }

        return new int[]{sumA, sumB};
    }

    private int findFirstOccurrence(int[] arr, int target, int excludedIndex) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target && i != excludedIndex) result = i;
        }
        return result;
    }
}