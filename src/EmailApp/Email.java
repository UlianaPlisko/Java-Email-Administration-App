package EmailApp;

import java.sql.SQLOutput;
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
    public Email(String firstName, String lastName) throws InterruptedException{
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = generatePassword(8);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        this.mailboxCapacity = 50;
        Thread.sleep(500);
        System.out.println("EMAIL CREATED: " + firstName + " " + lastName);
        System.out.println("Your email is: " + email);
        System.out.println("Your password is: " + password);
        System.out.println("Your mailbox capacity is: " + mailboxCapacity);
        Thread.sleep(500);
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

    public void menuOfActions(int num){
        if(num == 1){
            if(this.alternateEmail != null){
                System.out.println("Your alternate email is: " + alternateEmail);
            }
            else{
                System.out.println("Enter your alternate email address: ");
                Scanner scan = new Scanner(System.in);
                String altEmail = scan.nextLine();
                while(!altEmail.endsWith("@gmail.com")){
                    System.out.println("Invalid email address, try again");
                    altEmail = scan.nextLine();
                }
                setAlternateEmail(altEmail);
                System.out.println("Alternate email was created.");
            }
        }
        else if(num == 2){
            System.out.println("Enter old password: ");
            Scanner scan = new Scanner(System.in);
            String oldPassword = scan.nextLine();
            while(!oldPassword.equals(this.password)){
                System.out.println("Passwords do not match, try again");
                oldPassword = scan.nextLine();
            }
            System.out.println("Enter new password: ");
            String newPassword = scan.nextLine();
            while(newPassword.length() != 8){
                System.out.println("Your password must be 8 digits long, try again");
                newPassword = scan.nextLine();
            }
            changePassword(newPassword);
            System.out.println("Password has been changed.");
        }
        else if(num == 3){
            showInfo();
        }
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

    public void showInfo(){
        System.out.println("NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " + email + "\nPASSWORD: " + password + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb\nALTERNATE EMAIL: " + alternateEmail);
    }
}
