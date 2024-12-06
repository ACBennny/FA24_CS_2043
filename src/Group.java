import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*****************************************************************************************
 * @author Group Members:
 *         Dawit Ashenafi Getachew 3752264,
 *         Chizaram Ikpo 3760059,
 *         Owen Yesuf 3755739,
 *         Chukwuemeka Anyanwu 3753658
 * @date 30-11-2024
 * 
 * Represents a group of courses and non-course blocks.
 * Provides methods to manage the group, add items, and display schedules.
 *****************************************************************************************/

public class Group implements Serializable 
{
    private String groupName;
    private List<Course> courses;
    private List<NonCourseBlock> nonCourseBlocks;

    public Group(String groupName) 
    {
        this.groupName = groupName;
        this.courses = new ArrayList<>();
        this.nonCourseBlocks = new ArrayList<>();
    }

    public String getGroupName() 
    {
        return groupName;
    }

    public void addCourse(Course course) 
    {
        courses.add(course);
    }

    public void addNonCourseBlock(NonCourseBlock block) 
    {
        nonCourseBlocks.add(block);
    }

    public void displaySchedule(String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        System.out.println("Schedule for group: " + groupName);
        writer.write("Schedule for group: " + groupName + "\n\n");

        // Define days of the week
        String[] dayCodes = {"M", "T", "W", "TH", "F"};
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // Iterate over each day
        for (int i = 0; i < dayCodes.length; i++) {
            String currentDayCode = dayCodes[i];
            String currentDayName = dayNames[i];

            System.out.println(currentDayName + ":");
            writer.write(currentDayName + ":\n");
            boolean hasItems = false;

            // Check courses
            for (Course course : courses) {
                for (String timeslot : course.getTimeslots()) {
                    // Parse individual days from the timeslot
                    String[] days = parseDays(timeslot);

                    // Check if the current day matches the parsed days
                    for (String day : days) {
                        if (day.equals(currentDayCode)) {
                            String output = "  Course: " + course.getName() + " | " + timeslot;
                            System.out.println(output);
                            writer.write(output + "\n");
                            hasItems = true;
                        }
                    }
                }
            }

            // Check non-course blocks
            for (NonCourseBlock block : nonCourseBlocks) {
                // Parse individual days from the block's timeslot
                String[] days = parseDays(block.getTimeslot());

                // Check if the current day matches the parsed days
                for (String day : days) {
                    if (day.equals(currentDayCode)) {
                        String output = "  Block: " + block.getName() + " | " + block.getTimeslot();
                        System.out.println(output);
                        writer.write(output + "\n");
                        hasItems = true;
                    }
                }
            }

            // If no items found for the current day
            if (!hasItems) {
                String output = "  No items scheduled.";
                System.out.println(output);
                writer.write(output + "\n");
            }

            System.out.println();
            writer.write("\n");
        }

        System.out.println("Schedule saved to " + filename);
        writer.write("Schedule saved to " + filename + "\n");

    } catch (IOException e) {
        e.printStackTrace();
    }
}


/**
 * Parses composite timeslot strings into individual day codes.
 * For example: "MW" -> ["M", "W"], "TTH" -> ["T", "TH"].
 *
 * @param timeslot The timeslot string to parse.
 * @return An array of individual day codes.
 */
private String[] parseDays(String timeslot) {
    List<String> days = new ArrayList<>();

    // Match specific multi-day codes
    if (timeslot.contains("MW")) {
        days.add("M");
        days.add("W");
    }
    if (timeslot.contains("TTH")) {
        days.add("T");
        days.add("TH");
    }

    // Match individual days
    if (timeslot.contains("M") && !days.contains("M")) {
        days.add("M");
    }
    if (timeslot.contains("T") && !days.contains("T")) {
        days.add("T");
    }
    if (timeslot.contains("W") && !days.contains("W")) {
        days.add("W");
    }
    if (timeslot.contains("TH") && !days.contains("TH")) {
        days.add("TH");
    }
    if (timeslot.contains("F") && !days.contains("F")) {
        days.add("F");
    }

    return days.toArray(new String[0]);
}



}
