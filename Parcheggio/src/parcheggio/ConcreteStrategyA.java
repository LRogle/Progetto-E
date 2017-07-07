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
        int uno = a;//1€
        int due = b;//2€
        int cinque = c;//5€
        int dieci = d;//10€
        int venti = e;//20€
        int somma;

        somma = 20*venti+10*dieci+5*cinque+2*due+1*uno;
        System.out.println("hai inserito: "+somma);
        
        if(somma < prezzo){
            System.out.println("denaro insufficiente. rieseguire la transazione.");
            return false;
        }else{
            erogaResto(somma,prezzo);
            return true;        
        }
        
    }

    public void erogaResto(int somma, int prezzo) { 
        int resto = somma-prezzo;

        int resto20=0;
            for(int i=20;i<=resto;i=i+20){ resto20++; }
            resto=resto-(20*resto20);
        int resto10=0;
            for(int o=10;o<=resto;o=o+10){ resto10++; }
            resto=resto-(10*resto10);
        int resto5=0;
            for(int p=5;p<=resto;p=p+5){ resto5++; }
            resto=resto-(5*resto5);
        int resto2=0;
            for(int q=2;q<=resto;q=q+2){ resto2++; }
            resto=resto-(2*resto2);
        int resto1=0;
            for(int w=1;w<=resto;w=w+1){ resto1++;}
            resto=resto-(1*resto1);
            
        System.out.println("\n20 €: "+resto20+"\n10 €: "+resto10+"\n5 €: "+ resto5+ "\n2 €: "+resto2+"\n1 €: " + resto1);

    }

    

}
 
