import java.util.Scanner;

class Company {
    private String companyName;
    private String companyEmail;
    private String companyAddress;
    private String companyNumber;

    public void setCompanyDetails(String companyName, String companyEmail, String companyAddress, String companyNumber) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyAddress = companyAddress;
        this.companyNumber = companyNumber;
    }

    public void displayCompanyInfo() {
        System.out.println("\n==============================================================================");
        System.out.println("                           WELCOME TO " + companyName.toUpperCase());
        System.out.println("Address: " + companyAddress);
        System.out.println("Email: " + companyEmail);
        System.out.println("Contact Number: " + companyNumber);
        System.out.println("==============================================================================\n");
    }
}

abstract class UserType {
    protected String userName;

    public UserType(String userName) {
        this.userName = userName;
    }

    public abstract void displayTypeDetails();
}

class Donor extends UserType {
    public Donor() {
        super("Donor");
    }

    @Override
    public void displayTypeDetails() {
        System.out.println("Type: Donor - Provides financial or material support.");
    }
}

class Volunteer extends UserType {
    public Volunteer() {
        super("Volunteer");
    }

    @Override
    public void displayTypeDetails() {
        System.out.println("Type: Volunteer - Participates in on-ground activities.");
    }
}

public class RespoLink {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display company information
        Company company = new Company();
        company.setCompanyDetails("Helping Hands", "info@helpinghands.org", "123 Charity St.", "09123456789");
        company.displayCompanyInfo();

        // Ask for user type
        System.out.println("Please select your user type:");
        System.out.println("1. Donor");
        System.out.println("2. Volunteer");
        System.out.print("Enter your choice (1 or 2): ");

        int userTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (userTypeChoice) {
            case 1: // Donor
                System.out.println("Redirecting to Donor Information...");
                DonorInfo.main(args);
                break;

            case 2: // Volunteer
                System.out.println("Redirecting to Volunteer Information...");
                VolunteerInfo.main(args);
                break;

            default:
                System.out.println("Invalid choice. Please restart the program.");
                break;
        }

        scanner.close();
    }
}
