package org.example;
import javax.swing.JOptionPane;

import java.util.ArrayList;

public class MenyRegister {
    private ArrayList<Rett> retter = new ArrayList<Rett>();//her finnes alle rettene
    private ArrayList<Meny> menyer = new ArrayList<Meny>();//her finnes alle menyene
    public void addRett() {
        String readNavn=JOptionPane.showInputDialog("Skriv inn navnet til retten");
        String readType=JOptionPane.showInputDialog("Skriv inn type rett");
        String readOppskrift=JOptionPane.showInputDialog("Skriv inn oppskriften");
        int readPris=Integer.parseInt(JOptionPane.showInputDialog("Skriv inn prisen"));

        Rett nyRett=new Rett(readNavn,readType,readOppskrift,readPris);

        retter.add(nyRett);
    }

    public Rett finnRett(String navn){
        for(Rett rett : retter) {
            if(rett.getNavn().equals(navn)) {
                return rett;
            }
        }
        JOptionPane.showMessageDialog(null,"Fant ikke retten");
        return null;
    }

    public ArrayList<Rett> finnRetterAvType(String type){

        ArrayList<Rett> retterSammeType = new ArrayList<>();

        for (Rett rett : retter){
            if(rett.getType().equals(type)){
                retterSammeType.add(rett);
            }
        }

        if(retterSammeType.isEmpty()){
            JOptionPane.showMessageDialog(null,"Fantes ingen retter av typen "+type);
            return null;
        }else{
            return retterSammeType;
        }
    }

    public void lagMeny(){

        boolean fortsett=true;

        Meny nyMeny=new Meny();

        while(fortsett){
            String readFlereRetter=JOptionPane.showInputDialog("Vil du registrere flere retter til menyen?(j/n)");
            switch (readFlereRetter){
                case "j":
                    String readRettNavn=JOptionPane.showInputDialog("Skriv inn navnet på retten");

                    for(Rett rett:retter){
                        if (rett.getNavn().equals(readRettNavn)){
                            nyMeny.addRett(rett);
                            break;
                        }
                    }
                    break;
                case "n":
                    fortsett=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Du skrev ikke inn 'j' eller 'n'");
            }

        }

        menyer.add(nyMeny);
    }

    public void finnMenyerMedPrisIntervall(int pris1, int pris2){
        ArrayList<Meny> menyerMedRiktigPris=new ArrayList<>();

        for(Meny meny:menyer){
            if(meny.getMenyPris()>pris1 && meny.getMenyPris()<pris2){
                menyerMedRiktigPris.add(meny);
            }
        }

        if (menyerMedRiktigPris.isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingen menyer i den prisklassen");
        }else{
            for(Meny meny : menyerMedRiktigPris){
                JOptionPane.showMessageDialog(null,meny.toString());
            }
        }
    }
}