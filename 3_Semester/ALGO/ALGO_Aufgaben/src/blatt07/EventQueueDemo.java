package blatt07;

import java.util.Random;


/** Shows usage of priority queue for events */
public class EventQueueDemo {

	public static void main(String[] args) {
		IEventQueue taskQueue = new HeapEventQueue(20);
//		IEventQueue taskQueue = new SortedEventQueue(20);
		
		taskQueue.addEvent(new Event("action A", 5));
		taskQueue.addEvent(new Event("action B", 2));
		taskQueue.addEvent(new Event("action C", 9));
		taskQueue.addEvent(new Event("action D", 1));
		taskQueue.addEvent(new Event("action E", 8));
		taskQueue.addEvent(new Event("action F", 3));
		taskQueue.addEvent(new Event("action G", 6));

		System.out.println(taskQueue.removeNextEvent());
		
		taskQueue.addEvent(new Event("action H", 4));
		taskQueue.addEvent(new Event("action I", 10));
		taskQueue.addEvent(new Event("action J", 1));
		taskQueue.addEvent(new Event("action K", 7));
		
		System.out.println("---");
		while (! taskQueue.isEmpty()) {
			System.out.println(taskQueue.removeNextEvent());
		}
		
		System.out.println("- done -");	
	}
	
/* expected output:
event [1] action D
---
event [1] action J
event [2] action B
event [3] action F
event [4] action H
event [5] action A
event [6] action G
event [7] action K
event [8] action E
event [9] action C
event [10] action I
- done -
*/
	
}
