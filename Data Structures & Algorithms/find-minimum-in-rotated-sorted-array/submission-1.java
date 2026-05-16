class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int result = nums[(low + high) / 2];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < nums[high]) {
                high = mid;

            }else if (nums[mid] >= nums[high]) {
                low = mid + 1;
            }

            if (nums[mid] < result)result = nums[mid];
        }

        return result;
    }
}
