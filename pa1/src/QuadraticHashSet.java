import java.util.*;
import java.lang.Math;

/**
 * Created by Dakota Kim on 6/3/14
 *
 * This doesn't work exactly the way I want, but hey, it's here.
 */

public class QuadraticHashSet<E> extends AbstractHashSet<E> {
	private final int stepSize = 4;
	private final int x = 1000;
	private int count = 0;
	private int currentIndex = 0;
	private E[] quadArray;
	private int numSlots = 1000;

	public QuadraticHashSet(int numSlots)
	{
		quadArray = (E[]) new Object[numSlots];
	}

	public boolean add(E e)
	{
		int i = 1;
		boolean verify = false;
		int hashSlot = (Math.abs(e.hashCode()));
		while (quadArray[hashSlot] != null && i < numSlots) {
			collisions++;
			i++;
			hashSlot = (Math.abs(e.hashCode() + ((stepSize * i)*(stepSize * i)) % numSlots));
		}
		if (quadArray[hashSlot] == null) {
			quadArray[hashSlot] = e;
			verify = true;
		}
		return verify;
	}

	public boolean remove(E e)
	{
		return false;
	}

	public int size()
	{
		return count;
	}


	public int getCollisions()
	{
		return collisions;
	}

	public E get(Object o)
	{
		return (E)o;
	}

}
