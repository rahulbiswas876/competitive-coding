/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naveen
 */
import java.util.Date;
import java.text.*;
import java.util.Calendar;
import java.util.Locale;
public class DateTest {

    /**
     * @param args the command line arguments
     */
    //yyyy/MM/dd
    public static void main(String[] args) throws ParseException {
        
        String dateString = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()).toString();
        usingCustomFormatter(dateString);
        usingDefaultFormatter(dateString);
    }
    private static void usingCustomFormatter(String dateString) throws ParseException {
        System.out.println("usingCustomFormatter");
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateString);
        
        SimpleDateFormat customFormatter = new SimpleDateFormat("d MMM,''yy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("K:mm:ss aaa");
        System.out.println(customFormatter.format(date));
        System.out.println(timeFormatter.format(date));
        
    }
    private static void usingDefaultFormatter (String dateString) throws ParseException{
        System.out.println("usingDefaultFormatter");
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateString);
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("en","US"));
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, new Locale("en","US"));
        //dateString = dateFormatter.format(date);
//        Date date = new SimpleDateFormat("HH:mm:ss").parse(dateString);
        System.out.println(dateFormatter.format(date));
        System.out.println(timeFormatter.format(date));
    }
    
}
