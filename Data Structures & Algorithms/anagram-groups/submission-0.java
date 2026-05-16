class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) freq[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < freq.length; i++) {
                if (i > 0) sb.append('#'); 
                sb.append(freq[i]);
            }

            map.computeIfAbsent(String.valueOf(sb), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());

    }
}
