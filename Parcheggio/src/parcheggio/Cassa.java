/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.util.Calendar;

/**
 *
 * @author luca
 */
public class Cassa {
    private int giorno=0;
    private int mese=0;
    private int anno=0;
    private int ore=0;
    private int minuti=0;
    private int secondi=0;
    private String data = null;
    private String ora = null;
    private int prezzo=0;
    private int prezzoOrario = 1; //prezzo parcheggio: 1€ all'ora
    private int ammount=0;
    
    public int calcolaImporto(Biglietto big){
        
        
        getDate();// vanno bene anche qua basta che si usino nello stesso momento
        getHours();//calcolaimporto() e transazione()
       
        int orepermanenza=ore-big.getOre();
        int minpermanenza=minuti-big.getMinuti();
        int annipermanenza=anno-big.getAnno();
        int mesipermanenza=mese-big.getMese();
        int giornipermanenza=giorno-big.getGiorno();
        
        if(annipermanenza!=0){return prezzo=750*annipermanenza;}
        if(mesipermanenza!=0){return prezzo=100*mesipermanenza;}
        if(giornipermanenza>=7){return 20*(giornipermanenza/7);}
        
        if(minpermanenza==0){
            System.out.println("Ore di permanenza: "+orepermanenza);
            if(orepermanenza!=0){
                return prezzo=orepermanenza*prezzoOrario;
            }else{
                System.out.println("Ore di permanenza nulle, ritorno prezzo default 4,04 €");
                return prezzo=404;
            }
        }else{
            return prezzo=(orepermanenza+1)*prezzoOrario;
        }
        
        
    }
    
    private void getDate(){
        Calendar cal =  Calendar.getInstance();
        giorno =cal.get(Calendar.DATE);
        mese = cal.get(Calendar.MONTH) +1;
        anno =cal.get(Calendar.YEAR);
        
        data =  giorno +"/"+ mese +"/"+ anno;
    }

    private void getHours() {
        Calendar cal =  Calendar.getInstance();
        ore=cal.get(Calendar.HOUR);
        minuti=cal.get(Calendar.MINUTE);
        secondi=cal.get(Calendar.SECOND);
        
        ora = cal.get(Calendar.HOUR) + ":"+ cal.get(Calendar.MINUTE) + "." + cal.get(Calendar.SECOND);
    }
    //accetta solo banconote da 5      10     20     50     100
    public boolean transazione(int a, int b, int c, int d, int e){
        
        int cinque = a;
        int dieci = b;
        int venti = c;
        int cinquanta = d;
        int cento = e;
        
        int somma = 100*cento+50*cinquanta+20*venti+10*dieci+5*cinque;
        //System.out.println("hai inserito: "+somma);
        int centinaia = somma/100;
        int decine = (somma-centinaia*100)/10;
        int unita = (somma - centinaia*100 - decine*10);
        System.out.println("Importo inserito: "+centinaia+","+decine+unita+"€");
        if(somma<=prezzo){
            System.out.println("denaro insufficiente. rieseguire la transazione.");
            return false;
        }else{
            //convalida!(viene fatta in parcheggio) e dai resto mostra messaggio tempo di uscita dal parcheggio
            this.ammount+=prezzo;
            int resto = somma-prezzo;
            
            int centinaiaR = resto/100;
            int decineR = (resto-centinaiaR*100)/10;
            int unitaR = (resto - centinaiaR*100 - decineR*10);
            
            //System.out.println("Totale resto: "+resto);
            System.out.println("Resto: "+centinaiaR+","+decineR+unitaR+"€");
            int ce=0;
            for(int i=100;i<=resto;i=i+100){ ce++; }
            resto=resto-(100*ce);
            int ci=0;
            for(int o=50;o<=resto;o=o+50){ ci++; }
            resto=resto-(50*ci);
            int ve=0;
            for(int p=20;p<=resto;p=p+20){ ve++; }
            resto=resto-(20*ve);
            int di=0;
            for(int q=10;q<=resto;q=q+10){ di++; }
            resto=resto-(10*di);
            int cin=0;
            for(int w=5;w<=resto;w=w+5){ cin++;}
            resto=resto-(5*cin);
            int du=0;
            for(int f=2;f<=resto;f=f+2){ du++; }
            resto=resto-(2*du);
            int un=0;
            for(int g=1;g<=resto;g=g+1){ un++; }
            
            System.out.println("1 €: "+ce+"\n50 cent: "+ci+"\n20 cent: "+ ve+ "\n10 cent: "+di+"\n5 cent: " + cin+"\n2 cent: "+du+"\n1 cent: "+ un);
            return true;
        }
    }
    
    public String getDataCassa(){
            return data;
        }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getPrezzoOrario() {
        return prezzoOrario = 1;
    }
    
    
    
    
    
    
    
    
    
}
