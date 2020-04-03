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

//print countries by name
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

//add new country
    private static void addNewCountry(){
        Country country = new Country();
        String code = getStringFromScanner("Enter code: ");
        String name = getStringFromScanner("Enter name: ");
        String continent = getStringFromScanner("Enter continent: ");
        String surface = new String();
        float surface_val = 0.0f;
        while(true){
            surface = getStringFromScanner("Enter surface of area: ");
            try{
                surface_val = Float.parseFloat(surface);
            }catch(Exception e){
                System.err.println("Invalid input !");
                continue;
            }
            break;
        }
        String head = getStringFromScanner("Enter head of state: ");
        
        country.setCode(code);
        country.setName(name);
        country.setContinent(continent);
        country.setSurface(surface_val);
        country.setHead(head);
        
        if(DBCountry.addNewCountry(country)){
            System.out.println("Success to add new country !");
        }else{
            System.out.println("Fail to add new country !");
        }
    }    
}
