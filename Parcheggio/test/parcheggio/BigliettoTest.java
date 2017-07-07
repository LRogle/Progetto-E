/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcheggio;

import java.util.Calendar;
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
public class BigliettoTest {
    
    public BigliettoTest() {
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
     * Test of getCodice method, of class Biglietto.
     */
    @Test
    public void testGetCodice() {
        System.out.println("getCodice");
        Biglietto instance = new Biglietto();
        int expResult = 1;
        int result = instance.getCodice();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGiorno method, of class Biglietto.
     */
    @Test
    public void testGetGiorno() {
        System.out.println("test metodo: getGiorno()");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int expResult = cal.get(Calendar.DATE); 
        int result = instance.getGiorno();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMese method, of class Biglietto.
     */
    @Test
    public void testGetMese() {
        System.out.println("test metodo: getMese()");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int expResult = cal.get(Calendar.MONTH) +1;
        int result = instance.getMese();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnno method, of class Biglietto.
     */
    @Test
    public void testGetAnno() {
        System.out.println("test metodo: getAnno()");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int expResult = cal.get(Calendar.YEAR);
        int result = instance.getAnno();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOre method, of class Biglietto.
     */
    @Test
    public void testGetOre() {
        System.out.println("test metodo: getOre()");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int expResult = cal.get(Calendar.HOUR);
        int result = instance.getOre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinuti method, of class Biglietto.
     */
    @Test
    public void testGetMinuti() {
        System.out.println("test metodo: getMinuti()");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int expResult = cal.get(Calendar.MINUTE);
        int result = instance.getMinuti();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSecondi method, of class Biglietto.
     */
    @Test
    public void testGetSecondi() {
        System.out.println("test metodo: getSecondi()");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int expResult = cal.get(Calendar.SECOND);;
        int result = instance.getSecondi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConvalida method, of class Biglietto.
     */
    @Test
    public void testSetConvalida() {
        System.out.println("setConvalida");
        boolean x = false;
        Biglietto instance = new Biglietto();
        instance.setConvalida(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataConvalida method, of class Biglietto.
     */
    @Test
    public void testSetDataConvalida() {
        System.out.println("setDataConvalida");
        String data = "";
        Biglietto instance = new Biglietto();
        instance.setDataConvalida(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataConvalida method, of class Biglietto.
     */
    @Test
    public void testGetDataConvalida() {
        System.out.println("getDataConvalida");
        Biglietto instance = new Biglietto();
        String expResult = "";
        String result = instance.getDataConvalida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Biglietto.
     */
    @Test
    public void testGetData() {
        System.out.println("test metodo: getData()");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int giorno = cal.get(Calendar.DATE);
        int mese = cal.get(Calendar.MONTH) +1;
        int anno = cal.get(Calendar.YEAR);
        String expResult = giorno +"/"+ mese +"/"+ anno;
        String result = instance.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOreEMinutiConvalida method, of class Biglietto.
     */
    @Test
    public void testSetOreEMinutiConvalida() {
        System.out.println("setOreEMinutiConvalida");
        int o = 0;
        int m = 0;
        Biglietto instance = new Biglietto();
        instance.setOreEMinutiConvalida(o, m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Biglietto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Biglietto instance = new Biglietto();
        Calendar cal = Calendar.getInstance();
        int giorno = cal.get(Calendar.DATE);
        int mese = cal.get(Calendar.MONTH) +1;
        int anno = cal.get(Calendar.YEAR);
        int ora = cal.get(Calendar.HOUR);
        String data = giorno +"/"+ mese +"/"+ anno;
        String expResult = "Biglietto{" + " codice=" + 5 + ", data=" + data + ", ora=" + ora + " "+ '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
