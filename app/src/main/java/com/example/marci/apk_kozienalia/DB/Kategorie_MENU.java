package com.example.marci.apk_kozienalia.DB;

/**
 * Created by marci on 10.03.2018.
 */

public class Kategorie_MENU {
    private String Nazwa_kat;
    private String Obrazek;

    public Kategorie_MENU() {
    }

    public Kategorie_MENU(String nazwa_kat, String obrazek) {
        Nazwa_kat = nazwa_kat;
        Obrazek = obrazek;
    }

    public String getNazwa_kat() {
        return Nazwa_kat;
    }

    public void setNazwa_kat(String nazwa_kat) {
        Nazwa_kat = nazwa_kat;
    }

    public String getObrazek() {
        return Obrazek;
    }

    public void setObrazek(String obrazek) {
        Obrazek = obrazek;
    }
}
