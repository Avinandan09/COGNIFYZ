// Task : Temperature Converter between Celsius and Fahrenheit

import java.text.DecimalFormat;
import java.util.Scanner;

public class Task1
{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        System.err.println("Enter C for Convert the temperature Celsius to Fahrenheit ");
        System.out.println("Enter F for Convert the temperature Fahrenheit to Celsius ");

        char unit = sc.next().charAt(0);

        if( unit=='C' || unit=='c')
        {
            System.out.println("Enter the temperature in Celsius: ");
            double celsiusTemperature = sc.nextDouble();
            double fahrenheitConvertion = (celsiusTemperature * 9/5) + 32;
            System.out.println(celsiusTemperature + " in Celsius is equal to " + df.format(fahrenheitConvertion) + " in Fahrenheit");
        }
        else if (unit=='F' || unit=='f')
        {
            System.out.println("Enter the temperature in Fahrenheit: ");
            double fahrenheitTemperature = sc.nextDouble();
            double celsiusConversion = (fahrenheitTemperature - 32) * 5/9;
            System.out.println(fahrenheitTemperature + " in Fahrenheit is equal to " + df.format(celsiusConversion) + " in Celsius ");
        }
        else
        {
            System.out.println("Invalid Input");
        }
        sc.close();
    }
}