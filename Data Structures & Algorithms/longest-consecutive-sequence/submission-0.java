class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int count = 0;
        for (int i : nums){
            int tempCount = recursive(numSet, i, 0);

            if (tempCount > count){
                count = tempCount;
            }
        }

        return count;
    }

    public static int recursive (Set<Integer> nums, int num, int count){
        if (nums.contains(num)){
            return recursive(nums, num - 1, count + 1);
        }

        return count;
    }
}
