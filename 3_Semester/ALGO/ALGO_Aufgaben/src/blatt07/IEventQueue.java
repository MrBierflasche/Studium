package blatt07;

public interface IEventQueue {
	/** insert task into the queue */
	void addEvent(Event event);

	/**
	 * removes the event with the earliest time (lowest time value) from
	 * the queue and returns it
	 */
	Event removeNextEvent();

	/** checks whether the queue is empty */
	boolean isEmpty();

	/** checks whether the queue is full */
	boolean isFull();

}
