/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevhann
 */
public class KassapaateTest {
    
    public KassapaateTest() {
    }
    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti rahaton;
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1300);
        rahaton = new Maksukortti(200);
    }   
    @Test
    public void kassanAlkuArvoOnOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void myyntienAlkuArvoOnOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kateisostoToimiiEdullisesti() {
        assertEquals(260,kassa.syoEdullisesti(500));
        assertEquals(0,kassa.syoEdullisesti(240));
        assertEquals(100480,kassa.kassassaRahaa());
        assertEquals(-240,kassa.syoEdullisesti(-240));
        assertEquals(100480,kassa.kassassaRahaa());
    }
    @Test
    public void kateisostoToimiiMaukkaasti() {
        assertEquals(100,kassa.syoMaukkaasti(500));
        assertEquals(0,kassa.syoMaukkaasti(400));
        assertEquals(100800,kassa.kassassaRahaa());
        assertEquals(-400,kassa.syoMaukkaasti(-400));
        assertEquals(100800,kassa.kassassaRahaa());
    }
    @Test
    public void kateisostoEdullisetKasvaa() {
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);
        assertEquals(2,kassa.edullisiaLounaitaMyyty());
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);
        assertEquals(6,kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void kateisostoMaukkaatKasvaa() {
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(500);
        assertEquals(2,kassa.maukkaitaLounaitaMyyty());
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(500);
        assertEquals(5,kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void kateisostoIlmanRahaaEdullisestiEiMuutosta() {
        assertEquals(220,kassa.syoEdullisesti(220));
        assertEquals(100000,kassa.kassassaRahaa());
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void kateisostoIlmanRahaaMaukkaastiEiMuutosta() {
        assertEquals(350,kassa.syoMaukkaasti(350));
        assertEquals(100000,kassa.kassassaRahaa());
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void korttiostoToimiiEdullisesti() {
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(100000,kassa.kassassaRahaa());
        assertEquals(1060,kortti.saldo());
    }
    @Test
    public void korttiostoToimiiMaukkaasti() {
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(100000,kassa.kassassaRahaa());
        assertEquals(900,kortti.saldo());
    }
    @Test
    public void korttiostoEdullisetKasvaa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(2,kassa.edullisiaLounaitaMyyty());
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(4,kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void korttiostoMaukkaatKasvaa() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(2,kassa.maukkaitaLounaitaMyyty());
        kassa.syoMaukkaasti(kortti);
        assertEquals(3,kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void korttiostoIlmanRahaaEdullisestiEiMuutosta() {
        assertFalse(kassa.syoEdullisesti(rahaton));
        assertEquals(100000,kassa.kassassaRahaa());
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        assertEquals(200,rahaton.saldo());
    }
    @Test
    public void korttiostoIlmanRahaaMaukkaastiEiMuutosta() {
        assertFalse(kassa.syoMaukkaasti(rahaton));
        assertEquals(100000,kassa.kassassaRahaa());
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
        assertEquals(200,rahaton.saldo());
    }
    @Test
    public void kortinLataaminenNostaaKassanJaKortinArvoa(){
        kassa.lataaRahaaKortille(kortti, 1234);
        assertEquals(2534,kortti.saldo());
        assertEquals(101234,kassa.kassassaRahaa());
    }
    @Test
    public void negatiivisenArvonLataaminen() {
        kassa.lataaRahaaKortille(kortti, -1234);
        assertEquals(1300,kortti.saldo());
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    
    
    

}
