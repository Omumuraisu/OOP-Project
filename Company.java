import java.util.Scanner;

class Company {
    private String companyName;
    private String companyEmail;
    private String companyAddress;
    private int companyNumber;

    public void setCompany(String companyName, String companyEmail, String companyAddress, int companyNumber) {
        this.companyName = companyName;
        this.email = companyEmail;
        this.companyAddress = companyAddress;
        this.number = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyEmail() {
        return email;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public int getCompanyNumber() {
        return number;
    }

    public void displayCompanyInfo() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Company Email: " + companyEmail);
        System.out.println("Company Address: " + companyAddress);
        System.out.println("Company Contact Number: " + companyNumber);
    }
}

abstract class LoginUser {
    private String userName;
    private String password;
    private int userType;
    private int faciPin;

    public void setLogin(String userName, String password, int userType, int faciPin) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.faciPin = faciPin;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getFaciPin() {
        return faciPin;
    }

    // Polymorphic method (overridden in subclass)
    public void displayLogin() {
        System.out.println("Enter username: " + userName);
        System.out.println("Enter password: " + password);
        System.out.println("Enter UserType: " + userType);
        System.out.println("Enter password: " + password);
    }

    // New method that will be polymorphically overridden
    public abstract void login();
}

class SignUp extends LoginUser {
    private String createUserName;
    private String createPassword;

    public SignUp(String userName, String password) {
        this.createUserName = userName;
        this.createPassword = password;
    }

    public String getCreateUsername() {
        return createUserName;
    }

    public String getCreatePassword() {
        return createPassword;
    }

    // Overriding the displayLogin method to add custom behavior
    @Override
    public void displayLogin() {
        System.out.println("Enter username (from SignUp): " + createUserName);
        System.out.println("Enter password (from SignUp): " + createPassword);
    }

    // Implementing the abstract login method
    @Override
    public void login() {
        System.out.println("Signing up with username: " + createUserName + " and password: " + createPassword);
    }

    // New method specific to SignUp
    public void displaySignUp() {
        System.out.println("Enter username: " + createUserName);
        System.out.println("Enter password: " + createPassword);
    }

    public boolean verifyUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Confirm your password: ");
        String confirmPassword = scan.next();
        
        // Check if passwords match
        if (createPassword.equals(confirmPassword)) {
            System.out.println("Password confirmed. Verification successful.");
            return true;
        } else {
            System.out.println("Passwords do not match. Please try again.");
            return false;
        }
    }
}




public class main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Company org = new Company();
        System.out.println("=========================");
        System.out.println("Company name: ");
        String companyName = scan.next();

        System.out.println("Email: ");
        String Email = scan.next();

        System.out.println("Company Address: ");
        String companyAdd = scan.next();

        System.out.println("Company number: ");
        int companyNumber = scan.nextInt();
        System.out.println(" ");

        System.out.println("=========================");

        org.setCompany(companyName, Email, companyAdd, companyNumber);
        org.displayCompanyInfo();

        System.out.println("=========================");
        System.out.println("Do you wish to Login/Sign up: ");
        System.out.println("|===== 1.Login |=====| 2. Sign up =====|");
        System.out.print("Enter: ");
        int option = scan.nextInt();

        switch (option) {
            case 1: 
                System.out.println("Enter Username: ");
                String userName = scan.next();
                System.out.println("Enter password: ");
                String password = scan.next();
                System.out.println("=========================");
                System.out.println("Username " + userName);
                System.out.println("Password " + password);
                System.out.println("=========================");


                System.out.println("|===== 1.Facilitator |=====| 2. Donor |===== 3.Volunteer======");
                int choose = scan.nextInt();
                
                switch (choose) {
                    case 1: 
                        System.out.println("Facilitator");
                        // Implement logic for Facilitator here
                        break;

                    case 2: 
                        System.out.println("Donor ");
                        // Implement logic for Donor here
                        break;

                    case 3:
                        System.out.println("Volunteer");
                        // Implement logic for Volunteer here
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
                break;

            case 2:
           
                // SignUp process
                System.out.println("=========================");
                System.out.println("Enter username for SignUp: ");
                String createUserName = scan.next();
                System.out.println("Enter password for SignUp: ");
                String createPassword = scan.next();
                System.out.println("=========================");
                SignUp signUp = new SignUp(createUserName, createPassword);
                signUp.displayLogin();
                signUp.login();
                System.out.println("=========================");

                boolean isVerified = false;
                while (!isVerified) {
                    isVerified = signUp.verifyUser();  // Verification loop
                }
                System.out.println("=========================");
                
                System.out.println("|===== 1.Facilitator |=====| 2. Donor |===== 3.Volunteer=======");
                int choose2 = scan.nextInt();

                switch (choose2) {
                    case 1: 
                        System.out.println("Facilitator");
                        // Implement logic for Facilitator here
                        break;

                    case 2: 
                        System.out.println("Donor");
                        // Implement logic for Donor here
                        break;

                    case 3:
                        System.out.println("Volunteer");
                        // Implement logic for Volunteer here
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
                break;


            default:
                System.out.println("Invalid option.");
        }

        scan.close();
    }
}
