import java.sql.Time;

public class Timetable
{
	private String timetableID;
	private Time startTime;
	private Time endTime;
	private String day;
	public Timetable(String timetableID, Time startTime, Time endTime, String day)
	{
		
		this.timetableID = timetableID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}
	public String getTimetableID()
	{
		return timetableID;
	}
	public Time getStartTime()
	{
		return startTime;
	}
	public Time getEndTime()
	{
		return endTime;
	}
	public String getDay()
	{
		return day;
	}
	
	
}
