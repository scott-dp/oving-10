import java.util.ArrayList;
import java.util.Collections;

public class ArrangementRegister {
    ArrayList<Arrangement> arrangementer=new ArrayList<>();

    public void leggTilArrangement(Arrangement arrangement){
        arrangementer.add(arrangement);
    }

    public ArrayList<Arrangement> finnArrangementSted(String sted){
        ArrayList<Arrangement> valgteArrangementer=new ArrayList<>();
        for(Arrangement a:arrangementer){
            if(a.getSted().equals(sted)){
                valgteArrangementer.add(a);
            }
        }
        return valgteArrangementer;
    }

    public ArrayList<Arrangement> finnArrangementDato(int dato){//år måned dag, eks 20021003-3okt 2002
        ArrayList<Arrangement> valgteArrangementer=new ArrayList<>();

        String datoString=String.valueOf(dato);


        for(Arrangement a:arrangementer){
            String elementDato=String.valueOf(a.getTidspunkt());
            if(datoString.equals(elementDato.substring(0,9))){
                valgteArrangementer.add(a);
            }
        }

        return valgteArrangementer;
    }

    public ArrayList<Arrangement> arrangementerIIntervall(int dato1, int dato2){//dato1 er første, dato2 er etter
        ArrayList<Arrangement> valgteArrangementer=new ArrayList<>();

        for(Arrangement a:arrangementer){
            //finner kun datoen som int
            String elementTidspunkt=String.valueOf(a.getTidspunkt());
            int elementDato=Integer.parseInt(elementTidspunkt.substring(0,9));

            if (elementDato>=dato1 && elementDato<=dato2){//sjekker om det er mellom dato1 og 2
                valgteArrangementer.add(a);
            }
        }
        Collections.sort(valgteArrangementer);

        return valgteArrangementer;
    }

    public String toString(){
        String returVerdi="";

        for(Arrangement a:arrangementer){
            returVerdi+=a.toString()+"\n";
        }
        return returVerdi;
    }

    public ArrayList<Arrangement> sted () {
        ArrayList<Arrangement> tmp = new ArrayList<>(arrangementer);
        tmp.sort((a1, a2) -> a1.getSted().compareTo(a2.getSted()));
        return tmp;
    }
}
