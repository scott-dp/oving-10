import static javax.swing.JOptionPane.*;
public class Main {
    public static void main(String[] args) {
        boolean fortsett=true;
        ArrangementRegister register=new ArrangementRegister();

        while(fortsett){
            String readValg=showInputDialog("Legg til nytt arrangement(l),se alle arrangement(a),finn arrangement på sted(s),finn på en dato(o), finn mellom to datoer(t),avslutt(x)");
            switch(readValg){
                case "l":
                    String readNummer=showInputDialog("Skriv inn nummer");
                    String readName=showInputDialog("Skriv inn navnet");
                    String readArrangor=showInputDialog("Skriv inn arrangør");
                    String readType=showInputDialog("Skriv inn type");
                    String readSted=showInputDialog("Skriv inn sted");
                    String readTidspunkt=showInputDialog("Skriv inn tidspunkt");
                    Arrangement nyttArrangement=new Arrangement(Integer.parseInt(readNummer),readName,readArrangor,readType,readSted,Integer.parseInt(readTidspunkt));
                    register.leggTilArrangement(nyttArrangement);
                    break;
                case "x":
                    fortsett=false;
                    break;
                case "a":
                    showMessageDialog(null,register.toString());
                    break;
                case "s":
                    String readPlace=showInputDialog("Skriv inn sted du vil finne arrangementer i");
                    for(Arrangement a:register.finnArrangementSted(readPlace)){
                        System.out.println(a.toString());
                    }
                    break;
                case "o":
                    int readDate=Integer.parseInt(showInputDialog("Skriv inn dato"));
                    for(Arrangement a:register.finnArrangementDato(readDate)){
                        System.out.println(a.toString());
                    }
                    break;
                case "t":
                    int readDate1=Integer.parseInt(showInputDialog("Skriv inn første dato"));
                    int readDate2=Integer.parseInt(showInputDialog("Skriv inn andre dato"));
                    for(Arrangement a:register.arrangementerIIntervall(readDate1,readDate2)){
                        System.out.println(a.toString());
                    }
                    break;

            }
        }
    }
}