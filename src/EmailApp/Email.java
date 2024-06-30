package EmailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;
    private String email;
    private String companySuffix = "ayecompany.com";

    // Constructor to receive the first name and last name

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + firstName + " " + lastName);
        this.department = setDepartment();
        this.password = generatePassword(8);
        System.out.println("Your password is: " + password);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }

    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter your choice: ");
        Scanner scan = new Scanner(System.in);
        int depChoice = scan.nextInt();
        if(depChoice == 1){
            return "sales";
        }
        else if(depChoice == 2){
            return "Dev";
        }
        else if(depChoice == 3){
            return "Acct";
        }
        else {return "";}
    }

    private String generatePassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*?/";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
