class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int result = 0;
        while (left < right){
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            int maxWater = (right - left) * Math.min(leftHeight, rightHeight);

            result = Math.max(result, maxWater);

            if (leftHeight < rightHeight){
                left++;

            }else if (leftHeight > rightHeight){
                right--;

            }else {
                right--;
                left++;
            }
        }

        return result;
    }
}
