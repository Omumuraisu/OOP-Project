import java.util.Scanner;

class LoginUser {
    private String userName;
    private String password;


    public void setLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

  
    public void displayLogin() {
        System.out.println("Enter username: " + userName);
        System.out.println("Enter password: " + password);
    }
}

class SignUp extends LoginUser {
    private int contact;

    public SignUp(String userName, String password, int contact) {
        super.setLogin(userName, password);  
        this.contact = contact;
    }


    public int getContact() {
        return contact;
    }
}

public class main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);  

        LoginUser log = new LoginUser();  

        System.out.println("So you choose the Volunteer Option ");
        System.out.println("|===== 1.Login |=====| 2. Sign up =====|");
        System.out.print("Enter: ");
        int option = userInput.nextInt();

        switch (option) {
            case 1:  // Login Option
                System.out.print("Enter Username: ");
                String name = userInput.next();

                System.out.print("Enter Password: ");
                String pass = userInput.next();

                System.out.println("");
                log.setLogin(name, pass); 
                log.displayLogin();  
                break;

            case 2: 
                
                System.out.print("Please create a Username: ");
                String newName = userInput.next();

                System.out.print("Please create a Password: ");
                String newPassword = userInput.next();

                System.out.print("Enter your contact number: ");
                int contact = userInput.nextInt();

                SignUp vol = new SignUp(newName, newPassword, contact);

                System.out.println("You have successfully signed up!");
                System.out.println("Username: " + vol.getUsername());
                System.out.println("Contact: " + vol.getContact());
                break;

            default:
                System.out.println("Invalid option. Please choose 1 or 2.");
        }

        userInput.close(); 
    }
}
