class PrefixTree {
    public Map<Character, PrefixTree> childs = new HashMap<Character, PrefixTree>();

    Boolean isEnd = false;

    public PrefixTree(){
        this.childs.put(' ', new PrefixTree(false));
    }

    public PrefixTree(Boolean isEnd) {
        this.isEnd = isEnd;
    }

    public void insert(String word) {
        insertHelper(this.childs.get(' '), word);
    }

    public boolean search(String word) {
        if (childs.containsKey(' ')) {
            PrefixTree prefixTree = childs.get(' ');
            return searchHelper(prefixTree, word);
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        if (childs.containsKey(' ')) {
            PrefixTree prefixTree = childs.get(' ');
            return startsWithHelper(prefixTree, prefix);
        }

        return false;
    }

    public void insertHelper (PrefixTree pf, String word){
        if (word.isEmpty()) {
            pf.isEnd = true;
            return;
        }

        char c = word.charAt(0);

        if (!pf.childs.containsKey(c)) {
            pf.childs.put(c, new PrefixTree(false));
        }

        insertHelper(pf.childs.get(c), word.substring(1));
    }

    public boolean searchHelper(PrefixTree pf, String word){
        if (word.isEmpty() && !pf.isEnd) {
            return false;

        }else if (word.isEmpty()) {
            return true;
        }

        char c = word.charAt(0);

        if (!pf.childs.containsKey(c)) {
            return false;
        }

        PrefixTree node = pf.childs.get(c);
        return node.searchHelper(node, word.substring(1));
    }

    public boolean startsWithHelper(PrefixTree pf, String word){
        if (word.isEmpty()) {
            return true;
        }

        char c = word.charAt(0);

        if (!pf.childs.containsKey(c)) {
            return false;
        }

        PrefixTree node = pf.childs.get(c);
        return node.startsWithHelper(node, word.substring(1));
    }
}

