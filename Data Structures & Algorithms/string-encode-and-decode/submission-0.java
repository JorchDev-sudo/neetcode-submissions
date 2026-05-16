class Solution {
    private HashMap<Integer, String> words = new HashMap<>();

    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < strs.size(); i++){
            String word = strs.get(i);

            words.put(i, word);
            string.append(word);
        }

        return string.toString();
    }

    public List<String> decode(String str) {
        return new ArrayList<>(words.values());
    }
}
