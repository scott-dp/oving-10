import java.util.*;
import java.util.Comparator;
public class Arrangement implements Comparable<Arrangement>{
    private int nummer;
    private String navn;
    private String arrangor;
    private String type;
    private String sted;
    private int tidspunkt;

    public Arrangement(int nummer, String navn, String arrangor, String type, String sted,int tidspunkt){
        this.nummer=nummer;
        this.navn=navn;
        this.arrangor=arrangor;
        this.sted=sted;
        this.type=type;
        this.tidspunkt=tidspunkt;
    }

    public String getSted(){
        return this.sted;
    }

    public int getTidspunkt(){
        return tidspunkt;
    }

    @Override public int compareTo(Arrangement comparestu) {
        int compareage = ((Arrangement)comparestu).getTidspunkt();

        //  For Ascending order
        return this.tidspunkt - compareage;

        // For Descending order do like this
        // return compareage-this.studentage;
    }

    public String toString(){
        return "Arrangementet "+navn+" er et "+type+" nummer: "+nummer+" arrangeres av "+arrangor+" dato og tid: "+getTidspunkt()+" i "+getSted();
    }
}
