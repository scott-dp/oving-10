package org.example;

public class Rett {
    private String navn;
    private String type;
    private String oppskrift;
    private int pris;

    public Rett(String navn, String type, String oppskrift, int pris) {
        this.navn = navn;
        this.type = type;
        this.oppskrift = oppskrift;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public String getType() {
        return type;
    }

    public String getOppskrift() {
        return oppskrift;
    }

    public int getPris() {
        return pris;
    }

    public String toString(){
        String returVerdi="Rett: "+this.getNavn()+" type:"+this.getType()+" oppskrift:"+this.getOppskrift()+" pris:"+this.getPris();
        return returVerdi;
    }
}
