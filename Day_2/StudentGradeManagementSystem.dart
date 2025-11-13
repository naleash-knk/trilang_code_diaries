import 'dart:io';

void main() {
  StudentGradeManagementSystem arrslv = StudentGradeManagementSystem();

  print("Student: 1");
  Student s1 = arrslv.student("Gautham", 111, 3);

  print("Student: 2");
  Student s2 = arrslv.student("Rubashir", 121, 3);

  print("Student: 3");
  Student s3 = arrslv.student("Nivedhitha", 131, 3);

  print("Student: 4");
  Student s4 = arrslv.student("Paramaguru", 141, 3);

  print("Student: 5");
  Student s5 = arrslv.student("Kaushik", 151, 3);

  print("Student: 6");
  Student s6 = arrslv.student("Kandhaguru", 161, 3);

  List<Student> st = [s1, s2, s3, s4, s5, s6];

  GradeBook class8 = arrslv.gradebook();

  st.forEach((ele) {
    class8.addStudent(ele);
  });

  class8.displayAll();

  Student top = class8.getTopper();

  print("Topper: ${top.name} with average ${top.getAverage()}");
}

class StudentGradeManagementSystem {
  Student student(String name, int rollNo, int noOfSubjects) {
    return Student(name, rollNo, noOfSubjects);
  }

  GradeBook gradebook() {
    return GradeBook();
  }
}

class Student {
  late String name;
  late int rollNo;
  late List<int> marks; 

  Student(String name, int rollNo, int noOfSubjects) {
    this.name = name;
    this.rollNo = rollNo;
    this.marks = []; 

   for (int i = 0; i < noOfSubjects; i++) {
    stdout.write("Enter marks for Subject ${i + 1}: ");
      int mark = int.parse(stdin.readLineSync()!);
    marks.add(mark);
    }


    marks.sort();
  }

  int getTotalMark() {
    if (marks.isEmpty) {
      throw Exception("No Marks Allocated for $name");
    }
    int total = 0;
    for (int m in marks) {
      total += m;
    }
    return total;
  }

  int getAverage() {
    int total = getTotalMark();
    return total ~/ marks.length;
  }

  int getHighestMark() {
    if (marks.isEmpty) {
      throw Exception("No Marks Allocated for $name");
    }
    return marks.last; 
  }

  int getLowestMark() {
    if (marks.isEmpty) {
      throw Exception("No Marks Allocated for $name");
    }
    return marks.first;
  }
}

class GradeBook {
  List<Student> studs = [];

  void addStudent(Student s) {
    studs.add(s);
    print("${s.name} Added Successfully\n");
  }

  Student getTopper() {
    if (studs.isEmpty) {
      throw Exception("Student List is Empty");
    }
    Student s = studs[0];
    for (var ele in studs) {
      if (ele.getAverage() > s.getAverage()) {
        s = ele;
      }
    }
    return s;
  }

  void displayAll() {
    if (studs.isEmpty) {
      throw Exception("Student List is Empty");
    }

    for (var ele in studs) {
      print("*************************************************");
      print("Name: ${ele.name}");
      print("Roll No: ${ele.rollNo}");
      print("Marks: ${ele.marks}");
      print("Total: ${ele.getTotalMark()}");
      print("Average: ${ele.getAverage()}");
      print("Highest: ${ele.getHighestMark()}");
      print("Lowest: ${ele.getLowestMark()}");
      print("*************************************************\n");
    }
  }
}