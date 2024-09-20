import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        AttendanceSystem attendanceSystem = new AttendanceSystem();
        GradingSystem gradingSystem = new GradingSystem();
        LibrarySystem librarySystem = new LibrarySystem();

        SchoolManagementApp attendanceAdapter = new AttendanceSystemAdapter(attendanceSystem);
        SchoolManagementApp gradingAdapter = new GradingSystemAdapter(gradingSystem);
        SchoolManagementApp libraryAdapter = new LibrarySystemAdapter(librarySystem);

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("INTEGRATE SYSTEM");
            System.out.println("1. Attendance System \n2. Grading System \n3. Library System \n4. Exit");
            System.out.print("\nSelect a System to Integrate:");

            int system = s.nextInt();
            s.nextLine();  

            SchoolManagementApp selectedAdapter;
            switch (system) {
                case 1:
                    selectedAdapter = attendanceAdapter;
                    break;
                case 2:
                    selectedAdapter = gradingAdapter;
                    break;
                case 3:
                    selectedAdapter = libraryAdapter;
                    break;
                case 4:
                    System.out.println("\nSchool Management App Exited.");
                    s.close();
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
                    continue;
            }

            System.out.println("\nIntegration Result: " + selectedAdapter.integrateSystem() + "\n");

        }
    }
}
