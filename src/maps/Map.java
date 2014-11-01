package maps;

public class Map<K, V> {
	
	private int size = 0;;
	private Node<K, V> bucketArray[];
	
	public Map() {
		bucketArray = new Node[50];
	}
	
	private int hash(K key, int compression) {
		int keyHash = key.hashCode();
		return keyHash % compression;
	}
	
	private Node<K, V>[] rehashValues() {
		Node<K, V> newArray[] = new Node[2 * bucketArray.length];
		for (int i = 0; i < bucketArray.length; i++) {
			if (bucketArray[i] != null) {
				int newKeyHash = hash(bucketArray[i].key, newArray.length);
				newArray[newKeyHash] = bucketArray[i];
			}
		}
		return newArray;
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
	
	public void put (K key, V value) {
		size++;
		double threshholdFactor = ((double)size)/bucketArray.length;
		if (threshholdFactor >= 0.75) {
			bucketArray = rehashValues();
		}
		int keyHash = hash(key, bucketArray.length);
		Node<K, V> nodeToBeAdded = new Node<K, V>();
		nodeToBeAdded.key = key;
		nodeToBeAdded.value = value;
		if (bucketArray[keyHash] == null) {
			bucketArray[keyHash] = nodeToBeAdded;
		} else {
			nodeToBeAdded.next = bucketArray[keyHash];
			bucketArray[keyHash] = nodeToBeAdded;
		}
	}
	
	
	public boolean containsKey (K key) {
		int keyHash = hash(key, bucketArray.length);
		if (bucketArray[keyHash] != null) {
			Node<K, V> currentNode = bucketArray[keyHash];
			while (currentNode != null) {
				if (currentNode.key == key) {
					return true;
				}
				currentNode = currentNode.next;
			}
		}
		return false;
	}
	
	public void remove(K key) {
		if (!containsKey(key)) {
			return;
		}
		int keyHash = hash(key, bucketArray.length);
		Node<K, V> currentNode = bucketArray[keyHash];
		Node<K, V> previous = null;
		while (currentNode != null) {
			if (currentNode.key == key) {
				if (previous != null) {
					previous.next = currentNode.next;
				} else {
					bucketArray[keyHash] = currentNode.next;
				}
				return;
			}
			previous = currentNode;
			currentNode = currentNode.next;
			size--;
		}
	}
	
	public Object[] keys() {
		Object output[] = new Object[size()];
		int outputArrayIndex = 0;
		for (int i = 0; i < bucketArray.length; i++) {
			if (bucketArray[i] != null) {
				Node<K, V> currentNode = bucketArray[i];
				while (currentNode != null) {
					output[outputArrayIndex++] = currentNode.key;
					currentNode = currentNode.next;
				}
			}
		}
		return output;
	}
	
	public Object[] values() {
		Object output[] = new Object[size()];
		int outputArrayIndex = 0;
		for (int i = 0; i < bucketArray.length; i++) {
			if (bucketArray[i] != null) {
				Node<K, V> currentNode = bucketArray[i];
				while (currentNode != null) {
					output[outputArrayIndex++] = currentNode.value;
					currentNode = currentNode.next;
				}
			}
		}
		return output;
	}
}
