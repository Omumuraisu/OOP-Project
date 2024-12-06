import java.util.Scanner;

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
        System.out.println("User Password: " + "******");
        userType.displayTypeDetails();
    }
}

// SignUp Class 
class SignUp {
    private String userName;
    private String firstName;
    private String lastName;
    private String userPassword;
    private String userContact;
    private UserType userType;

    public SignUp(String userName, String userPassword, String firstName, String lastName, String userContact, UserType userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userContact = userContact;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getContact() {
        return userContact;
    }

    public UserType getUserType() {
        return userType;
    }

    public void displaySignUpDetails() {
        System.out.println("\nSign-Up Successful!");
        System.out.println("Username: " + getUserName());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Contact Number: " + getContact());
        getUserType().displayTypeDetails();
    }
}

// Main class
public class User {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("          |===== 1. Login =====|                   |===== 2. Sign up =====|");
        System.out.println(" ");
        System.out.print("Enter your choice: ");
        int option = userInput.nextInt();
        userInput.nextLine(); 

        switch (option) {
            case 1:
                System.out.print("Enter Username (Full Name): ");
                String loginName = userInput.nextLine();

                System.out.print("Enter Password (6-Digits): ");
                String loginPass;
                while (true) {
                    loginPass = userInput.nextLine();
                    if (loginPass.matches("\\d{6}")) {
                        break;
                    } else if (loginPass.length() > 6) {
                        System.out.println("Invalid password. Password exceeds 6 digits.");
                    } else {
                        System.out.println("Invalid password. Password is less than 6 digits.");
                    }
                    System.out.print("Enter Password (6-Digits): ");
                }

                UserType loginType = selectType(userInput);
                if (loginType == null) break;

                LoginUser loginUser = new LoginUser();
                loginUser.setLogin(loginName, loginPass, loginType);

                System.out.println("\nLogin Successful!");
                loginUser.displayLogin();
                break;

            case 2:
                System.out.print("Create a Username: ");
                String signUpName = userInput.nextLine();

                System.out.print("Create a Password (6-Digits): ");
                String signUpPass;
                while (true) {
                    signUpPass = userInput.nextLine();
                    if (signUpPass.matches("\\d{6}")) {
                        break;
                    } else if (signUpPass.length() > 6) {
                        System.out.println("Invalid password. Password exceeds 6 digits.");
                    } else {
                        System.out.println("Invalid password. Password is less than 6 digits.");
                    }
                    System.out.print("Create a Password (6-Digits): ");
                }

                System.out.print("Enter First Name: ");
                String firstName = userInput.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = userInput.nextLine();

                String contact;
                while (true) {
                    System.out.print("Enter your Contact Number (11 digits): ");
                    contact = userInput.nextLine();

                    if (contact.matches("\\d{11}")) {
                        break;
                    } else {
                        System.out.println("Invalid contact number. Please enter exactly 11 digits.");
                    }
                }

                UserType signUpType = selectType(userInput);
                if (signUpType == null) break;

                SignUp signUpUser = new SignUp(signUpName, signUpPass, firstName, lastName, contact, signUpType);
                signUpUser.displaySignUpDetails();
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
        userInput.nextLine(); 

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
