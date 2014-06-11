/**
 * Created by Dakota Kim on 6/6/14.
 *
 * Some assistance was given by Eugene and Chao Duan.
 */
import java.lang.*;
import java.util.*;

public class ChainingHashSet<E> extends AbstractHashSet<E> {
	private final int x = 1000;
	private int numSlots;
	private ArrayList<LinkedList<E>> chainSet;


	public ChainingHashSet(int numSlots)
	{
		collisions = 0;
		chainSet = new ArrayList<LinkedList<E>>(numSlots);
		this.numSlots = numSlots;
	}

	public int size() {
		int size = 0;

		for (int i = 0; i < numSlots; i++) {
			if (!chainSet.get(i).get(i).equals(null))
				size++;
		}
			return size;
	}

	public boolean add(E e) {

		boolean verify = false;
		int hashSlot = Math.abs(e.hashCode()) % numSlots;

		LinkedList<E> hashSpot = chainSet.get(hashSlot);
		if (chainSet.get(hashSlot).equals(null))
		{
			chainSet.get(hashSlot).add(e);
			verify = true;
		}
		else if (!chainSet.get(hashSlot).equals(null))
		{
			collisions += hashSpot.size();
			hashSpot.add(e);
		}
		return verify;
	}


	public boolean remove(E e)
	{
		return false; // Not actually implementing it. Sorry. :)
	}

	public E get(Object o)
	{
		return (E)o; // Not actually implementing it. Sorry. :)
	}

	public int getCollisions()
	{
		return collisions;
	}

}
