package blatt07;

/**
 * Implementation of a priority queue for events with limited capacity as a
 * sorted array. The entries are sorted in descending order according to
 * time value.
 */
public class SortedEventQueue implements IEventQueue {
	/** array for stored events */
	private Event[] arr;

	/** current number of events in array arr */
	private int count = 0;

	/**
	 * creates a queue with the specified maximum capacity
	 * 
	 * @param maxSize Maximum number of entries that can be stored
	 */
	public SortedEventQueue(int maxSize) {
		arr = new Event[maxSize];
	}

	/**
	 * Inserts the event as new entry into the queue.
	 * 
	 * @precondition The queue is not full
	 */
	@Override
	public void addEvent(Event e) {
		int pos = count;
		while (pos > 0 && arr[pos - 1].getTime() < e.getTime()) {
			arr[pos] = arr[pos - 1];
			pos--;
		}
		arr[pos] = e;
		count++;
	}

	/**
	 * removes the event with minimal time value from the queue and returns it
	 */
	@Override
	public Event removeNextEvent() {
		Event minEintrag = arr[count - 1];
		arr[count - 1] = null;
		count--;
		return minEintrag;
	}

	/**
	 * checks whether the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	/**
	 * checks whether the queue is full
	 */
	@Override
	public boolean isFull() {
		return (count == arr.length);
	}

}
