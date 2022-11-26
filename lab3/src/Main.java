import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Pupil[] pup = {new SchoolStudent("Bal" ,"Vem",11 , 11),
                new Student("Len" ,"Ki",20 , 1),
                new Student("Fed" ,"Lem",24 , 4)
        };

        Conference sh1 = new Conference();
        int numberOfSchoolStudents=sh1.SchoolStudentFind(pup);
        System.out.println("SchoolChild: " + numberOfSchoolStudents);
        int numberOfStudents = sh1.StudentsFind(pup);
        System.out.println("SchoolChild: " + numberOfStudents);


    }
}
