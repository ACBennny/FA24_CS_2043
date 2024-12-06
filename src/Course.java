import java.io.Serializable;
import java.util.List;

/*******************************************************************************
 * @author Group Members:
 *         Dawit Ashenafi Getachew 3752264,
 *         Chizaram Ikpo 3760059,
 *         Owen Yesuf 3755739,
 *         Chukwuemeka Anyanwu 3753658
 * @date 30-11-2024
 * 
 * Represents a course with a name and timeslots.
 * Provides methods to manage and retrieve course details.
 ******************************************************************************/


public class Course implements Serializable 
{
    private String name;
    private List<String> timeslots;

    public Course(String name, String timeslotString) 
    {
        this.name = name;
        this.timeslots = List.of(timeslotString.split(";"));
    }

    public String getName() 
    {
        return name;
    }

    public List<String> getTimeslots() 
    {
        return timeslots;
    }

    @Override
    public String toString() 
    {
        return name + " | " + String.join("; ", timeslots);
    }
}
