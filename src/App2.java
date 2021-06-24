import java.util.Scanner;



public class App2 {
     class Patient{

         String name;

         double [] bmiWerte = new double [1000];
         float aktGewicht = 0;
         float gewicht = 0;
         float groesse = 0;
         float minBMI = 0;
         float schrittGewicht = .5f;
         int anzWoche = 0;
    }

     static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        App2 bmiProgramm=new App2();
        Patient patient1=bmiProgramm.new Patient();
        Patient patient2=bmiProgramm.new Patient();

        bmiProgramm.eingabeBmiWerte(patient1);
        bmiProgramm.eingabeBmiWerte(patient2);
        bmiProgramm.berechnungUndSpeicherungBmiWerte(patient1);
        bmiProgramm.ausgabeBMIWerte(patient1);
        scanner.close();

    }
    private void eingabeBmiWerte(Patient p) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BMI Rechner v 1.0");
        System.out.println("Bitte Ihren Namen angeben: ");
        p.name = scanner.nextLine();
        System.out.println("Bitte Ihr Startgewicht in kg eingeben: ");
        p.gewicht = Float.parseFloat(scanner.nextLine());
        System.out.println("Bitte Ihre Körpergröße in m angeben: ");
        p.groesse = (float) Double.parseDouble(scanner.nextLine());
        System.out.println("Bitte Wunsch-BMI angeben: ");
        p.minBMI = (float) Double.parseDouble(scanner.nextLine());
        System.out.println("Bitte Gewichtsabnahme pro Woche in Kg eingeben (Default: 0.5 kg) angeben: ");


        String eingabe = "";
        eingabe = scanner.nextLine();
        if (! eingabe.isEmpty()) {
            p.schrittGewicht = Float.parseFloat(eingabe);
        }


        p.aktGewicht = p.gewicht;



    }

    private void ausgabeBMIWerte(Patient p) {

        System.out.println("Der Wunsch-Bmi wird nach " + (p.anzWoche - 1) + " Wochen erreicht.");



        for (int i = 0; i < p.bmiWerte.length; i++) {
            if (p.bmiWerte[i] != 0.0) {
                System.out.printf("%-10s\t %5.2f\n", i == 0 ? "Start": "Woche " + i, p.bmiWerte[i]);
            }
        }
    }

    private void berechnungUndSpeicherungBmiWerte(Patient p) {
        double bmi = 0;


        do {
            bmi = p.aktGewicht / Math.pow(p.groesse,2) ;
            String ergebnis =
                    bmi < 19.0 ?
                            "Untergewicht":
                            bmi > 25 ?
                                    "Übergewicht":
                                    "Normalgewicht";



            System.out.printf("%5s\t%3.2f\t%2.2f\t%s\n", p.anzWoche == 0?"": p.anzWoche, p.aktGewicht, bmi, ergebnis);
            p.aktGewicht -= p.schrittGewicht;
            p.bmiWerte[p.anzWoche++] = bmi;
        } while(bmi >= p.minBMI);
    }
}