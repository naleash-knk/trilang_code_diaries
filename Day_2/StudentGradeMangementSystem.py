class StudentGradeManagementSystem:
    class Student:
        def __init__(self,name,rollNo,noOfSubjects):
            self.name=name
            self.rollNo=rollNo
            self.marks=[]

            for i in range(0,noOfSubjects):
                print("Subject: "+str(i+1))
                self.marks.append(int(input()))
            
            self.marks.sort()
        
        def getTotalMark(self) -> int:
            total=0
            for i in self.marks:
                total+=i

            return total
        
        def getAverage(self) -> int:
            total = self.getTotalMark()
            return total/len(self.marks)
        
        def getHighestMark(self) -> int:
            if(len(self.marks)==0):
                raise Exception("no marks allocated for you")
            return self.marks[-1]
        
        def getLowestMark(self) -> int:
            if(len(self.marks)==0):
                raise Exception("no marks allocated for you")
            return self.marks[0]
        
        def __str__(self):
            return f"""
            *****************************************
                    {self.name}
                    {self.rollNo}
                    {self.getTotalMark()}
                    {self.getAverage()}
                    {self.getHighestMark()}
                    {self.getLowestMark()}
            ******************************************
                    """
    class GradeBook:
        def __init__(self):
            self.students=[]

        def addStudent(self,s):
            self.students.append(s)
        
        def getTopStudent(self):
            if not self.students:
                raise Exception("No Student Entries")
            s=self.students[0]
            for i in self.students:
                if i.getAverage() > s.getAverage():
                    s=i
            return s
        
        def __str__(self):
            allDatas = []
            for i in self.students:
                allDatas.append(i)
            
            return "\n".join(str(s) for s in self.students)
        
if __name__=="__main__":
    arrslv = StudentGradeManagementSystem()

    print("Student 1")
    s1 = arrslv.Student("Gautham",111,3)

    print("Student 2")
    s2 = arrslv.Student("Rubhasri",121,3)

    print("Student 3")
    s3 = arrslv.Student("Nivedhitha",131,3)

    print("Student 4")
    s4 = arrslv.Student("Paramaguru",141,3)

    print("Student 5")
    s5 = arrslv.Student("Kaushif",151,3)

    print("Student 6")
    s6 = arrslv.Student("Kandhaguru",161,3)

    class8 = arrslv.GradeBook()

    class8.addStudent(s1)
    class8.addStudent(s5)
    class8.addStudent(s3)
    class8.addStudent(s2)
    class8.addStudent(s6)
    class8.addStudent(s4)

    print(class8)

    top = class8.getTopStudent()
    print("Top Scorer:"+top)