package PageObjects;

public class Utils {

    public static double returnDouble (String value){
        String  price="";
       // value = value.replace('.',',');
        if (value.contains("$")){
            price  = value.replace("$","");
        }
        if (value.contains("£")){
            price  = value.replace("£","");
        }
        if (value.contains("€")){
            price  = value.replace("€","");
        }
        return Double.parseDouble(price);
    }
}
