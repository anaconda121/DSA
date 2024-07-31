class TrieNode {
    TrieNode[] children;
    boolean wordEnd;

    TrieNode() {
        children = new TrieNode[26];
        wordEnd = false;
    }
}

class Trie {
    TrieNode root;

    Trie() { root = new TrieNode(); }

    void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) curr.children[childIdx] = new TrieNode();
            curr = curr.children[childIdx];
        }
        curr.wordEnd = true;
    }
}

class PrefixSuffixSearch {
    Trie prefT;
    HashMap<String, Integer> wordIdx;

    public WordFilter(String[] words) {
        prefT = new Trie();
        wordIdx = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordIdx.put(words[i], i);
            prefT.insert(words[i]);
        }
    }

    void findAllWords(TrieNode curr, String currentWord, HashSet<String> result) {
        if (curr.wordEnd) {
            result.add(currentWord);
        }
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                findAllWords(curr.children[i], currentWord + (char) (i + 'a'), result);
            }
        }
    }

    void search(String key, Trie t, HashSet<String> result, boolean isPref) {
        TrieNode currentNode = t.root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            currentNode = currentNode.children[index];
            if (currentNode == null) {
                return;
            }
        }
        findAllWords(currentNode, key, result);
    }

    public int f(String pref, String suff) {
        HashSet<String> matchingPref = new HashSet<>();

        search(pref, prefT, matchingPref, true);

        int ans = -1;
        for (String s : matchingPref) {
            if (s.endsWith(suff)) {
                ans = Math.max(ans, wordIdx.get(s));
            }
        }
        return ans;
    }
}
