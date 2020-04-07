package ir.ac.kntu;


import java.util.Scanner;

public class Tourleader {
    //attributes
    private String firstName ;
    private String lastName ;
    private long nationalCode ;
    private long identityNumber ;
    private ir.ac.kntu.Date birthDate ;
    private ir.ac.kntu.Date employmentDate ;
    private boolean maritalStatus ;
//    private boolean internationalStatus ;
    private City[] citiesOfoperation ;
    private Country[] CountriesOfoperation ;



    //construct
    public Tourleader(){
        //first name
        System.out.printf("Enter first name :\n");
        Scanner scanner = new Scanner(System.in);
        setFirstName(scanner.nextLine());

        //last name
        System.out.printf("Enter last name :\n");
        setLastName(scanner.nextLine());

        // national code and checking it
        System.out.printf("Enter national code (only 10 digits) :\n");
        long nationalCode = scanner.nextLong();
        while (!checkIftenDigit(nationalCode)){
            System.out.printf("you have entered a number that is not 10 digit , try again\n");
            nationalCode = scanner.nextLong();
        }
        setNationalCode(nationalCode);

        // ID number and checking
        System.out.printf("Enter ID number :\n");
        long idNumber = scanner.nextLong();
        while (!checkID(idNumber)){
            System.out.printf("you have entered a number that is more than 10 digit , try again\n");
            idNumber = scanner.nextLong();
        }
        setIdentityNumber(idNumber);


        //birth date
        System.out.printf("Enter the born year : \n");
        int year = scanner.nextInt();
        System.out.printf("Enter the born month : \n");
        int month = scanner.nextInt();
        System.out.printf("Enter the born day : \n");
        int day = scanner.nextInt();
        //checking the date
        while (!checkDate(year,month,day)){
            System.out.printf("you have entered some irrational numbers pls try again\n");
            System.out.printf("Enter the born year : \n");
            year = scanner.nextInt();
            System.out.printf("Enter the born month : \n");
            month = scanner.nextInt();
            System.out.printf("Enter the born day : \n");
            day = scanner.nextInt();
        }
        setBirthDate(year,month,day);

        //employment date
        System.out.printf("Enter employment year : \n");
        year = scanner.nextInt();
        System.out.printf("Enter employment month : \n");
        month = scanner.nextInt();
        System.out.printf("Enter employment day : \n");
        day = scanner.nextInt();
        //checking the employment date
        while (!checkEmploymentDate(year,month,day)){
            System.out.printf("you have entered some irrational numbers pls try again (probably the difference between the year you born and the year you employed is less than 18)\n");
            System.out.printf("Enter the employment year : \n");
            year = scanner.nextInt();
            System.out.printf("Enter the employment month : \n");
            month = scanner.nextInt();
            System.out.printf("Enter the employment day : \n");
            day = scanner.nextInt();
        }
        setEmploymentDate(year,month,day);


        //marital status and checking
        System.out.printf("Are you married ? \n ( Y/y for yes and N/n for no \n");
        String question = scanner.next();
        if (question.equals("Y")||question.equals("y") || question.equals("Yea")||question.equals("yes")){
            setMaritalStatus(true);
        }
        else if (question.equals("N")||question.equals("n") || question.equals("No")||question.equals("no")){
            setMaritalStatus(false);
        }
        else{
            System.out.printf("You have entered sth else , we take that as a No \n");
            setMaritalStatus(false);
        }




        //assigning countries


        //assigning cities
        System.out.printf("How many cities are going to be handled by this tour leader? ");
        int cityCount = scanner.nextInt();
        City[] cities = new City[cityCount];
        City[] cityList = City.values();
        int[] checkForcopies = new int[cityCount];
        for (int s = 0; s < checkForcopies.length; s++) {
            checkForcopies[s]=-1-s;
        }
        for (int i = 0; i < cityCount; i++) {
            int j = 0;
            for (City cityShow : City.values()){
                System.out.printf("%-30s%d\n", cityShow,j);
                j++;
            }

            //choose from list
            System.out.printf("Choose from the list and enter the city number\n");
            int chosenCity = scanner.nextInt();
            //checks if there is a duplicate city and if there is not, it continues
            checkForcopies[i]=chosenCity;
            while (checkForduplicates(checkForcopies)){
                System.out.printf("you have assigned a city more than one time , please reconsider your decision\n");
                chosenCity=scanner.nextInt();
                checkForcopies[i]=chosenCity;
            }
            //if there is no duplicates, it assigns the first one
            cities[i]=cityList[chosenCity];
            //clears the console
            System.out.flush();
        }
        //assigns cities array to cities of OP
        citiesOfoperation = cities;

        //





    }






