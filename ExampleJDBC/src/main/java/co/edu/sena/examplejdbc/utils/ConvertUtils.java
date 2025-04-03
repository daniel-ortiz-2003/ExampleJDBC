/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aprendiz
 */
public class ConvertUtils {
    public static String dateToString(Date date)
    {
        DateFormat dateFormact = new SimpleDateFormat("yyyy-mm-dd");
        String result = dateFormact.format(date);
        return result;
    }
    public static Date stringToDate(String text) throws ParseException
    {
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse(text);
        return date;
    }
}
