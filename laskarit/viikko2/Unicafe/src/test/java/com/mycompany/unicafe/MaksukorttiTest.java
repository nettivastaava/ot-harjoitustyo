package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikeinAlussa() {
        assertTrue(kortti.saldo()==10);
    }
    
    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(5);
        assertTrue(kortti.saldo()==15);
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo()==5);
    }
    
    @Test
    public void saldoaEiVoiYlittaa() {
        kortti.otaRahaa(11);
        assertTrue(kortti.saldo()==10);
    }
    
    @Test
    public void riittavatkoRahat() {
        assertTrue(kortti.otaRahaa(3));
    }
    
    @Test
    public void tulosteOikein() {
        assertEquals(kortti.toString(), "saldo: 0.10");
    }
}
