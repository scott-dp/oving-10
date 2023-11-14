package org.example;

import java.util.ArrayList;

public class Meny {
    private ArrayList<Rett> retter = new ArrayList<Rett>();//her finnes alle rettene i menyen

    public void addRett(Rett rett){
        retter.add(rett);
    }

    public int getMenyPris(){
        int totPris=0;
        for(Rett rett:retter){
            totPris+=rett.getPris();
        }
        return totPris;
    }

    public String toString(){
        String returVerdi="Menyen inneholder: \n";

        for(Rett rett:retter){
            returVerdi+=rett.getNavn()+"\n";
        }
        return returVerdi;
    }

}
