// Task : Student grade calculator

import java.util.*;

public class Task3 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of grades: ");
        int numOfGrades = sc.nextInt();

        double[] grades = new double[numOfGrades];

        for (int i=0;i<numOfGrades;i++)
        {
            System.out.println("Enter grade number" + (i+1)+": ");
            grades[i]=sc.nextDouble();
        }

        double sum=0;
        for (int j=0;j<grades.length;j++)
        {
            sum += grades[j];
        }
        double average = sum / numOfGrades;

        System.out.println("The average grade is : " + average);
        sc.close();
    }
}
