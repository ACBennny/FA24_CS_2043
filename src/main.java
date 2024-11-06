import java.util.Scanner;
public class main
{
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);
        Group group = new Group("My Schedule Group");

        while(true)
        {
            //Display menu options
            System.out.println("\nChoose an option: ");
            System.out.println("1. Add a Course");
            System.out.println("2. Check for Conflicts");
            System.out.println("3. Display Schedule");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();


            switch (choice)
            {
                case 1:
                    //Add a course
                    addCourseToGroup(myScanner.group);
                    break;
                case 2:
                    //Check for Conflicts
                    group.checkConflicts();
                    break;
                case 3:
                    //Display Schedule
                    group.displaySchedule();
                    break;
                case 4:
                    //Exit
                    System.out.println("Bye!");
                    myScanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    //Helper Method to add course
    public static void addCourseToGroup(Scanner myScanner, Group group)
    {
        System.out.print("Enter course code: ");
        String courseCode = myScanner.nextLine();

        System.out.print("Enter extra text: ");
        String extraText = myScanner.nextLine();

        System.out.print("Enter Day(M,T,W,TH,F): ");
        String day = myScanner.nextLine();

        System.out.print("Enter Start time(e.g 2:30PM): ");
        String startTime = myScanner.nextLine();

        System.out.print("Enter End time(e.g 2:30PM): ");
        String endTime = myScanner.nextLine();


        Course course = new Course(courseCode, extraText, day, startTime, endTime);
        group.addCourse(course);

        System.out.println("Added course " + courseCode + " to group");
    }
}
