import java.util.Scanner;

// Abstract class for User Types
abstract class UserType {
    protected String userName;

    public UserType(String userName) {
        this.userName = userName;
    }

    public abstract void displayTypeDetails();
}

// Facilitator 
class Facilitator extends UserType {
    public Facilitator() {
        super("Facilitator");
    }

    @Override
    public void displayTypeDetails() {
        System.out.println("Type: " + userName + " - Facilitates events and activities.");
    }
}

// Donor 
class Donor extends UserType {
    public Donor() {
        super("Donor");
    }

    @Override
    public void displayTypeDetails() {
        System.out.println("Type: " + userName + " - Provides financial or material support.");
    }
}

// Volunteer 
class Volunteer extends UserType {
    public Volunteer() {
        super("Volunteer");
    }

    @Override
    public void displayTypeDetails() {
        System.out.println("Type: " + userName + " - Participates in on-ground activities.");
    }
}

// Log-in Class
class LoginUser {
    private String userName;
    private String userPassword;
    private UserType userType;

    public void setLogin(String userName, String userPassword, UserType userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public String getUsername() {
        return userName;
    }

    public UserType getType() {
        return userType;
    }

    public void displayLogin() {
        System.out.println("Username: " + userName);
        userType.displayTypeDetails();
    }
}

// Sign Up Subclass
class SignUp extends LoginUser {
    private String userContact;

    public SignUp(String userName, String userPassword, String userContact, UserType userType) {
        this.setLogin(userName, userPassword, userType);
        this.userContact = userContact;
    }

    public String getContact() {
        return userContact;
    }
}

// Main class for interaction
public class User {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("          |===== 1. Login =====|                   |===== 2. Sign up =====|");
        System.out.println(" ");
        System.out.print("Enter your choice: ");
        int option = userInput.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter Username: ");
                String loginName = userInput.next();

                System.out.print("Enter Password: ");
                String loginPass = userInput.next();

                UserType loginType = selectType(userInput);
                if (loginType == null) break;

                LoginUser loginUser = new LoginUser();
                loginUser.setLogin(loginName, loginPass, loginType);

                System.out.println("\nLogin Successful!");
                loginUser.displayLogin();
                break;

            case 2:
                System.out.print("Create a Username: ");
                String signUpName = userInput.next();

                System.out.print("Create a Password: ");
                String signUpPass = userInput.next();

                String contact;
                while (true) {
                    System.out.print("Enter your Contact Number (11 digits): ");
                    contact = userInput.next();

                    if (contact.matches("\\d{11}")) {
                        break;
                    } else {
                        System.out.println("Invalid contact number. Please enter exactly 11 digits.");
                    }
                }

                UserType signUpType = selectType(userInput);
                if (signUpType == null) break;

                SignUp signUpUser = new SignUp(signUpName, signUpPass, contact, signUpType);

                System.out.println("\nSign-Up Successful!");
                System.out.println("Username: " + signUpUser.getUsername());
                signUpUser.getType().displayTypeDetails();
                System.out.println("Contact Number: " + signUpUser.getContact());
                break;

            default:
                System.out.println("Invalid option. Please select 1 or 2.");
                break;
        }

        userInput.close();
    }

    public static UserType selectType(Scanner userInput) {
        System.out.println("\nSelect Your Type:");
        System.out.println("1. Facilitator");
        System.out.println("2. Donor");
        System.out.println("3. Volunteer");
        System.out.print("Enter your type (1/2/3): ");
        int typeChoice = userInput.nextInt();

        switch (typeChoice) {
            case 1:
                return new Facilitator();
            case 2:
                return new Donor();
            case 3:
                return new Volunteer();
            default:
                System.out.println("Invalid type selected. Please restart.");
                return null;
        }
    }
}
