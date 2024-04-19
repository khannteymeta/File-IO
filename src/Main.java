import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImp();
        do {
            View.menu();
            System.out.print("Choose one option : ");
            int op = new Scanner(System.in).nextInt();
            switch (op){
                case 1:{
                    courseService.addNewCourse();
                    break;
                }
                case 2:{
                    courseService.getAllCourse();
                    break;
                }
                case 3:{
                    courseService.getCourseById();
                    break;
                }
                case 0:{
                    System.out.println("Exit program !");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice ! Please try again");
            }
        }while (true);
    }
}