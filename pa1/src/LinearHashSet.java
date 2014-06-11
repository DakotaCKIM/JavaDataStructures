/**
 * Created by Dakota Kim on 6/3/14.
 *
 * Some assistance was given by Eugene and Chao Duan.
 *
 * For some reason, this would print out a roughly 2,000 value, until I added verify = true;
 * Then it went up to around 30,000, which I figured is closer.
 *
 */

import java.util.*;
import java.lang.Math;

public class LinearHashSet<E> extends AbstractHashSet<E> {
	private final int stepSize = 4;
	private E[] hashArray;
	private int numSlots;

	public LinearHashSet(int numSlots) {
		hashArray = (E[]) (new Object[numSlots]);
		this.numSlots = numSlots;
	}

	public int size() {
		int size = 0;

		for (int i = 0; i < numSlots; i++) {
			if (hashArray[i] != null)
				size++;
		}
		return size;
	}

	public boolean remove(E e)
	{
		return false;
	}

	public E get(Object o)
	{
		return (E) o;
	}

	public boolean add(E e)
	{
		boolean verify = false;
		int hashSlot = Math.abs(e.hashCode() % numSlots);
		int hashNum = Math.abs(e.hashCode());
		int i = 0;
		while (hashArray[hashSlot] != null && i < numSlots) {
				collisions++;
				++i;
				hashSlot = (hashNum + (stepSize * i)) % numSlots;
				verify = true;
		}
		if (hashArray[hashSlot] == null) {
			hashArray[hashSlot] = e;
			verify = true;
		}
		return verify;
	}
}

