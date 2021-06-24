import java.util.Scanner;
class Patient {

    private String name;

    private double[] bmiWerte = new double[1000];
    private float aktGewicht = 0;
    private float gewicht = 0;
    private float groesse = 0;
    private float minBMI = 0;
    private float schrittGewicht = .5f;
    private int anzWoche = 0;

    public Patient(String name) {
        this.name=name;
    }

    public void eingabeBmiWerte(Scanner scanner) {

        System.out.println("BMI Rechner v 1.0");
        System.out.println("Hallo" + this.name);
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



    }
    public void berechnungUndSpeicherungBmiWerte() {
        double bmi = 0;

        do {
            bmi =aktGewicht / Math.pow(groesse,2) ;
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
    public void ausgabeBMIWerte() {

        System.out.println("Der Wunsch-Bmi wird nach " + (anzWoche - 1) + " Wochen erreicht.");



        for (int i = 0; i < bmiWerte.length; i++) {
            if (bmiWerte[i] != 0.0) {
                System.out.printf("%-10s\t %5.2f\n", i == 0 ? "Start": "Woche " + i, bmiWerte[i]);
            }
        }
    }

}
public class App2 {


    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        App2 bmiProgramm = new App2();
        Patient patient1 = new Patient("Hubert");
        Patient patient2 = new Patient("Susi");

       patient1.eingabeBmiWerte(new Scanner(System.in));
       patient1.berechnungUndSpeicherungBmiWerte();
       patient1.ausgabeBMIWerte();
       patient2.eingabeBmiWerte(new Scanner(System.in));

    }

}
