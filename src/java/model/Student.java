/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 12906
 */
public class Student {
    private int id;
    private String name;
    private String phone;
    private String registrationDate;
    private String status;
    
    public String getName(){
        return this.name;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public String getRegistrationDate(){
        return this.registrationDate;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setPhone(String phone){
        this.phone=phone;
    }
    
    public void setRegistrationDate(String registrationDate){
        this.registrationDate = registrationDate;
    }
    
    public void setStatus(String status){
        this.status=status;
    }
}
