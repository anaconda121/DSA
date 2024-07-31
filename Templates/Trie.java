import java.util.HashSet;

class Trie {

    class TrieNode {
        TrieNode[] children;
        boolean wordEnd;

        TrieNode() {
            children = new TrieNode[26];
            wordEnd = false;
        }
    }

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

    boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            curr = curr.children[index];
            if (curr == null) return false;
        }
        return true;
    }

    void findAllWords(TrieNode curr, String currentWord, HashSet<String> result) {
        if (curr.wordEnd) { result.add(currentWord); }
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                findAllWords(curr.children[i], currentWord + (char) (i + 'a'), result);
            }
        }
    }

    HashSet<String> wordsWithPrefix(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            curr = curr.children[index];
            if (curr == null) { return new HashSet<>(); }
        }
        HashSet<String> result = new HashSet<>();
        findAllWords(curr, prefix, result);
        return result;
    }
}