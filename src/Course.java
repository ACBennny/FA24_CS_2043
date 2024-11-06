public class Course
{
    //Declaring and initializing Variables

    private String courseCode;
    private String description;
    private String instructor;
    private String startTime;
    private String endTime;
    private String day;

    //Constructor
    public Course(String courseCode, String description, String instructor, String day,  String startTime, String endTime)
    {
        this.courseCode = courseCode;
        this.description = description;
        this.instructor = instructor;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Getter Methods
    public String getDay()
    {
        return day;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public String getInstructor()
    {
        return instructor;
    }

    // to-String method
    @Override
    public String toString()
    {
        return courseCode + " " + description + " " + instructor + " " + day + " " + startTime + " " + endTime;
    }
}
