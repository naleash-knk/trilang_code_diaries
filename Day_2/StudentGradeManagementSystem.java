import java.util.*;

public class StudentGradeManagementSystem{
    Scanner sc=new Scanner(System.in);
    class Student{
        String name;
        int rollNo;
        int[] marks;
        Student(String name,int rollNo,int totalSubjects){
            this.name=name;
            this.rollNo=rollNo;

            marks = new int[totalSubjects];

            for(int i=0;i<totalSubjects;i++){
                System.out.println("Enter Subject "+(i+1)+" Mark Below:");
                marks[i]=sc.nextInt();
            }

            Arrays.sort(marks);
        }

        public int getTotalMark(){
            int total=0;
            for(int i : marks){
                total+=i;
            }
            return total;
        }

        public int getAverage(){
            int total=this.getTotalMark();
            return total/marks.length;
        }

        public int getHighestMark()throws Exception{
            if(marks.length==0){
                throw new Exception("no Marks allocated for you");
            }
            return marks[marks.length-1];
        }

        public int getLowestMark()throws Exception{
            if(marks.length==0){
                throw new Exception("no Marks allocated for you");
            }
            return marks[0];
        }
    }
    class GradeBook{
        List<Student> students = new ArrayList<>();

        public void addStudent(Student s){
            students.add(s);
            System.out.println(s.name+" Added to GradeBook Successfully");
        }

        public Student getTopStudent() throws Exception{
            if(students.isEmpty()){
                throw new Exception("There is no entries in grade book");
            }
            Student top = students.get(0);
            for(Student s:students){
                if(s.getAverage()>top.getAverage()){
                    top=s;
                }
            }
            return top;
        }

        public void displayAll() throws Exception{
            if(students.isEmpty()){
                throw new Exception("There is no entries in grade book");
            }

            for(Student s:students){
                System.out.println("***************************");
                System.out.println(s.name);
                System.out.println(s.rollNo);
                for(int i : s.marks){
                    System.out.print(i+" ");
                }
                System.out.println();
                int hm = s.getHighestMark();
                int lm = s.getLowestMark();
                int avg = s.getAverage();
                int tot = s.getTotalMark();

                System.out.println("Total: "+tot);
                System.out.println("Average: "+avg);
                System.out.println("Highest Mark: "+hm);
                System.out.println("Lowest Mark: "+lm);
                System.out.println("***************************");
            }
        }
    }

    public static void main(String[] args) throws Exception{
        StudentGradeManagementSystem arrslv =new StudentGradeManagementSystem();
        System.out.println("Student 1");
        StudentGradeManagementSystem.Student std1 = arrslv.new Student("Gautham", 111, 5);
        System.out.println("Student 2");
        StudentGradeManagementSystem.Student std2 = arrslv.new Student("Rubasri", 121, 5);
        System.out.println("Student 3");
        StudentGradeManagementSystem.Student std3 = arrslv.new Student("Nivedhitha", 131, 5);
        System.out.println("Student 4");
        StudentGradeManagementSystem.Student std4 = arrslv.new Student("Paramaguru", 141, 5);
        System.out.println("Student 5");
        StudentGradeManagementSystem.Student std5 = arrslv.new Student("Kaushik", 151, 5);
        System.out.println("Student 6");
        StudentGradeManagementSystem.Student std6 = arrslv.new Student("Kandhaguru", 161, 5);

        StudentGradeManagementSystem.GradeBook class8 = arrslv.new GradeBook();

        class8.addStudent(std6);
        class8.addStudent(std2);
        class8.addStudent(std4);
        class8.addStudent(std1);
        class8.addStudent(std3);
        class8.addStudent(std5);
        
        class8.displayAll();

        Student top = class8.getTopStudent();
        System.out.println("Topper class 8: "+top.name);
        System.out.println(top.rollNo);
    }
}