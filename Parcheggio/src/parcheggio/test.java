/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

/**
 *
 * @author luca
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parcheggio P = new Parcheggio();
        P.Ingresso();
        P.Ingresso();
        System.out.println("-----\tstampa attivi");
        P.stampaBigliettiAttivi();
        System.out.println("-----\tcalcola importo");
        P.Pagamento(1);
        System.out.println("-----\tstampa attivi");
        P.stampaBigliettiAttivi();
        System.out.println("-----\tstampa uscita");
        P.stampaBigliettiUscita();
        System.out.println("-----\tcalcola importo");
        P.Pagamento(1);
        System.out.println("-----\tuscita");
        P.Uscita(1);
        System.out.println("-----\tstampa uscita");
        P.stampaBigliettiUscita();
        System.out.println("-----\tstampa registro");
        P.stampaRegistroBiglietti();
    }
    
}
