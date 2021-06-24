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
        System.out.println("Bitte Ihre wunsch bmi angeben");
        float minBmi = (float)Double.parseDouble(scanner.nextLine());
        System.out.println("Bitte Abnahme pro Woche in KG angeben (Default = 1kg)");
        float schrittGewicht=0.5f;
        String eingabe="";
        eingabe = scanner.nextLine();
        if (! eingabe.isEmpty()) {
            schrittGewicht = Float.parseFloat(eingabe);
        }
        int zahl = 0;
        double[] bmiWerte=new double[1000];
        float aktGewicht=gewicht;
        scanner.close();
        double bmi=0;
        do {
            bmi = aktGewicht / (height * height);

            String ergebnis = bmi < 19 ?
                    "Untergewicht" :
                    bmi > 25 ?
                            "Übergewicht" :
                            "Normalgewicht";
            System.out.printf("%5s\t%3.2f\t%2.2f\t%s\n", zahl==0? "":zahl, aktGewicht, bmi, ergebnis);
            aktGewicht -= schrittGewicht;
        //    ++ zahl;
            bmiWerte[zahl++]=bmi;
        }while (bmi>= minBmi);
    System.out.println("Sie müssen " + (zahl -1)  + " Wochen fasten");
}}