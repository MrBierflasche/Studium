package blatt07;

public class HeapEventQueue implements IEventQueue {
	private Event[] arr;
	private int size = 0;

	public HeapEventQueue(int capacity) {
		arr = new Event[capacity];
	}

	/**
	 * insert event into the queue
	 */
	@Override
	public void addEvent(Event msg) {
		if (this.size == arr.length) {
			throw new RuntimeException("Too many events");
		}

		int child = this.size++;
		arr[child] = msg; // hinten anfügen

		// aufsteigen lassen
		while (child > 0) { // bis zur Wurzel
			int parent = (child - 1) / 2;
			if (arr[parent].getTime() <= arr[child].getTime()) {
				break; // Elternknoten kleiner
			}
			Event tmp = arr[parent];
			arr[parent] = arr[child];
			arr[child] = tmp;
			child = parent;
		}
	}


	/**
	 * removes the event with the minimum time value from
	 * the queue and returns it
	 */
	@Override
	public Event removeNextEvent() {
		if (size == 0) {
			throw new RuntimeException("Queue is empty");
		}

		Event ret = arr[0];
		// letztes Element an die Wurzel = [0] setzen
		size--;
		arr[0] = arr[size];
		arr[size] = null; // Min-Event freigeben

		int k = 0;
		while (2 * k + 1 < size) {
			int kindLinks = 2 * k + 1;
			int kindRechts = kindLinks + 1;

			// Kind mit kleinerer Zeit bestimmen
			int minKind = kindLinks;
			if (kindRechts < size && arr[kindRechts].getTime() < arr[kindLinks].getTime()) {
				minKind = kindRechts;
			}

			// prüfen ob das Element weiter versenkt werden muss
			if (arr[k].getTime() > arr[minKind].getTime()) {
				Event tmp = arr[k];
				arr[k] = arr[minKind];
				arr[minKind] = tmp;
				k = minKind;
			} else {
				break; // Heap-Eigenschaft erfüllt
			}
		}

		return ret;
	}

	/** checks whether the event queue is empty */
	@Override
	public boolean isEmpty() {
        return size == 0;
    }

	/** checks whether the event queue is full */
	@Override
	public boolean isFull() {
		return size == arr.length;
	}

}
