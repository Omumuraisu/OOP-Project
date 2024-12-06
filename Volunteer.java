import java.util.Scanner;

class LoginUser {
    private String userName;
    private String password;
    private String contact;

    public void setLogin(String userName, String password, String contact) {
        this.userName = userName;
        this.password = password;
        this.contact = contact;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public void displayLogin() {
        System.out.println(" ");
        System.out.println("Username: " + userName);
        System.out.println("Password: " + "******");
        System.out.println("Contact Number: " + contact);
    }
}

class SignUp extends LoginUser {
    public SignUp(String userName, String password, String contact) {
        super.setLogin(userName, password, contact);
    }
}

class Volunteer {
    private String volunteerType;

    public void setVolunteerType(String volunteerType) {
        this.volunteerType = volunteerType;
    }

    public String getVolunteerType() {
        return volunteerType;
    }

    public void displayVolunteerType() {
        System.out.println("Volunteer Type: " + volunteerType);
    }
}

class DisasterDisplayInfo {
    private String[] location;
    private String[] disasterType;
    private int[] popSize;

    public DisasterDisplayInfo(String[] location, String[] disasterType, int[] popSize) {
        this.location = location;
        this.disasterType = disasterType;
        this.popSize = popSize;
    }

    public String[] getLocation() {
        return location;
    }

    public String[] getDisasterType() {
        return disasterType;
    }

    public int[] getPopSize() {
        return popSize;
    }

    public void displayDisasterDetails() {
        System.out.println("\n=====================================================================================");
        System.out.println("|         Location        |          Disaster            |       Population Size    | ");
        System.out.println("=====================================================================================");

        for (int i = 0; i < location.length && i < disasterType.length && i < popSize.length; i++) {
            System.out.printf("| %-25s | %-28s | %-23d |%n", location[i], disasterType[i], popSize[i]);
        }

        System.out.println("=====================================================================================");
        System.out.println("");
    }

    public void displayLocationMenu() {
        System.out.println("Available locations:");
        for (int i = 0; i < location.length; i++) {
            System.out.println(i + 1 + ". " + location[i]);
        }
        System.out.println(" ");
    }

    public void displayLocationDetails(int locationIndex) {
        if (locationIndex >= 0 && locationIndex < location.length) {
            System.out.println("=====================================================================================");
            System.out.println("You selected: " + location[locationIndex]);
            System.out.println("Disaster Type: " + disasterType[locationIndex]);
            System.out.println("Population: " + popSize[locationIndex]);
            System.out.println("=====================================================================================");
        } else {
            System.out.println("Invalid selection.");
        }
    }
}

public class main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        String name = "";
        
        System.out.println("So you choose the Volunteer Option");
        System.out.println("|================ 1.Login |======================| 2. Sign up ======================|");
        System.out.print("Enter: ");
        int option = userInput.nextInt();
        userInput.nextLine(); 

        switch (option) {
            case 1: // Login
                System.out.print("Enter Username(Full Name): ");
                name = userInput.nextLine();

                String pass;
                while (true) {
                    System.out.print("Enter Password (6 digits): ");
                    pass = userInput.nextLine();
                    if (pass.matches("\\d{6}")) {
                        System.out.println("Password accepted!");

                        String contact;
                        while (true) {
                            System.out.print("Enter your contact number(11 Digits): ");
                            contact = userInput.nextLine();

                            if (contact.matches("\\d{11}")) {
                                System.out.println("Contact accepted!");
                                SignUp vol = new SignUp(name, pass, contact);
                                vol.displayLogin();
                                break; // Break from contact loop
                            } else {
                                System.out.println("ERROR!!!! Contact number must be exactly 11 digits.");
                            }
                        }
                        break; 
                    } else {
                        System.out.println("ERROR!!!! Password must be exactly 6 digits.");
                    }
                }
                break;

            case 2: // Sign Up
                System.out.print("Please create a Username(Full Name): ");
                name = userInput.nextLine();

                String newPassword;
                while (true) {
                    System.out.print("Please create a Password (6 digits): ");
                    newPassword = userInput.nextLine();
                    if (newPassword.matches("\\d{6}")) {
                        System.out.println("Password accepted!");
                        break; // Break after valid password
                    } else {
                        System.out.println("ERROR!!!! Password must be exactly 6 digits.");
                    }
                }

                String newContact;
                while (true) {
                    System.out.print("Enter your contact number(11 Digits): ");
                    newContact = userInput.nextLine();

                    if (newContact.matches("\\d{11}")) {
                        System.out.println("Contact accepted!");
                        SignUp vol = new SignUp(name, newPassword, newContact);
                        vol.displayLogin();
                        System.out.println(" ");
                        break; // Break from contact loop
                    } else {
                        System.out.println("ERROR!!!! Contact number must be exactly 11 digits.");
                    }
                }
                
                System.out.println("*****THANK YOU FOR SIGNING IN*******");
                System.out.println("              WELCOME");
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }

        System.out.println(" ");
        System.out.println("Enter Volunteer Type: ");
        String volunteerT = userInput.nextLine(); 

        Volunteer volunteer = new Volunteer();
        volunteer.setVolunteerType(volunteerT); 

        // Disaster Info
        String[] locations = {"Cebu", "Manila", "Iloilo", "Cavite", "Davao", "Palawan", "Baguio"};
        String[] disasterTypes = {"Typhoon", "Flood", "Earthquake", "Volcanic Eruption", "Landslide", "Forest Fire", "Tsunami"};
        int[] popSizes = {10, 35, 64, 21, 33, 99, 256};

        DisasterDisplayInfo disasterInfo = new DisasterDisplayInfo(locations, disasterTypes, popSizes);
        disasterInfo.displayDisasterDetails();
        disasterInfo.displayLocationMenu();

        System.out.print("Enter the number of the location you want to volunteer for: ");
        int locationChoice = userInput.nextInt() - 1;

        disasterInfo.displayLocationDetails(locationChoice);

        System.out.println("Safety Agreement:");
        System.out.println("By agreeing to this, you confirm the following terms and conditions:");
        System.out.println("1. We are not responsible for any personal injury, loss, or damage incurred during your volunteer activities.");
        System.out.println("2. You are solely responsible for ensuring your safety and taking all necessary precautions.");
        System.out.println("3. This application is for volunteer coordination purposes only and does not guarantee assistance in emergencies.");
        System.out.println("4. You agree to follow all guidelines, rules, and instructions provided by local authorities or organizers.");
        System.out.println("7. The Facilitators/organizers cannot be held liable for any unforeseen circumstances or external factors.");
        System.out.print("Do you agree to these terms? (Yes/No): ");
        String agree = userInput.next().toLowerCase(); 
        if (agree.equals("yes")) {
            // Summarize the user's information
            System.out.println("\n--- Volunteer Summary ---");
            System.out.println("Name: " + name);
            System.out.println("Contact: " + (agree.equals("yes") ? "Confirmed" : "Not Confirmed"));
            System.out.println("Prefred Volunteer Type: " + volunteerT);
            System.out.println("Location: " + locations[locationChoice]);
            System.out.println("Disaster: " + disasterTypes[locationChoice]);
            System.out.println("Population: " + popSizes[locationChoice]);
            System.out.println("Safety Agreement: Agreed");
            System.out.println("*****THANK YOU FOR YOUR SERVICES*****");
        } else if (agree.equals("no")) {
            System.out.println("You did not agree to the terms. Volunteer registration is incomplete.");
        } else {
            System.out.println("Invalid response.");
        }
        
        userInput.close();
    }
}
