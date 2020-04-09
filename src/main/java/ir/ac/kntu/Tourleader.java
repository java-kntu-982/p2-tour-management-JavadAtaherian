package ir.ac.kntu;


import java.util.Scanner;

public class Tourleader {
    //attributes
    private String firstName ;
    private String lastName ;
    private String nationalCode ;
    private String identityNumber ;
    private ir.ac.kntu.Date birthDate ;
    private ir.ac.kntu.Date employmentDate ;
    private boolean maritalStatus ;
//    private boolean internationalStatus ;
    private City[] citiesOfoperation ;
    private Country[] countriesOfoperation ;



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
        String nationalCode = scanner.nextLine();
        while (!checkIftenDigit(nationalCode)){
            System.out.printf("you have entered a number that is not 10 digit , try again\n");
            nationalCode = scanner.nextLine();
        }
        setNationalCode(nationalCode);

        // ID number and checking
        System.out.printf("Enter ID number :\n");
        String idNumber = scanner.nextLine();
        while (!checkID(idNumber)){
            System.out.printf("you have entered a number that is more than 10 digit , try again\n");
            idNumber = scanner.nextLine();
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
        while (!Date.checkDate(year,month,day)){
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
        System.out.printf("Are you married ? \n ( Y/y for yes and N/n for no) \n");
        String question = scanner.next();
        if (question.equals("Y")||question.equals("y") || question.equals("Yea")||question.equals("yes")){
            setMaritalStatus(true);
        } else if (question.equals("N")||question.equals("n") || question.equals("No")||question.equals("no")){
            setMaritalStatus(false);
        } else{
            System.out.printf("You have entered sth else , we take that as a No \n");
            setMaritalStatus(false);
        }





        System.out.printf("How many countries are going to be handled by this tour leader?\n");
        int countryCount = scanner.nextInt();
        System.out.printf("How many cities(in Iran) are going to be handled by this tour leader? \n");
        int cityCount = scanner.nextInt();


        Country[] countries = new Country[countryCount];
        Country[] countryList = Country.values();
        City[] cities = new City[cityCount+countryCount];
        City[] cityList = City.values();

        int[] countryCopies = new int[countryCount];
        for (int s = 0; s < countryCopies.length; s++) {
            countryCopies[s]=-1-s;
        }

        int[] checkForcopies = new int[cityCount];
        for (int s = 0; s < checkForcopies.length; s++) {
            checkForcopies[s]=-1-s;
        }



        //assigning cities
        for (int i = 0; i < cityCount; i++) {


            for (int k=194 ; k<226 ; k++){
                System.out.printf("%-30s%d\n", cityList[k].toString(),k);
            }

            //choose from list
            System.out.printf("Choose from the list and enter the city number (if you want to choose TEHRAN , in the next section choose iran)\n");
            int chosenCity = scanner.nextInt();
            //checks if there is a duplicate city and if there is not, it continues
            checkForcopies[i]=chosenCity;
            while (checkForduplicates(checkForcopies)||chosenCity<0||chosenCity>225){
                System.out.printf("you have assigned a city more than one time or chose an out of range code , please reconsider your decision\n");
                chosenCity=scanner.nextInt();
                checkForcopies[i]=chosenCity;
            }
            //if there is no duplicates, it assigns the first one
            cities[i]=cityList[chosenCity];
            //clears the console
            System.out.flush();
        }


        /////////////////////////////////////////////////////////////////////////////////////////////////


        //assigning countries
        for (int i = 0; i < countryCount; i++) {
            int j = 0;
            for (Country countryShow : Country.values()){
                System.out.printf("%-30s%d\n", countryShow,j);
                j++;
            }

            //choose from list
            System.out.printf("Choose from the list and enter the country number\n");
            int chosenCountry = scanner.nextInt();
            //checks if there is a duplicate country and if there is not, it continues
            countryCopies[i]=chosenCountry;
            while (checkForduplicates(countryCopies)||chosenCountry<0||chosenCountry>193){
                System.out.printf("you have assigned a country more than one time or chose an out of range code, please reconsider your decision\n");
                chosenCountry=scanner.nextInt();
                countryCopies[i]=chosenCountry;
            }
            //if there is no duplicates, it assigns the first one
            countries[i]=countryList[chosenCountry];
            //clears the console
            System.out.flush();
        }
        //assigns countries array to countries if OP
        countriesOfoperation = countries;

        //adding chosen countries's capitals to the end of the cities array
        for (int i = cityCount; i < countryCount+cityCount; i++) {
            cities[i]=cityList[countryCopies[i-cityCount]];
        }

        //assigns cities array to cities of OP
        citiesOfoperation = cities;


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
    public String getNationalCode() {
        return nationalCode;
    }

    //id num getter
    public String getIdentityNumber() {
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
        return countriesOfoperation;
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

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setIdentityNumber(String identityNumber) {
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
        this.countriesOfoperation = countriesOfoperation;
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
    public boolean checkIftenDigit(String number){
        if(number.matches("[0-9]+") && number.length() == 10) {
            return true;
        }
        return false;
    }


    //check ID
    public boolean checkID(String number){
        if (number.matches("[0-9]+") && number.length() >=3 && number.length()<=10) {
            return true;
        }
        return false;
    }


    //check employment date
    public boolean checkEmploymentDate(int year , int month , int day){
        if (year>1 && month>1 && day>1){
            if ((year>=1280 && year-this.birthDate.getYear()>=18) && (((month<=6) && (day<=31)) || ((month>=7 && month<=12)&&(day<=30)))){
                return true ;
            }
        }
        return false ;
    }


    //print
    public void print(){
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
        System.out.println("National Code : " + this.nationalCode);
        System.out.println("ID Number: " + this.identityNumber);
        this.birthDate.printDate();
        this.employmentDate.printDate();
        System.out.println(this.isMarried());
        System.out.println("Countries Of Operation: ");
        for (int i = 0; i < this.countriesOfoperation.length; i++) {
            System.out.println(countriesOfoperation[i]);
        }
        System.out.println("Cities Of Operation: ");
        for (int i = 0; i < this.citiesOfoperation.length; i++) {
            System.out.println(citiesOfoperation[i]);
        }
        System.out.println("----------------------------------------------------------------------");
    }

    //show tourleader's citeies of operation on the map
    public void drawTourLeaderCities(){
        for (int i = 0; i < this.citiesOfoperation.length; i++) {
            MapAndSearch.drawOneLocation(this.citiesOfoperation[i].toString());
        }
    }

    //show tourleader's countries of operation on the map
    public void drawTourLeaderCountries(){
        for (int i = 0; i < this.countriesOfoperation.length; i++) {
            MapAndSearch.drawOneLocation(this.countriesOfoperation[i].toString());
        }
    }




}
