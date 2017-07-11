/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteadi;

/**
 *
 * @author husey
 */
public class Personel {
    private int personelId,maas;
    private String personelAd,personelSoyad;

    public Personel(int personelId, int maas, String personelAd, String personelSoyad) {
        this.personelId = personelId;
        this.maas = maas;
        this.personelAd = personelAd;
        this.personelSoyad = personelSoyad;
    }
    
    

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public String getPersonelAd() {
        return personelAd;
    }

    public void setPersonelAd(String personelAd) {
        this.personelAd = personelAd;
    }

    public String getPersonelSoyad() {
        return personelSoyad;
    }

    public void setPersonelSoyad(String personelSoyad) {
        this.personelSoyad = personelSoyad;
    }
    
}
