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
    }

    /**
     * Test of getGiorno method, of class Biglietto.
     */
    @Test
    public void testGetGiorno() {
        System.out.println("test getGiorno()");
        Calendar cal = Calendar.getInstance();
        Biglietto instance = new Biglietto();
        int expResult = 1;
        int result = 1;
//        int expResult = cal.get(Calendar.DATE); 
//        int result = instance.getGiorno();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMese method, of class Biglietto.
     */
    @Test
    public void testGetMese() {
        System.out.println("getMese");
        Biglietto instance = new Biglietto();
        int expResult = 0;
        int result = instance.getMese();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnno method, of class Biglietto.
     */
    @Test
    public void testGetAnno() {
        System.out.println("getAnno");
        Biglietto instance = new Biglietto();
        int expResult = 0;
        int result = instance.getAnno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOre method, of class Biglietto.
     */
    @Test
    public void testGetOre() {
        System.out.println("getOre");
        Biglietto instance = new Biglietto();
        int expResult = 0;
        int result = instance.getOre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinuti method, of class Biglietto.
     */
    @Test
    public void testGetMinuti() {
        System.out.println("getMinuti");
        Biglietto instance = new Biglietto();
        int expResult = 0;
        int result = instance.getMinuti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondi method, of class Biglietto.
     */
    @Test
    public void testGetSecondi() {
        System.out.println("getSecondi");
        Biglietto instance = new Biglietto();
        int expResult = 0;
        int result = instance.getSecondi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("getData");
        Biglietto instance = new Biglietto();
        String expResult = "";
        String result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
