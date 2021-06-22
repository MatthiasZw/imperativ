
import java.io.Console;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String start = "BMI Rechner V 1.1";
        System.out.println(start);
        String namen = "Bitte Ihren Namen eingeben:";
        System.out.println(namen);
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.nextLine();
        System.out.println("Hallo " + nickname);


        System.out.println("Bitte Ihr Gewicht in Kilogramm angeben");
        int gewicht = Integer.parseInt(scanner.nextLine());
        //int gewicht= scanner.nextInt();
        System.out.println("Sie wiegen " + gewicht);


        System.out.println("Bitte Ihre Größe in Meter angeben");
        float height = Float.parseFloat(scanner.nextLine());
        System.out.println("Größe " + height);

        double bmi = gewicht / (height * height);

        if (bmi < 19) System.out.println("Untergewicht");
        if (bmi > 25) {
            System.out.println("Uebergewicht");
        }
        if (bmi >= 19 && bmi <= 25) {
            System.out.println("Normalgewicht");
        }
        /*if (bmi < 19) {
            System.out.println("Untergewicht");
        } else if (bmi > 25) {
            System.out.println("Uebergewicht");
        } else {
            System.out.println("Normalgewicht");
        }*/


        System.out.printf("Ihr BMI ist %.2f", bmi);
    }}