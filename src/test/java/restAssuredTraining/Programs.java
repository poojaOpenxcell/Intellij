package restAssuredTraining;

import org.testng.annotations.Test;
import java.lang.String;

public class Programs {

    @Test
    public void reverseString(){

        String str="whatever it may be";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println(reverse);
    }

    @Test
    public void builderReverse(){

        String str="Pooja Shah";
        String con="Dhrumil Shah";

        String reverse= new StringBuilder(str).reverse().toString();
        String reverse1= new StringBuilder(con).reverse().toString();
        System.out.println(reverse+ " "+ reverse1);

    }

    @Test
    public void replaceAppend(){

        String st="  Replacing My text";

        String replace = new StringBuilder(st).replace(0, 1,"OLd School").toString();
        System.out.println("Replaced text:" + replace);

        String append = new StringBuilder(st).append(" of BirthDate").toString();
        System.out.println("New append text:" + append);
    }

    @Test
    public void subStringUpper(){

        String st="PoojaShah";

        String substring= new StringBuilder(st).substring(5,9);
        String delete = String.valueOf(new StringBuilder(st).delete(1,5));

        System.out.println(substring);
        System.out.println(st.substring(5));
        System.out.println(st.toUpperCase());
        System.out.println(delete);
    }

    @Test
    public void internString(){

        String s1="First Attempt";
        String s2= s1.intern().toLowerCase();
        String s3= s1.replaceAll("First", "Third");
        System.out.println(s2);
        System.out.println(s3);
    }

    @Test
    public void compareString(){

        String s1="hello";
        String s2="hello";
        String s3="meklo";
        String s4="hemlo";
        String s5="flag";
        String s6="";
        System.out.println(s1.compareTo(s2));//0 because both are equal
        System.out.println(s1.compareTo(s3));//-5 because "h" is 5 times lower than "m"
        System.out.println(s1.compareTo(s4));//-1 because "l" is 1 times lower than "m"
        System.out.println(s1.compareTo(s5));//2 because "h" is 2 times greater than "f"
        System.out.println(s1.compareTo(s6));
    }

}
