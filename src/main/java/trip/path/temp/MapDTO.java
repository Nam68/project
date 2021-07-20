package trip.path.temp;

public class MapDTO {
	
	private int start,end;
	private int distance,duration;
	
	public MapDTO() {
		// TODO Auto-generated constructor stub
	}
	public MapDTO(int start, int end, int distance, int duration) {
		super();
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.duration = duration;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
