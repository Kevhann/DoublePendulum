package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void alkuArvoOnOikeinToString() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
    public void alkuArvoOnOikeinSaldo() {
    assertEquals(1000, kortti.saldo());
    }
    @Test
    public void arvonLataaminenMuuttaaArvoaOikein(){
        kortti.lataaRahaa(555);
        assertEquals("saldo: 15.55", kortti.toString());
    }
    @Test
    public void saldonOttaminenVahentaaArvoa() {
        kortti.otaRahaa(555);
        assertEquals("saldo: 4.45", kortti.toString());
    }
    @Test
    public void saldonOttaminenEiMuutaArvoa() {
        kortti.otaRahaa(1234);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
    public void saldonOttaminenPalauttaaTrue() {
        assertTrue(kortti.otaRahaa(1000));
    }
    @Test
    public void saldonOttaminenPalauttaaFalse() {
        assertFalse(kortti.otaRahaa(1001));
    }
}
