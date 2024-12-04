import java.util.Scanner;

class Company {
    private String companyName;
    private String companyEmail;
    private String companyAddress;
    private int companyNumber;

    //Constructors
    public void setCompanyDetails(String companyName, String companyEmail, String companyAddress, int companyNumber) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyAddress = companyAddress;
        this.companyNumber = companyNumber;
    }

    // Getters 
    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    // Display Method
    public void displayCompanyInfo() {
        System.out.println("\n==============================================================================");
        System.out.println("                           WELCOME TO " + companyName.toUpperCase());
        System.out.println("Address: " + companyAddress);
        System.out.println("Email: " + companyEmail);
        System.out.println("Contact Number: " + companyNumber);
        System.out.println("==============================================================================\n");
    }
}

public class CompanyInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Company company = new Company();

        System.out.println("\n==============================================================================");
        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter Company Email: ");
        String companyEmail = scanner.nextLine();

        System.out.print("Enter Company Address: ");
        String companyAddress = scanner.nextLine();

        System.out.print("Enter Company Contact Number: ");
        int companyNumber = scanner.nextInt();
        System.out.println("\n==============================================================================");

        // Display Info
        company.setCompanyDetails(companyName, companyEmail, companyAddress, companyNumber);
        company.displayCompanyInfo();

        scanner.close();
    }
}
