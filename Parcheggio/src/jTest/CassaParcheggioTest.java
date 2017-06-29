/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jTest;

import org.junit.Test;
import static org.junit.Assert.*;
import parcheggio.Cassa;

/**
 *
 * @author luca
 */
public class CassaParcheggioTest {
    
    @Test
    public void testCalcolaImporto(){
        Cassa C =new Cassa();
        
        assertEquals(true, C.transazione(4, 4, 4, 4, 4, "carta"));
    }    
}
