public class Course {
    private Integer CourseId;
    private String CourseTitle;
    private String CourseStatedDate;
    private String CourseEndedDate;
    private Boolean IsAvailable;
    public Course(){}

    public Course(Integer courseId, String courseTitle, String courseStatedDate, String courseEndedDate, Boolean isAvailable) {
        CourseId = courseId;
        CourseTitle = courseTitle;
        CourseStatedDate = courseStatedDate;
        CourseEndedDate = courseEndedDate;
        IsAvailable = isAvailable;
    }
    public Integer getCourseId(){
        return CourseId;
    }
    public String getCourseTitle(){
        return CourseTitle;
    }
    public String getCourseStatedDate(){
        return CourseStatedDate;
    }
    public String getCourseEndedDate(){
        return CourseEndedDate;
    }
    public Boolean getAvailable(){
        return IsAvailable;
    }
    public void setCourseId(Integer courseId) {
        CourseId = courseId;
    }
    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }
    public void setCourseStatedDate(String courseStatedDate) {
        CourseStatedDate = courseStatedDate;
    }
    public void setCourseEndedDate(String courseEndedDate) {
        CourseEndedDate = courseEndedDate;
    }
    public void setAvailable(Boolean available) {
        IsAvailable = available;
    }
}
