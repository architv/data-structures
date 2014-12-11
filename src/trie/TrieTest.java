package trie;

public class TrieTest {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("hello");
		t.add("hell");
		t.add("he");
		t.add("haloween");
		System.out.println(t.size());
		System.out.println(t.search("hel"));
	}

}
