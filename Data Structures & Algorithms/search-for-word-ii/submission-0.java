class  Solution {
    static class Trie{
        Map<Character, Trie> references = new HashMap<>();
        boolean isEnd = false;
        String word;

        public void addWord (String word){
            Trie actual = this;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);

                actual.references.computeIfAbsent(c, t -> (new Trie()));
                actual = actual.references.get(c);

                if (i == word.length() - 1){
                    actual.isEnd = true;
                    actual.word = word;
                }
            }
        }
    }

    Trie trie = new Trie();
    Set<Integer> visited = new HashSet<>();
    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            trie.addWord(word);
        }

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                temp(trie, r, c, board);
            }
        }

        return new ArrayList<>(result);
    }

    private void temp (Trie trie, int row, int col, char[][] board){
        if (row >= board.length || row < 0) return;
        if (col >= board[0].length || col < 0) return;

        int position = row * board[0].length + col;

        if (visited.contains(position)) return;

        visited.add(position);

        char c = board[row][col];
        if (trie == null || !trie.references.containsKey(c)){
            visited.remove(position);
            return;
        }
        Trie actual = trie.references.get(c);

        if (actual.isEnd) {
            result.add(actual.word);
        }

        temp(actual, row + 1, col, board);
        temp(actual, row - 1, col, board);
        temp(actual, row, col + 1, board);
        temp(actual, row, col - 1, board);
        visited.remove(position);
    }
}