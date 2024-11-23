package emailApp;

import java.util.Arrays;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String passWord;
    private String departmant;
    private int mailboxCapacity=500;
    private int defaultPasswordLength;
    private String alternateEmail;
    private String email;
    private String companySuffix="aeycompany.com";


    // Constructor to recieve first and LastName
    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        this.defaultPasswordLength=8;
        // System.out.println("Email Created : " + this.firstName+" "+ this.lastName);
        this.departmant=setDepartment();
        // System.out.println("Department is: "+this.departmant);
        this.passWord=randomPassword(defaultPasswordLength);
        System.out.println("Your Password is "+this.passWord);
        String email=firstName.toLowerCase()+'.'+lastName.toLowerCase()+"@"+departmant+"."+companySuffix;
        // System.out.println("Your mail id: "+email);
        this.email=email;
    
    }
    // Ask for a department
    private String setDepartment(){
        System.out.print("Enter 1 for department \n1 for Sales\n2 Development \n3 for accounting \n0 for node \n");
        Scanner inp=new Scanner(System.in);
        Integer deptChoice=inp.nextInt();
        if(deptChoice==1){return "Sales";}
        if(deptChoice==2){return "Development";}
        if(deptChoice==3){return "Accounting";}
        else{
            return null;
        }
    } 
    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }
    // Set alternative Mail
    public void setAltEmail(String alternateEmail){
        this.alternateEmail=alternateEmail;
    }
    // Change the password
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
        char[] passWord=new char[length];
        for(int i=0;i<length;i++){
            int rand=(int)(Math.random()*passwordSet.length());
            passWord[i]=passwordSet.charAt(rand);
        }
        
        return new String(passWord);
    }

    public void changePassword(String passWord){
        this.passWord=passWord;
    }

    public int getMailBoxCapacity(){
        return mailboxCapacity;
    }
    public String getalternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return passWord;
    }

    public String showInfo(){
        return "DISPLAY NAME:" + firstName + lastName+ 
                "COMPANY EMAIL"+ email+
                "MAIL BOX CAPACITY"+ mailboxCapacity;
    }
}
