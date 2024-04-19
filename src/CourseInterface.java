import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

interface CourseService{
    abstract void addNewCourse();
    abstract void getAllCourse();
    abstract void getCourseById();
}
class CourseServiceImp implements CourseService{
    @Override
    public void addNewCourse() {
        try{
            Course course = new Course();
            String title;
            BufferedWriter Writer = new BufferedWriter(new FileWriter("course.csv",true));
            course.setCourseId(new Random().nextInt(100));
            System.out.print("Enter Title of Course: ");
            title = new Scanner(System.in).nextLine();
            course.setCourseTitle(title);
            course.setCourseStatedDate(String.valueOf(LocalDate.of(2024,2,2)));
            course.setCourseEndedDate(String.valueOf(LocalDate.of(2025,3,3)));
            course.setAvailable(true);
            String data = course.getCourseId()+","
                    + course.getCourseTitle()+","
                    + course.getCourseStatedDate()+","
                    + course.getCourseEndedDate()+","
                    + course.getAvailable()+" \n";
            Writer.write(data);
            Writer.close();
            System.out.println("[+] Add new course successfully..");
        }catch (Exception ignore){}
    }

    @Override
    public void getAllCourse() {
        try {
            BufferedReader Reader = new BufferedReader(new FileReader("course.csv"));
            Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
            for (int i =0;i<5;i++){
                table.setColumnWidth(i,20,20);
            }
            table.addCell("course_id");
            table.addCell("course_name");
            table.addCell("course_started_date");
            table.addCell("course_ended_date");
            table.addCell("course_available");
            String data;
            String [] result = null;
            while ((data=Reader.readLine())!=null){
                result = data.split(",");
                table.addCell(result[0],1);
                table.addCell(result[1],1);
                table.addCell(result[2],1);
                table.addCell(result[3],1);
                table.addCell(result[4],1);
            }
            Reader.close();
            System.out.println(table.render());
        }catch (Exception ignore){

        }
    }

    @Override
    public void getCourseById() {
        try {
            System.out.print("Insert course ID: ");
            int sId = new Scanner(System.in).nextInt();
            String data;
            String[] result;
            Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);

            BufferedReader Reader = new BufferedReader(new FileReader("course.csv"));
            table.addCell("course_id");
            table.addCell("course_name");
            table.addCell("course_started_date");
            table.addCell("course_ended_date");
            table.addCell("course_available");
            boolean found = false; // Flag to track if the ID is found
            while ((data = Reader.readLine()) != null) {
                result = data.split(",");
                if (Integer.parseInt(result[0]) == sId) {
                    table.addCell(result[0]);
                    table.addCell(result[1]);
                    table.addCell(result[2]);
                    table.addCell(result[3]);
                    table.addCell(result[4]);
                    found = true;
                    break;
                }
            }
            Reader.close();
            if (!found) {
                System.out.println("Not found this courseID: "+sId);
            } else {
                System.out.println(table.render());
            }
        } catch (Exception ignore) {
        }
    }

}

