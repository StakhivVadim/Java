//Собственный аналог HashSet
package CustomStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomHashSet<T> {
	
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	private ArrayList<T>[] buckets;
    private int size = 0;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	public CustomHashSet() {
		buckets = new ArrayList[DEFAULT_INITIAL_CAPACITY];
	}

	
	public boolean add(T value) {
	    int key = hash(value);
	    if (buckets[key] == null) {
	        buckets[key] = new ArrayList<>();
	    }
	    if (!buckets[key].contains(value)) {
	        buckets[key].add(value);
	        size++;	        
	        if (size >= buckets.length * DEFAULT_LOAD_FACTOR) {
                resize();
            }
	        return true;
	    }
	    return false;
	}
	
	public boolean remove(T value) {
	    int index = hash(value);
	    List<T> bucket = buckets[index];

	    if (bucket != null) {
	        Iterator<T> iterator = bucket.iterator();
	        while (iterator.hasNext()) {
	            T item = iterator.next();
	            if (item.equals(value)) {
	                iterator.remove();
	                size--;  
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	private void resize() {
        ArrayList<T>[] oldBuckets = buckets;
        buckets = new ArrayList[oldBuckets.length * 2];
        size = 0;

        for (ArrayList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T key : bucket) {
                    add(key);
                }
            }
        }
    }
	
	public boolean contains(T value) {
        int key = hash(value);
        return buckets[key] != null && buckets[key].contains(value);
    }
	
	private int hash(T value) {
	    int h;
	    h = (value == null) ? 0 : value.hashCode();
	    return (h ^ (h >>> 16)) & (buckets.length - 1);
	}
	
	public int size() {
        return size;
    }

}
