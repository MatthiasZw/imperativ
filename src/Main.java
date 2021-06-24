import java.util.Scanner;



public class Main {

    static Scanner scanner = new Scanner(System.in);
    static double [] bmiWerte = new double [1000];
    static float aktGewicht = 0;
    static float gewicht = 0;
    static float groesse = 0;
    static float minBMI = 0;
    static float schrittGewicht = .5f;
    static int anzWoche = 0;



    public static void main(String[] args) {

        eingabeBmiWerte();
        berechnungUndSpeicherungBmiWerte();
        ausgabeBMIWerte();


    }
    private static void eingabeBmiWerte() {

        System.out.println("BMI Rechner v 1.0");
        System.out.println("Bitte Ihr Startgewicht in kg eingeben: ");
        gewicht = Float.parseFloat(scanner.nextLine());
        System.out.println("Bitte Ihre Körpergröße in m angeben: ");
        groesse = (float) Double.parseDouble(scanner.nextLine());
        System.out.println("Bitte Wunsch-BMI angeben: ");
        minBMI = (float) Double.parseDouble(scanner.nextLine());
        System.out.println("Bitte Gewichtsabnahme pro Woche in Kg eingeben (Default: 0.5 kg) angeben: ");


        String eingabe = "";
        eingabe = scanner.nextLine();
        if (! eingabe.isEmpty()) {
            schrittGewicht = Float.parseFloat(eingabe);
        }


        aktGewicht = gewicht;


        scanner.close();
    }

    private static void ausgabeBMIWerte() {

        System.out.println("Der Wunsch-Bmi wird nach " + (anzWoche - 1) + " Wochen erreicht.");



        for (int i = 0; i < bmiWerte.length; i++) {
            if (bmiWerte[i] != 0.0) {
                System.out.printf("%-10s\t %5.2f\n", i == 0 ? "Start": "Woche " + i, bmiWerte[i]);
            }
        }
    }

    private static void berechnungUndSpeicherungBmiWerte() {
        double bmi = 0;


        do {
            bmi = aktGewicht / (groesse * groesse);
            String ergebnis =
                    bmi < 19.0 ?
                            "Untergewicht":
                            bmi > 25 ?
                                    "Übergewicht":
                                    "Normalgewicht";



            System.out.printf("%5s\t%3.2f\t%2.2f\t%s\n", anzWoche == 0?"": anzWoche, aktGewicht, bmi, ergebnis);
            aktGewicht -= schrittGewicht;
            bmiWerte[anzWoche++] = bmi;
        } while(bmi >= minBMI);
    }
}