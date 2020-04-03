/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Augusto Souza 2017376
 */
public class RemoteConnection {

/**
     * print all countries
     */
    private static void printAllCountires(){
        try{
            List<Country> all_countries = DBCountry.readAllCountries();
            if(all_countries == null || all_countries.isEmpty()){
                System.out.println("Empty record !");
                return;
            }
            System.out.println("Code\tName\tContinent\tSurfaceArea\tHeadOfState");
            for(Country item : all_countries){
                System.out.println(item.toString());
            }
        }catch(Exception e){
            
        }
    }
    
}
