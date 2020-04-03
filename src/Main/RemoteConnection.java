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

//print countries by code
    private static void printCountriesByCode(){
        try{
            String code = new String();
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.print("Please enter code: ");
                code = scanner.nextLine();
                if(code == null || code.trim().isEmpty()){
                    System.out.println("Invalid code !");
                    continue;
                }
                break;
            }
            List<Country> all_countries = DBCountry.readCountirsByCode(code);
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

//print countirs by name
    private static void printCountriesByName(){
        try{
            String name = new String();
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.print("Please enter name: ");
                name = scanner.nextLine();
                if(name == null || name.trim().isEmpty()){
                    System.out.println("Invalid name !");
                    continue;
                }
                break;
            }
            List<Country> all_countries = DBCountry.readCountirsByName(name);
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
