class PrefixTree {

    private final Map<Character, PrefixTree> children = new HashMap<>();
    private boolean isEnd;

    public PrefixTree() {
    }

    public void insert(String word) {
        PrefixTree current = this;

        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new PrefixTree());
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree current = this;

        for (char c : word.toCharArray()) {
            current = current.children.get(c);

            if (current == null) {
                return false;
            }
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree current = this;

        for (char c : prefix.toCharArray()) {
            current = current.children.get(c);

            if (current == null) {
                return false;
            }
        }

        return true;
    }
}
