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

    public int getPin() {
        return pin;
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
    public double getDonatedCash() {
        return donatedCash;
    }

    public void displayDisasterDetails(){
        
        System.out.println("\n======================================================================");
        System.out.println("         Location              Disaster             Population Size     ");
        System.out.println("======================================================================");

        for(int i = 0; i < location.length && i < disasterType.length && i < popSize.length; i++){
            System.out.println("         " +location[i] + "              " + disasterType[i] + "             " + popSize[i] + "     " );
        }
        
    }

    public void displayInventories(int food, int water, int medicalSupplies, int clothing){
        System.out.println(" ");
        System.out.println("\n=======================================================================================================================================================");
        System.out.println("                                                       RELIEF GOODS SUPPLIES                                ");
        System.out.println("=======================================================================================================================================================");
        System.out.println("Range of Size            Citizens Affected             Foods             Water             Medical Supplies             Clothing             Status");
        System.out.println("=======================================================================================================================================================");
        System.out.println(" ");

        //idk how ma compare sa range to affected pero daw somthing like this ang na isip ko
        for(int i = 0; i < popSize.length; i++){
            if  (10 < popSize[i] && popSize[i] < 20){
                System.out.println("10-20" + "             "+ popSize[i] + "             " + food + "             " + water + "             " + medicalSupplies + "             " + clothing + "             " + "Sufficient");
            } else {
                System.out.println("10-20" + "             "+ popSize[i] + "             " + food + "             " + water + "             " + medicalSupplies + "             " + clothing + "             " + "Insufficient");
            }

        }
    }

    public void processTransactions(){

        
    }

    public void displayVolunteers(){
       
    }

    public void displayDonors(){
        
    }

    public void displayFaciSummary(){

    }
}

public class Run{
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        

      
    }

    
}
