import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static String scheduleTop(int length){

        String line ="+ Period";

        for (int i = 0; i < (length/2-19) ; i++) {

            line = line.concat("-");
        }
        line = line.concat("Course Name");
        for (int i = 0; i < (length/2-15) ; i++) {

            line = line.concat("-");
        }
        line = line.concat("Teacher Name +");

        return line;
    }


    public static String spaces(int length){
        String space ="";

        for (int i = 0; i < length ; i++) {

            space = space.concat(" ");
        }
        return space;


    }

    public static String scheduleRow(int width, Course course){

        width = width/2;
        String row = "";
        int num = course.getBlock();

        row = row.concat("| ");
        row = row.concat(String.valueOf(course.getBlock()));
        row = row.concat(" |");
        row = row.concat(spaces(width - 5 - course.getCourseName().length()));
        row = row.concat(course.getCourseName());
        row = row.concat(" |");
        row = row.concat(spaces(width  - 5 - course.getTeacherName().length()));
        row = row.concat(course.getTeacherName());
        row = row.concat(" | ");

        return row;


    }


    public static String makeScheduleTable(int width, ArrayList<Course> Courses) {

        String chart = "";
        chart = scheduleTop(width);

        for (int i = 0; i < Courses.size(); i++) {
            chart = chart.concat("\n");
            chart = chart.concat(scheduleRow(width, Courses.get(i)));
        }


        chart = chart.concat("\n+");
        for (int i = 0; i < width - 3; i++) {
            chart = chart.concat("-");
        }
        chart = chart.concat("+");

        return chart;
    }

    public static void main(String[] args) {

        ArrayList<Course> Courses = new ArrayList<Course>();
        Course CW11 = new Course("Creative Writing 11", "Mrs. Kwan", 1);
        Course FR11 = new Course("French 11", "Mr. Matthews", 2);
        Course APP1 = new Course("AP Physics 1", "Mr. Tang", 3);
        Course CI12 = new Course("Computer Information Systems 12", "Mr. Zaremba", 4);
        Course APME = new Course("AP Microeconomics", "Mrs. Sodhi", 5);
        Course PAPC = new Course("Pre-AP Chemistry", "Mr. Slapsys", 6);
        Course PC12 = new Course("Pre-Calculus 12", "Mr. Grabowsky", 7);
        Course CP12 = new Course("Computer Programming 12", "Mr. Zaremba", 8);

        
        Courses.add(APP1);
        Courses.add(APME);
        Courses.add(PAPC);
        Courses.add(PC12);
        Courses.add(CI12);
        Courses.add(CW11);
        Courses.add(CP12);
        Courses.add(FR11);

        int width = 80;

        Courses.sort(Comparator.comparing(Course::getBlock));

        String scheduleTable = makeScheduleTable(80, Courses);
        System.out.print(scheduleTable);

    }




}
