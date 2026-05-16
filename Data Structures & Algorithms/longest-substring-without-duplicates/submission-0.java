class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        int maxCount = 0;
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))) {
                int temp = map.size();
                if (temp > maxCount){
                    maxCount = temp;
                }
                
                int prevIndex = map.get(s.charAt(i));
                for (int j = left; j <= prevIndex; j++) {
                    map.remove(s.charAt(j));
                }
                left = prevIndex + 1;
                map.put(s.charAt(i), i);
            }else{
                map.put(s.charAt(i), i);
            }
        }

        return Math.max(maxCount, map.size());
    }
}
