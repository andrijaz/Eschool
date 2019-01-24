package com.example.eskola.modeli;

import java.util.ArrayList;

public class Osoba {
    private String tipNaloga;
    private String ime;
    private String prezime;
    private String email;
    private String brTelefona;
    private String jmbg;

    public Osoba() {

    }

    public Osoba(String tipNaloga, String ime, String prezime, String email, String brTelefona, String jmbg) {
        this.tipNaloga = tipNaloga;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brTelefona = brTelefona;
        this.jmbg = jmbg;
    }

    public String getTipNaloga() {
        return tipNaloga;
    }

    public void setTipNaloga(String tipNaloga) {
        this.tipNaloga = tipNaloga;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public static ArrayList<Osoba> getListOfFakeUsers() {
        ArrayList<Osoba> nalozi = new ArrayList<>();
        nalozi.add(new Osoba("Direktor", "Petar", "Petrovic", "ppetrovic@eskola.edu.rs", "06411223344", "1234567891179"));
        nalozi.add(new Osoba("Profesor", "Milica", "Zikic", "mzikic@eskola.edu.rs", "0652315978", "8901256789"));
        nalozi.add(new Osoba("Profesor", "Uros", "Lazic", "ulazic@eskola.edu.rs", "0694355795", "90456877325"));
        nalozi.add(new Osoba("Ucenik", "Stefan", "Rovic", "srovic@eskola.edu.rs", "0633311154", "60879501234"));
        nalozi.add(new Osoba("Ucenik", "Milos", "Maric", "mmaric@eskola.edu.rs", "0115578224", "24757856427456"));
        nalozi.add(new Osoba("Roditelj", "Milica", "Markovic", "mmarkovic@eskola.edu.rs", "064555333", "65458780517"));

        return nalozi;
    } public static ArrayList<Osoba> getListOfFakeUcenici() {
        ArrayList<Osoba> nalozi = new ArrayList<>();
        nalozi.add(new Osoba("Ucenik", "Milica", "Jovic", "mjovic@eskola.edu.rs", "0652311278", "8901256789"));
        nalozi.add(new Osoba("Ucenik", "Uros", "Lazic", "ulazic@eskola.edu.rs", "0694355795", "90456877325"));
        nalozi.add(new Osoba("Ucenik", "Pavle", "Joksovic", "srovic@eskola.edu.rs", "0633311154", "60879501234"));
        nalozi.add(new Osoba("Ucenik", "Andrija", "Zivkovic", "androijaz@eskola.edu.rs", "0115578224", "24757856427456"));
        nalozi.add(new Osoba("Ucenik", "Dusan", "Ivanovic", "idusan@eskola.edu.rs", "064555333", "65458780517"));

        return nalozi;
    }
}
