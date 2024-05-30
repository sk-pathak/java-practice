import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collect {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        Comparator<String> comp=new Comparator<>() {
            public int compare(String i,String j){
                if(i.length()>j.length()) return 1;
                else return-1;
            }
        };

        list.add("Mr Morale & The Big Steppers");
        list.add("Section 80");
        list.add("Good Kid Maad City");
        list.add("Damn");
        list.add("To Pimp A Butterfly");
        Collections.sort(list,comp);
        System.out.println(list);
    }
}
