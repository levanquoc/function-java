import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewSource;
    private int noOfStudent;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getReviewSource() {
        return reviewSource;
    }
    public void setReviewSource(int reviewSource) {
        this.reviewSource = reviewSource;
    }
    public int getNoOfStudent() {
        return noOfStudent;
    }
    public void setNoOfStudent(int noOfStudent) {
        this.noOfStudent = noOfStudent;
    }
    public Course(String name, String category, int reviewSource, int noOfStudent) {
        this.name = name;
        this.category = category;
        this.reviewSource = reviewSource;
        this.noOfStudent = noOfStudent;
    }
    public String toString(){
        return this.name + ":" + this.noOfStudent + ":" + this.reviewSource;
    }

}
public class FP04CustomClass{

    public static void main(String[] args) {
        List<Course> courses = List.of(
                                    new Course("Spring","Framework",98,20000),
                                    new Course("Spring boot","Framework",97,20005),
                                    new Course("API","Microservices",96,20000),
                                    new Course("Microservices","Microservices",95,20003),
                                    new Course("Fullstack","Fullstack",94,20002),
                                    new Course("AWS","Cloud",93,20001),
                                    new Course("Docker","Cloud",92,20009)


        );
        //allMatch,noneMatch,antMatch
        Predicate<Course> coursePredicate = course -> course.getReviewSource() > 96;
        System.out.println(courses.stream().allMatch(coursePredicate));
        System.out.println(courses.stream().noneMatch(coursePredicate));
        System.out.println(courses.stream().anyMatch(coursePredicate));
        Comparator<Course> comparingByNoOfStudentIncreasing = Comparator.comparing(Course::getNoOfStudent);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentIncreasing).collect(Collectors.toList()));

        //Comparator
        Comparator<Course> comparingByNoOfStudentDecreasing = Comparator.comparing(Course::getNoOfStudent).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentDecreasing).collect(Collectors.toList()));

        Comparator<Course> comparingByNoOfStudentAndByReviewSource = Comparator.comparing(Course::getNoOfStudent).thenComparing(Course::getReviewSource);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentAndByReviewSource).collect(Collectors.toList()));

        //limit,skip,takeWhile,dropWhile
        System.out.println(courses.stream().sorted(comparingByNoOfStudentAndByReviewSource).limit(5).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(comparingByNoOfStudentAndByReviewSource).skip(3).collect(Collectors.toList()));
        System.out.println(courses.stream().takeWhile(course -> course.getReviewSource()>96).collect(Collectors.toList()));
        System.out.println(courses.stream().dropWhile(course -> course.getReviewSource()>96).collect(Collectors.toList()));
    }
}
