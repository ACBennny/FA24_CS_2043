import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Group
{
    // Declaration and Initialization
    private String groupName;
    private List<Course> courses;

    //Constructor
    public Group(String groupName)
    {
        this.groupName = groupName;
        this.courses = new ArrayList<>();
    }

    // Method to add course to group
    public void addCourse(Course course)
    {
        courses.add(course);
    }

    //Method to check for conflicts
    public void checkConflicts()
    {
        boolean conflictFound = false;
        for(int i = 0; i < courses.size(); i++)
        {
            for(int j = i+1; j < courses.size(); j++)
            {
                Course c1 = courses.get(i);
                Course c2 = courses.get(j);

                //check if they are on the same day
                if (c1.getDay().equals(c2.getDay()))
                {
                    String start1 = c1.getStartTime();
                    String end1 = c1.getEndTime();
                    String start2 = c2.getStartTime();
                    String end2 = c2.getEndTime();

                    // Logic to check time overlap
                    if(start1.compareTo(end2) < 0 && start2.compareTo(end1) < 0)
                    {
                        System.out.println("Conflic detected between courses:");
                        System.out.println(c1);
                        System.out.println(c2);
                        conflictFound = true;
                    }
                }
            }
        }

        if(!conflictFound)
        {
            System.out.println("No Conflict detected between courses:");
        }
    }

    //Method to display groupSchedule
    public void  displaySchedule()
    {
        System.out.println("Schedule for group: " + groupName);

        String[] dayCode = {"M", "T", "W", "TH", "F"};
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        //Sort courses by day
        for(int i = 0; i < dayCode.length; i++)
        {
            printCoursesForDay(dayCode[i], dayNames[i]);
        }
    }

    public void printCoursesForDay(String dayCode, String dayName)
    {
        System.out.println(dayName + ":");
        boolean hasCourses = false;

        for(Course course : courses)
        {
            if (course.getDay().equals(dayCode))
            {
                System.out.println(course);
                hasCourses = true;
            }
        }

        if (!hasCourses)
        {
            System.out.println("No course found for day: " + dayName);
        }
    }

}
