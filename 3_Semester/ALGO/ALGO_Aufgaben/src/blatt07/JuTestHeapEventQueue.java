package blatt07;


//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Random;


public class JuTestHeapEventQueue {

	private IEventQueue prioQueue;
	public static int CAPACITY = 100;

	@BeforeEach
	public void setup() {
		prioQueue = new HeapEventQueue(CAPACITY);
	}
	
	@Test
	public void test01EmptyFull() {
		// at the beginning, queue is empty
		assertTrue(prioQueue.isEmpty());

		// insert entry ==> queue is not empty
		prioQueue.addEvent(new Event("Xaver", 4));
		assertFalse(prioQueue.isEmpty());

		// insert another entry
		prioQueue.addEvent(new Event("Yvonne", 3));
		assertFalse(prioQueue.isEmpty());
		
		// extract an entry ==> not empty
		prioQueue.removeNextEvent();
		assertFalse(prioQueue.isEmpty());
		
		// extract another entry ==> now empty
		prioQueue.removeNextEvent();
		assertTrue(prioQueue.isEmpty());
	}

	
	@Test
	public void test02insertExtractMin() {
		Event e1a = new Event("E1a", 1);
		Event e1b = new Event("E1b", 1);
		Event e2a = new Event("E2a", 2);
		Event e2b = new Event("E2b", 2);
		Event e3 = new Event("E3", 3);
		Event e4 = new Event("E4", 4);
		Event e5 = new Event("E5", 5);
		Event e6 = new Event("E6", 6);
		
		//insert some entries
		prioQueue.addEvent(e3);
		prioQueue.addEvent(e2a);
		prioQueue.addEvent(e5);
		prioQueue.addEvent(e1a);
		prioQueue.addEvent(e2b);
		
		//contents now: {E1a, E2a, E2b,E3, E5}
		
		//extract minimum: extracted element should have prio 1
		Event emin = prioQueue.removeNextEvent();
		assertEquals(1, emin.getTime());
		assertEquals("E1a", emin.getDescription());
		
		//contents now: {E2a, E2b,E3, E5}
		
		//extract minimum: extracted element should have prio 2
		emin = prioQueue.removeNextEvent();
		assertEquals(2, emin.getTime());
				
		//contents now: {E2b,E3, E5} (or E2a instead of E2b)
		
		// insert two entries
		prioQueue.addEvent(e4);
		prioQueue.addEvent(e1b);
		
		//contents now: {E1b, E2b, E3, E4, E5}
		
		//extract minimum ==> prio 1 expected
		emin = prioQueue.removeNextEvent();
		assertEquals(1, emin.getTime());
		
		//extract minimum ==> prio 2 expected
		emin = prioQueue.removeNextEvent();
		assertEquals(2, emin.getTime());
		
		//extract minimum ==> prio 3 expected
		emin = prioQueue.removeNextEvent();
		assertEquals(3, emin.getTime());
		
		//contents now: {E4, E5}
		
		//insert another value
		prioQueue.addEvent(e6);

		//contents now: {E4, E5, E6}

		//extract minimum ==> prio 4 expected
		emin = prioQueue.removeNextEvent();
		assertEquals(4, emin.getTime());

		//extract minimum ==> prio 4 expected
		emin = prioQueue.removeNextEvent();
		assertEquals(5, emin.getTime());

		//extract minimum ==> prio 6 expected
		emin = prioQueue.removeNextEvent();
		assertEquals(6, emin.getTime());

		// queue should be empty now
		assertTrue(prioQueue.isEmpty());	
	}
	
	
	@Test
	public void test03Random() {
		// fill queue completely with random entries
		for (int i = 0; i < CAPACITY; i++) {
			Event neu = randomTask(1000);
			prioQueue.addEvent(neu);
		}		
	
		assertTrue(prioQueue.isFull());
		
		// extract all entries ==> should be sorted 
		Event current = prioQueue.removeNextEvent();
		Event previous;
		int count = 1;
		while (! prioQueue.isEmpty()) {
			previous = current;
			Event next = prioQueue.removeNextEvent();
			assertTrue(next.getTime() >= previous.getTime());
			count++;
		}
		// check that all entries have been removed
		assertEquals(CAPACITY, count);
	}
	
	@Test
	public void test04() {
		
		// insert 10 tasks with priorities 1, 3, 5, ..., 19
		for (int i = 1; i <= 20; i += 2) {
			Event entry = new Event("T" + i, i);
			prioQueue.addEvent(entry);
		}
		
		// insert 10 tasks with priorities 20, 18, ..., 4, 2
		for (int i = 20; i > 0; i -= 2) {
			Event entry = new Event("T" + i, i);
			prioQueue.addEvent(entry);
		}
		
		// remove next 20 tasks from the queue
		// should return the sequence W1, W2, ..., W20
		for (int k = 1; k <= 20; k++) {
			Event entry = prioQueue.removeNextEvent();
			assertTrue(entry.getTime() == k);
			assertTrue(entry.getDescription().equals("T"+k));
		}
		
		// queue should be empty now
		assertTrue(prioQueue.isEmpty());
	}
	
	

	public static Random rand = new Random();
	
	/** generate a random entry
	 * 
	 * @param maxValue upper bound for value and priority
	 * @return	entry with random priority and value
	 */
	public static Event randomTask(int maxValue) {
		int prio = rand.nextInt(maxValue); 
		return new Event("Task_"+prio, prio);
	}
	
}
