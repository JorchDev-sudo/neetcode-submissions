class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if (visited.containsKey(complement)){
                int[] result = new int[2];
                result[0] = visited.get(complement);
                result[1] = i;

                return result;
            }

            visited.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
