class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.nums = nums;

        dfs(0, new ArrayList<>(), 0);

        return result;
    }

    private void dfs (int i, List<Integer> current, int total){
        if (total == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if (total > target || i == nums.length){
            return;
        }

        current.add(nums[i]);
        dfs(i, current, total + nums[i]);

        current.removeLast();
        dfs(i + 1, current, total);
    }
}

