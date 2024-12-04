class company{
        private String companyName;
        private String email;
        private String companyAddress;
        private int number;

        public void setCompany(String companyName, String email, String companyAddress, int number){
            this.companyName = companyName;
            this.email = email;
            this.companyAddress = companyAddress;
            this.number = number;

        }

        public String getCompanyName(){
            return companyName;
        }

        public String getEmail(){
            return email;
        }

        public String getCompanyAddress(){
            return companyAddress;
        }

        public int getNUmber(){
            return number;
        }


        public void DisplayCompanyInfo(){

                System.out.println("Company Name: " + companyName);
                System.out.println("Company Email: " + email);
                System.out.println("Company Address: " + companyAddress);
                System.out.println("Company Contact Nmber: " + number);
        }

}

public class main2{
    
}