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
public interface PagamentoStrategy {
    public boolean Behavior(int a, int b, int c, int d, int e,int prezzo);
    public String erogaResto(int somma, int prezzo);
    public int getRestoErogato();
}

