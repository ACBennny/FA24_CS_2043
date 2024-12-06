import java.util.Scanner;

/*******************************************************************************************************************
 * @author Group Members:
 *         Dawit Ashenafi Getachew 3752264,
 *         Chizaram Ikpo 3760059,
 *         Owen Yesuf 3755739,
 *         Chukwuemeka Anyanwu 3753658
 * @date 30-11-2024
 * 
 * Entry point for the Schedule Tool program.
 * Handles user input and coordinates the creation and management of groups, courses, and non-course blocks.
 ******************************************************************************************************************/

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create a group
        System.out.print("Enter group name: ");
        String groupName = scanner.nextLine();
        Group group = new Group(groupName);

        // Step 2: Add courses
        System.out.print("How many courses would you like to add? ");
        int numCourses = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numCourses; i++) 
        {
            System.out.println("Enter details for course " + (i + 1) + ":");
            System.out.print("  Name: ");
            String courseName = scanner.nextLine();
            System.out.print("  Timeslots (e.g., 'MW 9:00AM-10:30AM; F 2:00PM-3:00PM'): ");
            String timeslots = scanner.nextLine();
            group.addCourse(new Course(courseName, timeslots));
        }

        // Step 3: Add non-course blocks
        System.out.print("How many non-course blocks would you like to add? ");
        int numBlocks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numBlocks; i++) 
        {
            System.out.println("Enter details for non-course block " + (i + 1) + ":");
            System.out.print("  Name: ");
            String blockName = scanner.nextLine();
            System.out.print("  Timeslot (e.g., 'F 1:00PM-2:00PM'): ");
            String timeslot = scanner.nextLine();
            group.addNonCourseBlock(new NonCourseBlock(blockName, timeslot));
        }

        // Step 4: Display schedule and save to file
        String outputFilename = groupName.replaceAll("\\s+", "_") + "_schedule.txt";
        group.displaySchedule(outputFilename);

        scanner.close();
    }
}
