/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;


public class ConcreteStrategyB implements PagamentoStrategy {

    /**
     * Comportamento che rappresenta la modalità di pagamento con carta di credito.
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param prezzo
     * @return 
     */
    @Override
    public boolean Behavior(int a, int b, int c, int d, int e, int prezzo) {
        System.out.println("Carta di credito!");
        return true;
    }

}
