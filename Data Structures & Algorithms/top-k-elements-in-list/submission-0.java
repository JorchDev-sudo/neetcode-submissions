class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        int[] result = new int[k];

        for (int i : nums){
            seen.merge(i, 1, Integer::sum);
        }

        List<Integer> ordenedKeys = seen.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();

        for (int i = 0; i < k; i++){
            result[i] = ordenedKeys.get(i);
        }

        return result;
    }
}
