import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            // 1.
            System.out.println("============== PRIMA FRAZIONE ==============");
            System.out.println("Numeratore: ");
            int num = sc.nextInt();
            System.out.println("Denominatore: ");
            sc.nextLine(); // Pulizia buffer
            int den = sc.nextInt();
            Frazione f1 = new Frazione(num,den);

            // 2.
            System.out.println("============== SECONDA FRAZIONE ==============");
            System.out.println("Numeratore: ");
            sc.nextLine(); // Pulizia buffer
            num = sc.nextInt();
            System.out.println("Denominatore: ");
            sc.nextLine(); // Pulizia buffer
            den = sc.nextInt();
            Frazione f2 = new Frazione(num,den);

            // Stampe iniziali
            System.out.println("Prima Frazione: " + f1.stampa());
            Frazione fSemp1 = f1.semplificazione();
            System.out.println("Prima frazione semplificata: " + fSemp1.stampa() + "\n\tValore: "+f1.calcola());

            System.out.println("Seconda Frazione: " + f2.stampa());
            Frazione fSemp2 = f2.semplificazione();
            System.out.println("Seconda frazione semplificata: " + fSemp2.stampa()+ "\n\tValore: "+f2.calcola());

            // Operazioni
            System.out.println("Moltiplicazione: " + f1.moltiplicazione(f2).stampa());
            System.out.println("Somma: " + f1.somma(f2).stampa());
            System.out.println("Divisione: " + f1.divisione(f2).stampa());
            System.out.println("Sottrazione: " + f1.differenza(f2).stampa());

            // Confronti
            boolean appoggio = f1.equals(f2);
            System.out.println("La prima frazione è uguale alla seconda? " + appoggio);

            if(!appoggio){
                System.out.println("La prima frazione è maggiore della seconda? " + f1.isGreat(f2));
                System.out.println("La prima frazione è minore della seconda? " + f1.isLess(f2));
            }
        }catch(DenominatoreInvalidoException e){
            System.out.println(e.getMessage());
        }

    }
}