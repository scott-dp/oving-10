package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MenyRegister register=new MenyRegister();

        boolean fortsett=true;

        while(fortsett){
            String readChoice= JOptionPane.showInputDialog("Reg ny rett(r), Finne en rett ved navn(n), finn retter av en type(t), reg ny meny(m), finn menyer med pris innenfor intervall(i), avslutt(x)");
            switch (readChoice){
                case "r":
                    register.addRett();
                    break;
                case "n":
                    String readNavn=JOptionPane.showInputDialog("Skriv inn navnet på retten");
                    Rett rett=register.finnRett(readNavn);
                    JOptionPane.showMessageDialog(null,rett.toString());
                    break;
                case "t":
                    String readType=JOptionPane.showInputDialog("Skriv inn typen");

                    ArrayList<Rett> retts=register.finnRetterAvType(readType);

                    for(Rett retten:retts){
                        JOptionPane.showMessageDialog(null,retten.toString());
                    }
                    break;
                case "m":
                    register.lagMeny();
                    break;
                case "i":
                    int pris1=Integer.parseInt(JOptionPane.showInputDialog("Skriv inn første pris"));
                    int pris2=Integer.parseInt(JOptionPane.showInputDialog("Skriv inn andre pris"));
                    register.finnMenyerMedPrisIntervall(pris1,pris2);
                    break;
                case "x":
                    fortsett=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Du skrev ikke inn gyldig inp");
            }
        }
    }
}