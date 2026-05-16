class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();

        int l = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            count.compute(s.charAt(r), (key, value) -> value == null ? 1 : value + 1);

            while ((r - l + 1) - count
                    .values()
                    .stream()
                    .max(Integer::compare)
                    .orElse(0) > k)
            {
                count.put(s.charAt(l),  count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
