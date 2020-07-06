/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class CommonUtil {
     public static String getCurrenDate() {
        String currenDate = null;
        try {
            String currentDate = getCurrenDate();
            SimpleDateFormat formatter = new SimpleDateFormat(" dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            currenDate = formatter.format(date);
        } catch (Exception e) {
        }
        return currenDate;
    }
    
     public static void logFile(String error) {
        try {
            String currentDate = getCurrenDate();
            FileWriter fw = new FileWriter(new File("D:\\TEST_WEB\\BookingManagement"));
            fw.write(error + currentDate + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     public static int toInt(String number){
         try {
             int out=Integer.parseInt(number);
             return out;
         } catch (Exception e) {
             return 0;
         }
     }
}
