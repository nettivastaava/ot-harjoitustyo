
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void alustusOikein() {
        assertTrue(paate.edullisiaLounaitaMyyty()==0);
        assertTrue(paate.maukkaitaLounaitaMyyty()==0);
        assertTrue(paate.kassassaRahaa()==100000);
    }
    
    @Test
    public void syoEdullisestiToimiiRiittavallaRahalla() {
        assertTrue(paate.syoEdullisesti(300)==60);
        assertTrue(paate.kassassaRahaa()==100240);
        
    }
    
    @Test
    public void syoMaukkaastiToimiiRiittavallaRahalla() {
        assertTrue(paate.syoMaukkaasti(400)==0);
        assertTrue(paate.kassassaRahaa()==100400);
    }
    
    @Test
    public void rahatEiRiitaEdulliseen() {
        assertTrue(paate.syoEdullisesti(230)==230);
        assertTrue(paate.kassassaRahaa()==100000);
    }
    
    @Test
    public void rahatEiRiitaMaukkaaseen() {
        assertTrue(paate.syoMaukkaasti(399)==399);
        assertTrue(paate.kassassaRahaa()==100000);
    }
    
    @Test
    public void korttiostoToimiiEdullisella() {
        assertTrue(paate.syoEdullisesti(kortti));
        assertTrue(kortti.saldo()==260);
    }
    
    @Test
    public void korttiostoToimiiMaukkaalla() {
        assertTrue(paate.syoMaukkaasti(kortti));
        assertTrue(kortti.saldo()==100);
    }
    
    @Test
    public void EdullinenOstoKasvattaaMyyntia() {
        paate.syoEdullisesti(kortti);
        assertTrue(paate.edullisiaLounaitaMyyty()==1);
    }
    
    @Test
    public void MaukasOstoKasvattaaMyyntia() {
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.maukkaitaLounaitaMyyty()==1);
    }
    
    @Test
    public void EdullisenOstoEiOnnistuIlmanSaldoa() {
        kortti = new Maksukortti(230);
        
        assertFalse(paate.syoEdullisesti(kortti));
        assertTrue(kortti.saldo()==230);
        assertTrue(paate.edullisiaLounaitaMyyty()==0);
    }
    
    @Test
    public void MaukkaanOstoEiOnnistuIlmanSaldoa() {
        kortti = new Maksukortti(399);
        
        assertFalse(paate.syoMaukkaasti(kortti));
        assertTrue(kortti.saldo()==399);
        assertTrue(paate.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void EdullisenOstoEiMuutaKassanRahamaaraa() {
        paate.syoEdullisesti(kortti);
        
        assertTrue(paate.kassassaRahaa()==100000);
    }
    
    @Test
    public void MaukkaanOstoEiMuutaKassanRahamaaraa() {
        paate.syoMaukkaasti(kortti);
        
        assertTrue(paate.kassassaRahaa()==100000);
    }
    
    @Test
    public void kortinLatausVaikuttaaKortinJaKassanSaldoon() {
        paate.lataaRahaaKortille(kortti, 1000);
        
        assertTrue(paate.kassassaRahaa()==101000);
        assertTrue(kortti.saldo()==1500);
    }
    
    @Test
    public void eiVoiLadatanNegatiivistaSummaa() {
        paate.lataaRahaaKortille(kortti, -1);
        
        assertTrue(paate.kassassaRahaa()==100000);
        assertTrue(kortti.saldo()==500);
    }
}
