class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right){
            int num = numbers[left] + numbers[right];

            if (num > target){
                right--;

            } else if (num < target) {
                left++;

            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[]{};
    }
}
