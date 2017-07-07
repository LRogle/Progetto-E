/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aench
 */
public class CassaTest {
    
    public CassaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of calcolaImporto method, of class Cassa.
     */
    @Test
    public void testCalcolaImporto() {
        System.out.println("-------------------------------------------------");
        System.out.println("Test del metodo:\tcalcolaImporto()");
        System.out.println("-------------------------------------------------");
        Biglietto biglietto = new Biglietto();
        Cassa instance = new Cassa();
        System.out.println("Caso di default: tempo sosta minore di 10 min");
        System.out.println("START");
        int expResult = 404;
        int result = instance.calcolaImporto(biglietto);
        assertEquals(expResult, result);
        System.out.println("END");
    }

    /**
     * Test of transazione method, of class Cassa.
     */
    @Test
    public void testTransazione() {
        System.out.println("-------------------------------------------------");
        System.out.println("Test del metodo:\ttransazione()");
        System.out.println("-------------------------------------------------");
        Cassa instance = new Cassa();
        boolean expResult = true;
        
        System.out.println("---\tContanti:");
        String metodo = "contanti";
            System.out.println("  Caso in cui prezzo e' 0 (di default) e viene inserito 0");
            System.out.println("START");
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            boolean result = instance.transazione(a, b, c, d, e, metodo);
            assertEquals(expResult, result);
            System.out.println("END");
            System.out.println("  Caso in cui prezzo e' 38 (1 di ogni unita')");
            System.out.println("START");
            instance.setPrezzo(38);
            a = 1;
            b = 1;
            c = 1;
            d = 1;
            e = 1;
            result = instance.transazione(a, b, c, d, e, metodo);
            assertEquals(expResult, result);
            System.out.println("END");
            System.out.println("  Caso in cui importo inserito e' minore del prezzo");
            System.out.println("START");
            a = 1;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            result = !(instance.transazione(a, b, c, d, e, metodo));
            assertEquals(expResult, result);
            System.out.println("END");
            System.out.println("---\tCarta:");
            metodo = "carta";
            result = instance.transazione(a, b, c, d, e, metodo);
            assertEquals(expResult, result);
    }
  
}
