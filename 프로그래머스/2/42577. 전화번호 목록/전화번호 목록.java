import java.util.HashMap;

class TrieNode {
        
    String content;
    boolean isEndOfWord;
    HashMap<Character, TrieNode> children;

    TrieNode(String content){
        this.content = content;
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    boolean is_prefix;

    Trie(){
        root = new TrieNode("");
    }

    boolean insert(String word){
        is_prefix = false;
        root = insertRec(root, "", word);
        return is_prefix;
    }

    private TrieNode insertRec(TrieNode root, String accu, String rem) {


        if(rem.length() == 0) return root;

        char c = rem.charAt(0);


        if(rem.length() == 1 && root.children.containsKey(c)){
            is_prefix = true;
        }

        if(rem.length() >= 1 && root.isEndOfWord) {
            is_prefix = true;
        }

        if(!root.children.containsKey(c)){
            root.children.put(c, new TrieNode(accu+c));
        }

        if(rem.length() == 1) {
            root.children.get(c).isEndOfWord = true;
        }

        root.children.put(c, insertRec(root.children.get(c), accu+c, rem.substring(1, rem.length())));

        return root;
    }
}

class Solution {
    


    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Trie trie = new Trie();

        for(String p : phone_book) {
            
            boolean res = trie.insert(p);
            if(res) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    
}
