/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

/**
 *
 * @author aench
 */
public class ConcreteStrategyA implements PagamentoStrategy {

    @Override
    public boolean Behavior(int a, int b, int c, int d, int e,int prezzo) {
        //accetta solo banconote da 5      10     20     50     100
        int cinque = a;
        int dieci = b;
        int venti = c;
        int cinquanta = d;
        int uno = e;
        int somma = 0;
        somma = 100*uno+50*cinquanta+20*venti+10*dieci+5*cinque;
        //System.out.println("hai inserito: "+somma);
        int centinaia = somma/100;
        int decine = (somma-centinaia*100)/10;
        int unita = (somma - centinaia*100 - decine*10);
        System.out.println("Importo inserito: "+centinaia+","+decine+unita+"€");
            if(somma<=prezzo){
                System.out.println("denaro insufficiente. rieseguire la transazione.");
                return false;
            }else{
                erogaResto(somma,prezzo);
                return true;        
        }
        
    }
    
    public void erogaResto(int somma, int prezzo){    
        int resto = somma-prezzo;
            
        int centinaiaR = resto/100;
        int decineR = (resto-centinaiaR*100)/10;
        int unitaR = (resto - centinaiaR*100 - decineR*10);
            
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
    }
    
}
