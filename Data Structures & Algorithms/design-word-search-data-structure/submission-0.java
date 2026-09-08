class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {

        // Llegamos al final de la palabra buscada
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // Caso normal: letra específica
        if (c != '.') {
            int childIndex = c - 'a';

            TrieNode child = node.children[childIndex];

            if (child == null) {
                return false;
            }

            return searchHelper(child, word, index + 1);
        }

        // Caso '.': puede ser cualquier letra
        for (TrieNode child : node.children) {

            if (child != null && searchHelper(child, word, index + 1)) {
                return true;
            }
        }

        return false;
    }
}