    //getters

    //first name getter
    public String getFirstName() {
        return firstName;
    }

    //last name getter
    public String getLastName() {
        return lastName;
    }

    //national code getter
    public long getNationalCode() {
        return nationalCode;
    }

    //id num getter
     public long getIdentityNumber() {
        return identityNumber;
    }

    //birth date getter
    public ir.ac.kntu.Date getBirthDate() {
        return birthDate;
    }

    //employment date getter
    public Date getEmploymentDate() {
        return employmentDate;
    }

    //city of op getter


    public City[] getCitiesOfoperation() {
        return citiesOfoperation;
    }

    //country of op getter

    public Country[] getCountriesOfoperation() {
        return CountriesOfoperation;
    }

    // married ?
    public boolean isMarried(){
        return this.maritalStatus;
    }

//    // international?
//    public boolean isInternational(){
//        return this.internationalStatus;
//    }





    //setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setIdentityNumber(long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public void setBirthDate(int year , int month , int day) {
        this.birthDate =  new Date(year, month, day);
    }

    public void setEmploymentDate(int year , int month , int day) {
        this.employmentDate = new Date(year ,month ,day);
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

//    public void setInternationalStatus(boolean internationalStatus) {
//        this.internationalStatus = internationalStatus;
//    }

    public void setCitiesOfoperation(City[] citiesOfoperation) {
        this.citiesOfoperation = citiesOfoperation;
    }

    public void setCountriesOfoperation(Country[] countriesOfoperation) {
        CountriesOfoperation = countriesOfoperation;
    }

    // print birthdate
    public void printBirthDate(){
        System.out.println(this.birthDate.getYear()+"/"+this.birthDate.getMonth()+"/"+this.birthDate.getDay());
    }


    //print employment date
    public void printEmploymentDate(){
        System.out.println(this.employmentDate.getYear()+"/"+this.employmentDate.getMonth()+"/"+this.employmentDate.getDay());
    }

    //check for duplicates
    public boolean checkForduplicates(int[] checkArray){
        for (int i = 0; i < checkArray.length; i++) {
            for (int j = i+1; j < checkArray.length ; j++) {
                if (checkArray[i]==checkArray[j]){
                    return true ;
                }
            }
        }
        return false;
    }

    //check national code being 10 digit
    public boolean checkIftenDigit(long number){
        long remain =number;
        int counter = 0 ;
        while (remain!=0){
            remain/=10;
            counter++;
        }
        if (counter==10){
            return true;
        }
        else {
            return false;
        }
    }

    //check ID
    public boolean checkID(long number){
        long remain =number;
        int counter = 0 ;
        while (remain!=0){
            remain/=10;
            counter++;
        }
        if (counter<=10){
            return true;
        }
        else {
            return false;
        }
    }


    //check the date
    public boolean checkDate(int year , int month , int day){
        if (year>1 && month>1 && day>1){
            if ((year>=1280) && (((month<=6) && (day>=1&&day<=31)) || ((month>=7 && month<=12)&&(day<=30)))){
                return true ;
            }
        }
        return false ;
    }

    //check employment date
    public boolean checkEmploymentDate(int year , int month , int day){
        if (year>1 && month>1 && day>1){
            if ((year>=1280 && year-this.birthDate.getYear()>=18) && (((month<=6) && (day>=1&&day<=31)) || ((month>=7 && month<=12)&&(day<=30)))){
                return true ;
            }
        }
        return false ;
    }


}
