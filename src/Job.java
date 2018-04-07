
public class Job
{

	private String jobID;
	private String title;
	private String type;
	public Job(String jobID, String title, String type)
	{
		super();
		this.jobID = jobID;
		this.title = title;
		this.type = type;
	}
	public String getJobID()
	{
		return jobID;
	}
	public String getTitle()
	{
		return title;
	}
	public String getType()
	{
		return type;
	}
	
	
}
