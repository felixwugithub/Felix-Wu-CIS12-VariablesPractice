public class Course {

    private String courseName;
    private String teacherName;
    int block;

    public Course(String courseName, String teacherName, int block){
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.block = block;

    }

    public String getCourseName(){
        return courseName;
    }

    public String getTeacherName(){
        return teacherName;

    }

    public int getBlock(){
        return block;
    }



}
