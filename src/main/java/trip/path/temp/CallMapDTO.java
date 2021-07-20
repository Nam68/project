package trip.path.temp;

public class CallMapDTO {
	
	private int start,end;
	private double duration;
	
	public CallMapDTO() {
		// TODO Auto-generated constructor stub
	}

	public CallMapDTO(int start, int end, double duration) {
		super();
		this.start = start;
		this.end = end;
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

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
}
