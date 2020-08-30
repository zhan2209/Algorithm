class AutocompleteSystem {

    class TrieNode implements Comparable<TrieNode> {

        final int R = 27;

        TrieNode[] links;

        String word = "";

        int count;

        TrieNode() {
            links = new TrieNode[R];
        }

        TrieNode get(char ch) {
            return ch == ' ' ? links[26] : links[ch - 'a'];
        }

        void set(char ch, TrieNode node) {
            int index = ch == ' ' ? 26 : ch - 'a';
            links[index] = node;
        }

        boolean containsKey(char ch) {
            int index = ch == ' ' ? 26 : ch - 'a';
            return links[index] != null;
        }

        @Override
        public int compareTo(TrieNode o) {
            return count != o.count ? Integer.compare(count, o.count) : o.word.compareTo(word);
        }
    }

    class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (!node.containsKey(c)) {
                    node.set(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.word = word;
            node.count++;
        }

        void insert(String word, int cnt) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (!node.containsKey(c)) {
                    node.set(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.word = word;
            node.count += cnt;
        }

        private List<String> startWith(String prefix) {
            TrieNode node = root;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                if (!node.containsKey(c)) return new ArrayList<>();
                node = node.get(c);
            }
            return topK(node);
        }

        private List<String> topK(TrieNode root) {
            LinkedList<String> ans = new LinkedList<>();
            PriorityQueue<TrieNode> queue = new PriorityQueue<>();
            dfs(root, queue);
            while (!queue.isEmpty()) {
                ans.addFirst(queue.poll().word);
            }
            return ans;
        }

        private void dfs(TrieNode node, PriorityQueue<TrieNode> queue) {
            if (node == null) return;
            if (node.word.length() > 0) {
                if (queue.size() < 3) {
                    queue.offer(node);
                } else if (node.compareTo(queue.peek()) > 0) {
                    queue.poll();
                    queue.offer(node);
                }
            }
            for (TrieNode link : node.links) {
                dfs(link, queue);
            }
        }
    }

    private Trie trie;

    private String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            trie.insert(prefix);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        return trie.startWith(prefix);
    }
}


/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */