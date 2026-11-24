package blatt07;

public class Event {
	/** description of event */
	private String description;
	
	/** planned starting time of event  */
	private int time;

	/** create event with description and start time */
	public Event(String description, int time) {
		this.description = description;
		this.time = time;
	}
	
	/** returns start time of event */
	public int getTime() {
		return time;
	}
	
	/** returns description of event */
	public String getDescription() {
		return description;
	}
	
	/** returns textual representation of event with start time and description */
	public String toString() {
		return "[" + time + "] " + description;
	}

}
