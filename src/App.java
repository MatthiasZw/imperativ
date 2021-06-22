
import java.io.Console;
import java.sql.SQLOutput;
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
        float gewicht = Float.parseFloat(scanner.nextLine());
        //int gewicht= scanner.nextInt();
        System.out.println("Sie wiegen " + gewicht);


        System.out.println("Bitte Ihre Größe in Meter angeben");
        float height = Float.parseFloat(scanner.nextLine());
        System.out.println("Größe " + height);
        System.out.println("Bitte Ihre Abbruch bmi angeben");
        float maxBmi = (float)Double.parseDouble(scanner.nextLine());
        System.out.println("Bitte Schrittweite in KG angeben (Default = 1kg)");
        float schrittGewicht=1.0f;
        String eingabe="";
        eingabe = scanner.nextLine();
        if (! eingabe.isEmpty()) {
            schrittGewicht = Float.parseFloat(eingabe);
        }

        double bmi=0;
        float aktGewicht=gewicht;
        while (bmi<= maxBmi){

            bmi = aktGewicht / (height * height);

            String ergebnis="Normalgewicht";
            aktGewicht=aktGewicht + schrittGewicht;

            switch ((short) (bmi<19 ?1 : bmi>25 ?3 : 2)){
                case 1 :
                    ergebnis="Untergewicht"; break;
                case 2 : break;
                case 3 :
                    ergebnis=("Uebergewicht"); break;
                default:
                    ergebnis="Keine Ahnung"; break;

            }
           System.out.printf("%3.2f\t%2.2f\t%s\n", aktGewicht,bmi,ergebnis);
        aktGewicht=aktGewicht + schrittGewicht;

}}}