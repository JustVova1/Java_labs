public class Conference {
    int numberOfStudents =0;
    int numberOfSchoolStudents =0;
    public Pupil pup = new Pupil();
    int SchoolStudentFind(Pupil[] pup){
        for(Pupil a : pup ){
            if(a instanceof SchoolStudent){
                numberOfSchoolStudents=numberOfSchoolStudents+1;
            }
        }
        return  numberOfSchoolStudents;

    }
    public int StudentsFind(Pupil[] pup){
        for(Pupil a : pup ){
            if(a instanceof Student){
                numberOfStudents=numberOfStudents+1;
            }
        }
        return  numberOfStudents;

    }
}
