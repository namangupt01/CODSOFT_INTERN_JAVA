//Input: Take marks obtained (out of 100) in each subject.
//        Calculate Total Marks: Sum up the marks obtained in all subjects.
//        Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
//        average percentage.
//        Grade Calculation: Assign grades based on the average percentage achieved.
//        Display Results: Show the total marks, average percentage, and the corresponding grade to the user
import java.sql.SQLOutput;
import java.util.*;

public class StudentGradeCalculator {
    // here i am taking the marks in 6 subjects of the curriculum

    public static void main(String[] args)
    {
        // first of all i will take the input from the user in terms of marks obtained by him/her
        // to do i will create an instance of the scanner class
        Scanner sc = new Scanner(System.in);

        // initialize the subjects
        int maths,hindi,science,sanskrit,english,general_knowledge;
        System.out.println("STUDENT GRADE CALCULATOR");
        System.out.println("Enter the marks obtained by the student");
        // now i will input them all the subject marks ;
        System.out.print("Maths:");
        maths =sc.nextInt();
        System.out.print("Hindi:");
       hindi =sc.nextInt();
        System.out.print("Sanskrit:");
       sanskrit =sc.nextInt();
        System.out.print("English:");
       english =sc.nextInt();
        System.out.print("General Knowledge:");
        general_knowledge =sc.nextInt();
        System.out.print("Science:");
       science =sc.nextInt();
       // we can also do this with the help of the loops but the number of subjects i have taken are less
        // this approach can also be preferable
       int sum = (maths +english+sanskrit+science+general_knowledge+hindi);
        System.out.print("Total Marks gained  by the student :");
        System.out.println(sum);

        double average_percentage= (sum/6) ;  // here 6 is the total number of students

        System.out.print("Average Percentage gained by the student: ");
        System.out.println(average_percentage);







        if(average_percentage >=0 && average_percentage <=34 )
        {
            System.out.println("GRADE: E");
            System.out.println("Failed");
        }
        else if(average_percentage >=35 && average_percentage <=49 )
        {
            System.out.println("GRADE: D");
            System.out.println("Work Harder");
        }
        else if(average_percentage >=50 && average_percentage <=69 )
        {
            System.out.println("GRADE: C");
            System.out.println("Could be better and needs more practice ");
        }
        else if(average_percentage >=70 && average_percentage <=84 )
        {
            System.out.println("GRADE: B");
            System.out.println("Very Good Performance");

        }
        else {
            System.out.println("Excellent!Good Job");
        }

        System.out.println();

        System.out.println("____________________________________________________________________________");
        System.out.println("____________________________________________________________________________");

        System.out.println("  here i am going to give the grade in the following way \n" +
                "         85-100 ---> A   // Excellent Result\n" +
                "         70-84 --->  B   // Very Good Performance\n" +
                "         50 - 69 ---> C  // Could be better and need more practice \n" +
                "         35 - 49 ---> D // Work Harder \n" +
                "         0- 34 ---->E //Failed");
        System.out.println("____________________________________________________________________________");
        System.out.println("____________________________________________________________________________");





    }


}
