import java.util.Scanner;

// Abstract class for User Roles
abstract class UserRole {
    protected String roleName;

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public abstract void displayRoleDetails();
}

// Facilitator 
class Facilitator extends UserRole {
    public Facilitator() {
        super("Facilitator");
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Role: " + roleName + " - Facilitates events and activities.");
    }
}

// Donor 
class Donor extends UserRole {
    public Donor() {
        super("Donor");
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Role: " + roleName + " - Provides financial or material support.");
    }
}

// Volunteer 
class Volunteer extends UserRole {
    public Volunteer() {
        super("Volunteer");
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Role: " + roleName + " - Participates in on-ground activities.");
    }
}

// Log-in Class
class LoginUser {
    private String userName;
    private String password;
    private UserRole role;

    public void setLogin(String userName, String password, UserRole role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return userName;
    }

    public UserRole getRole() {
        return role;
    }

    public void displayLogin() {
        System.out.println("Username: " + userName);
        role.displayRoleDetails();
    }
}

// Sign Up Subclass
class SignUp extends LoginUser {
    private String contact;

    public SignUp(String userName, String password, String contact, UserRole role) {
        this.setLogin(userName, password, role);
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }
}

// Main class for interaction
public class User {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("          |===== 1. Login =====|                 |===== 2. Sign up =====|");
        System.out.println(" ");
        System.out.print("Enter your choice: ");
        int option = userInput.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter Username: ");
                String loginName = userInput.next();

                System.out.print("Enter Password: ");
                String loginPass = userInput.next();

                UserRole loginRole = selectRole(userInput);
                if (loginRole == null) break;

                LoginUser loginUser = new LoginUser();
                loginUser.setLogin(loginName, loginPass, loginRole);

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

                UserRole signUpRole = selectRole(userInput);
                if (signUpRole == null) break;

                SignUp signUpUser = new SignUp(signUpName, signUpPass, contact, signUpRole);

                System.out.println("\nSign-Up Successful!");
                System.out.println("Username: " + signUpUser.getUsername());
                signUpUser.getRole().displayRoleDetails();
                System.out.println("Contact Number: " + signUpUser.getContact());
                break;

            default:
                System.out.println("Invalid option. Please select 1 or 2.");
                break;
        }

        userInput.close();
    }

    public static UserRole selectRole(Scanner userInput) {
        System.out.println("\nSelect Your Role:");
        System.out.println("1. Facilitator");
        System.out.println("2. Donor");
        System.out.println("3. Volunteer");
        System.out.print("Enter your role (1/2/3): ");
        int roleChoice = userInput.nextInt();

        switch (roleChoice) {
            case 1:
                return new Facilitator();
            case 2:
                return new Donor();
            case 3:
                return new Volunteer();
            default:
                System.out.println("Invalid role selected. Please restart.");
                return null;
        }
    }
}
