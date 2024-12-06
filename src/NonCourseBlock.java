import java.io.Serializable;

/***************************************************************************************************
 * @author Group Members:
 *         Dawit Ashenafi Getachew 3752264,
 *         Chizaram Ikpo 3760059,
 *         Owen Yesuf 3755739,
 *         Chukwuemeka Anyanwu 3753658
 * @date 30-11-2024
 * 
 * Represents a non-course block (e.g., seminar or workshop) with a name and timeslot.
 * Provides methods to manage and retrieve non-course block details.
 ***************************************************************************************************/

public class NonCourseBlock implements Serializable 
{
    private String name;
    private String timeslot;

    public NonCourseBlock(String name, String timeslot) 
    {
        this.name = name;
        this.timeslot = timeslot;
    }

    public String getName() 
    {
        return name;
    }

    public String getTimeslot() 
    {
        return timeslot;
    }

    @Override
    public String toString() 
    {
        return name + " | " + timeslot;
    }
}
