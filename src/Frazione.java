import java.math.BigInteger;
import java.util.ArrayList;

public class Frazione implements Operatore{
    private int numeratore;
    private int denominatore;

    // Costruttore non parametrizzato
    public Frazione(){
        this.numeratore = 0;
        this.denominatore = 1;
    }
    // Costruttore parametrizzato - gestione eccezione personalizzata
    public Frazione(int numeratore, int denominatore) throws DenominatoreInvalidoException {
        if(denominatore == 0)
            throw new DenominatoreInvalidoException();

        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    // Metodi dell'interfaccia

    // 1. Calcola
    public float calcola(){
        return (float)this.numeratore / (float)this.denominatore;
    }

    // 2. Stampa
    public String stampa(){
        return this.numeratore + "/" + this.denominatore;
    }

    // 3. toString
    public String toString(){
        String msg = "";
        msg += "Nominatore: " + this.numeratore + "\nDenominatore:" + this.denominatore;
        msg += "\nValore reale: " + this.calcola();
        return msg;
    }

    // Metodi consegna

    // Somma
    // Ragionamento: faccio la somma non semplificata (no mcd) e poi utilizzo il metodo semplifica
    public Frazione somma(Frazione o)throws DenominatoreInvalidoException{
        int d = this.denominatore * o.denominatore;
        int n1 = (d/this.denominatore)*this.numeratore;
        int n2 = (d/o.denominatore)*o.numeratore;
        Frazione f3 = new Frazione(n1+n2, d);

        return f3.semplificazione();
    }

    // Moltiplicazione
    public Frazione moltiplicazione(Frazione o) throws DenominatoreInvalidoException{
        // Semplice moltiplicazione
        int n = this.numeratore * o.numeratore;
        int d = this.denominatore * o.denominatore;
        Frazione f3 = new Frazione(n,d);
        // Semplifico prima di ritornare il risultato
        return f3.semplificazione();
    }

    // Differenza
    public Frazione differenza(Frazione o) throws DenominatoreInvalidoException{
        int d = this.denominatore * o.denominatore;
        int n1 = (d/this.denominatore)*this.numeratore;
        int n2 = (d/o.denominatore)*o.numeratore;
        Frazione f3 = new Frazione(n1-n2, d);
        return f3.semplificazione();
    }

    // Divisione
    public Frazione divisione(Frazione o)throws DenominatoreInvalidoException{
        // Semplice divisione (inversione di moltiplicazione - utilizzabile anche il metodo inversione())
        int n = this.numeratore * o.denominatore;
        int d = this.denominatore * o.numeratore;
        Frazione f3 = new Frazione(n,d);

        // Semplifico prima di ritornare il risultato
        return f3.semplificazione();
    }

    // Semplificazione
    public Frazione semplificazione()throws DenominatoreInvalidoException{
        // appoggio
        Frazione appoggio = new Frazione(this.numeratore, this.denominatore);

        if(appoggio.denominatore>=appoggio.numeratore){
            // Caso 1: Denominatore come multiplo di numeratore
            if(appoggio.denominatore%appoggio.numeratore==0){
                appoggio.denominatore /= appoggio.numeratore;
                appoggio.numeratore /= appoggio.numeratore;
            }
            // Caso 2: Fattorizzazione
            else{
                int i = 2;
                while(i<(appoggio.numeratore/2)){
                    if(appoggio.denominatore%i == 0 && appoggio.numeratore%i ==0){
                        appoggio.denominatore /= i;
                        appoggio.numeratore /= i;
                    }
                    else
                        i++;
                }
            }
        }
        else{
            // Caso 1: Numeratore come multiplo di denominatore
            if(appoggio.numeratore%appoggio.denominatore==0){
                appoggio.numeratore /= appoggio.denominatore;
                appoggio.denominatore /= appoggio.denominatore;
            }
            // Caso 2: Fattorizzazione
            else{
                int i = 2;
                while(i<(appoggio.denominatore/2)){
                    if(appoggio.denominatore%i == 0 && appoggio.numeratore%i ==0){
                        appoggio.denominatore /= i;
                        appoggio.numeratore /= i;
                    }
                    else
                        i++;
                }
            }
        }
        return appoggio;
    }

    // Inversione
    public Frazione inversione()throws DenominatoreInvalidoException{
       return new Frazione(this.denominatore, this.numeratore);
    }

    // Extra
    // Uguaglianza
    public boolean equals(Frazione o){
        return (this.calcola() == o.calcola());
    }

    // Maggiore rispetto alla frazione in parametro
    public boolean isGreat(Frazione o){
        return (this.calcola() > o.calcola());
    }

    // Minore rispetto alla frazione in parametro
    public boolean isLess(Frazione o) {
        return (this.calcola() < o.calcola());
    }
}
