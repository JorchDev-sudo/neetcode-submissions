class Solution {
    public boolean isPalindrome(String s) {
        String string = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            char leftChar = string.charAt(left);
            char rightChar = string.charAt(right);
            
            if (leftChar != rightChar) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}
