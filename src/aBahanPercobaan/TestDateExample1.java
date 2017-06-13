/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aBahanPercobaan;

/**
 *
 * @author Sandro Y M Nababan
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateExample1 {

    public static void main(String[] argv) {

        //SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yy"); 
        SimpleDateFormat formatter = new SimpleDateFormat("yy/mm/dd");
        String dateInString = "95/12/12";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
