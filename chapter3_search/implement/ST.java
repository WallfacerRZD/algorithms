package chapter3_search.implement;

public interface ST<Key extends Comparable<Key>, Val> {
	void put(Key key, Val val);
	Val get(Key key);
	void delete(Key key);
	boolean contains(Key key);
	boolean isEmpty();
	int size();
}
