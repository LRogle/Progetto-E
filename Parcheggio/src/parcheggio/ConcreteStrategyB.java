/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;


public class ConcreteStrategyB implements PagamentoStrategy {

    @Override
    public boolean Behavior(int a, int b, int c, int d, int e, int prezzo) {
        System.out.println("Carta di credito!");
        return true;
    }

    @Override
    public String erogaResto(int somma, int prezzo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
