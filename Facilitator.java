import java.util.*;

class Facilitator{
    private String facilitatorName = "Jologs";
    private int pin;
    private String[] location;
    private String[] disasterType;
    private int[] popSize;
    private double donatedCash;


    public Facilitator(String facilitatorName, int pin, String[] location, String[] disasterType, int[] popSize, double donatedCash){
        this.facilitatorName = facilitatorName;
        this.pin = pin;
        this.location = location;
        this.disasterType = disasterType;
        this.popSize = popSize;
        this.donatedCash = donatedCash;

    }

    public void transactions(){
        //Hindi ko knows ni T-T

    } 
    
    public String getFacilitatorName() {
        return facilitatorName;
    }

    public void setFacilitatorName(String facilitatorName) {
        this.facilitatorName = facilitatorName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String[] getLocation() {
        return location;
    }

    public void setLocation(String[] location) {
        this.location = location;
    }

    public String[] getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String[] disasterType) {
        this.disasterType = disasterType;
    }

    public int[] getPopSize() {
        return popSize;
    }

    public void setPopSize(int[] popSize) {
        this.popSize = popSize;
    }

    public double getDonatedCash() {
        return donatedCash;
    }

    public void setDonatedCash(double donatedCash) {
        this.donatedCash = donatedCash;
    }

    public void displayDisasterDetails(){
        
        System.out.println("\n======================================================================");
        System.out.println("         Location              Disaster             Population Size     ");
        System.out.println("========================================================================");

        for(int i = 0; i < location.length; i++){
            System.out.println("         " +location[i] + "              " + disasterType[i] + "             " + popSize[i] + "     " );
        }
        
    }

}

public class Run{
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Hello, " + //Facilitator Name);
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        System.out.println(" ");
        System.out.println("\n==============================================================================================");
        System.out.println("                                           TRANSACTION                                ");
        System.out.println("==============================================================================================");
        System.out.println(" ");
        System.out.println("          |===== 1. Check Balance =====|                 |===== 2. Withdraw Cash =====|");
        System.out.println(" ");

        System.out.print("Enter your choice:");
        int choice = scanner.nextInt();

        if(choice == 1){
            System.out.println(" ");
            System.out.println("Your current balance is: " + //ang method I think ni T-T);
            System.out.println(" ");    
        }        
        else if(choice == 2){
            System.out.println(" ");
            System.out.print("Enter the amount you want to withdraw: ");
            facilitator.setCashWithdrawal(scanner.nextDouble());
            System.out.println(" ");
        }

    }

    
}
