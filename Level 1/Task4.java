
import java.util.*;

// Task: Random Password Generator

public class Task4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the password: ");
        int length = sc.nextInt();

        System.out.println("Enter y for include numbers else press n :(y || n): ");
        char includeNumbers = sc.next().charAt(0);

        System.out.println("Enter y for include lowercase else press n :(y || n): ");
        char includeLowercase = sc.next().charAt(0);

        System.out.println("Enter y for include uppercase else press n :(y || n): ");
        char includeUppercase = sc.next().charAt(0);

        System.out.println("Enter y for include special characters else press n :(y || n): ");
        char includeSpecial = sc.next().charAt(0);

        String password = generatePassword(length, includeNumbers,includeLowercase,includeUppercase,includeSpecial);
        System.out.println("The generated password : " +password);
        sc.close();
    }

    public static String generatePassword(int length,char includeNumbers,char includeLowercase,char includeUppercase,char includeSpecial)
    {
        Random rm = new Random();

        String pass="";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special = "!@#$%^&*()_+-={}:<>?";

        if(includeNumbers=='y' || includeNumbers=='Y')
        {
            pass = pass + numbers;
        }
        if(includeLowercase=='y' || includeLowercase=='Y')
        {
            pass = pass + lowerCase;
        }
        if(includeUppercase=='y'||includeUppercase=='Y')
        {
            pass = pass + upperCase;
        }
        if(includeSpecial=='y'||includeSpecial=='Y')
        {
            pass = pass + special;
        }
        if(pass.isEmpty() || length == 0)
        {
            return "Password should have at least one Character";
        }
        else{
            String OriginalPass = "";
            for(int i=0; i<length;i++)
            {
                int index = rm.nextInt(pass.length());
                char randomChar = pass.charAt(index);
                OriginalPass = OriginalPass + randomChar;
            }
            return OriginalPass;
        }
    }

    
}
