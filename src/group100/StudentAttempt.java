/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group100;

/**
 *
 * @author matro
 */

import java.util.Scanner;
import java.util.Date;
public class StudentAttempt {
    private String name,gender,address,dobString;
    private Date dob;
    Scanner Scan = new Scanner(System.in);
    
    StudentAttempt(String name, String gender, String address, String dobString){
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dobString = dobString;
        // replace dobString with dob when date is working
    }
    
    
    
    public void getName(String name){
        System.out.println("Enter Students Name");
        name = Scan.nextLine();
        
    }
    
    public void getGender(String gender){
        System.out.println("Enter Students Gender");
        gender = Scan.nextLine();
        
    }
    public void getAddress(String address){
        System.out.println("Enter Students Address");
        address = Scan.nextLine();
        
    }
    public void getDob(Date dob){
        System.out.println("Enter Students Address");
        dobString= Scan.nextLine();
        // tried to get Date to work, but not sure how it works, string for now
    }
    public String toString(){
        return ""+this.name+","+this.gender+","+this.address+","+this.dobString+"\n";
    }

}
