/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Augusto Souza 2017376
 */
public class Country {

public Country(){
        
    }
    public void setCode(String val){
        this.code = val;
    }
    public void setName(String val){
        this.name = val;
    }
    public void setContinent(String val){
        this.continent = val;
    }
    public void setSurface(float val){
        this.surface = val;
    }
    public void setHead(String val){
        this.headOfState = val;
    }

public String getCode(){
        return code;
    }
    public String getName(){
         return name;
    }
    public String getContinent(){
        return continent;
    }
    public float getSurface(){
        return surface;
    }
    public String getHead(){
        return headOfState;
    }

@Override
    public String toString(){
        return code + "\t" + name + "\t" + continent + "\t" + surface + "\t" + headOfState;
    }    
}
