package EmailApp;

import java.security.spec.RSAOtherPrimeInfo;

public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");
        em1.setMailboxCapacity(50);
        System.out.println(em1.showInfo());
    }
}