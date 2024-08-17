// Task : Password strength checker 

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Password: ");
        String password = sc.nextLine();
        String checkStrength = checkPasswordStrength(password);
        System.out.println("The strength of the password is : "+checkStrength);
        sc.close();
    }

    public static String checkPasswordStrength(String pass)
    {
        int lengthCriteria = 5;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch:pass.toCharArray())
        {
            if(Character.isLowerCase(ch))
            {
                hasLowerCase = true;
            }
            if(Character.isUpperCase(ch))
            {
                hasUpperCase = true;
            }
            if(Character.isDigit(ch))
            {
                hasDigit = true;
            }
            if(!Character.isLetterOrDigit(ch))
            {
                hasSpecialChar = true;
            }
        }

        int strengthScore = 0;

        if(pass.length() >= lengthCriteria )
        {
            strengthScore++;
        }
        if(hasLowerCase)
        {
            strengthScore++;
        }
        if(hasUpperCase)
        {
            strengthScore++;
        }
        if(hasDigit)
        {
            strengthScore++;
        }
        if(hasSpecialChar)
        {
            strengthScore++;
        }

        switch(strengthScore)
        {
            case 1: 
                return "Very Weak";
            case 2:
                return "Weak";
            case 3:
                return "Moderate";
            case 4:
                return "Strong";
            case 5:
                return "Very Strong";
            default:
                return "No Strength in Password";
        }

    }
}
