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

/**
     * run source code with options
     */
    private static void mainProcessing(){
        Scanner scanner = new Scanner(System.in);
        String pattern = "[1-5]";
        while(true){
            Usage();
            String option = scanner.nextLine();
            if(!Pattern.compile(pattern).matcher(option).matches()){
                System.out.println("Invalid option !");
                continue;
            }
            if(option.equals("1")) printAllCountires();
            else if(option.equals("2")) printCountriesByCode();
            else if(option.equals("3")) printCountriesByName();
            else if(option.equals("4")) addNewCountry();
            else if(option.equals("5")) break;
        }
    }
    private static String getStringFromScanner(String prefix){
        Scanner scanner = new Scanner(System.in);
        String content;
        while(true){
            System.out.print(prefix);
            content = scanner.nextLine();
            if(content == null || content.trim().isEmpty()){
                System.err.println("Invalid input !");
                continue;
            }else{
                break;
            }
        }
        return content;
    }
    //Usage
    private static void Usage(){
        System.out.println("\nPlease select one in following options: ");
        System.out.println("Get all countries: 1");
        System.out.println("Get countries by code: 2");
        System.out.println("Get countries by name: 3");
        System.out.println("Add new country: 4");
        System.out.println("Exit: 5");
    }
    
    public static void main(String[] args) {
        //connect database
        if (!DBConnection.connection()) {
            System.err.println("Fail to connect database !");
            return;
        }
        mainProcessing();
        
    }    
}
