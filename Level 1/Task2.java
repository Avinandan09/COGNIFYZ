// Task : Palindrome Checker



import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word or a phrase: ");
        String str = sc.nextLine();

        if(isPalindrome(str))
        {
            System.out.println("The word or the phrase is palindrome");
        }
        else{
            System.out.println("The word or the phrase is not palindrome");
        }
    }

    public static boolean isPalindrome(String input)
    {
        String reverseInput = "";
        for (int i=(input.length() - 1);i>=0;i--)
        {
            reverseInput= reverseInput+ input.charAt(i);
        }

        if(input.toLowerCase().equals(reverseInput.toLowerCase()))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
