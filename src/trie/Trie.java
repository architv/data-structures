package trie;

public class Trie {
	
	private TrieNode root;
	private int size;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	public void add(String word) {
		
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			int postition = word.charAt(i) - 'a';
			
			if (current.children[postition] == null) {
				// make a new trienode and insert it at the position
				TrieNode newNode = new TrieNode();
				current.children[postition] = newNode;
				current = newNode;
			}
			
			else {
				current = current.children[postition];
			}
		}
		current.isTerminal = true;
		size++;
	}
	
	public boolean search(String query) {
		
		TrieNode current = root;
		for (int i = 0; i < query.length(); i++) {
			int postition = query.charAt(i) - 'a';
			
			if (current.children[postition] == null) {
				return false;
			}
			
			current = current.children[postition];
		}
		return current.isTerminal;
	}
	
}
