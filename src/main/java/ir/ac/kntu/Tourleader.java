package ir.ac.kntu;


import java.util.Scanner;

public class Tourleader {
    //attributes
    private String firstName ;
    private String lastName ;
    private int nationalCode ;
    private int identityNumber ;
    private ir.ac.kntu.Date birthDate ;
    private ir.ac.kntu.Date employmentDate ;
    private boolean maritalStatus ;
//    private boolean internationalStatus ;
    private City[] citiesOfoperation ;
    private Country[] CountriesOfoperation ;



    //construct
    public Tourleader(){

        System.out.printf("Enter first name :\n");
        Scanner scanner = new Scanner(System.in);
        setFirstName(scanner.nextLine());

        System.out.printf("Enter last name :\n");
        setLastName(scanner.nextLine());

        System.out.printf("Enter national code :\n");
        setNationalCode(scanner.nextInt());

        System.out.printf("Enter ID number :\n");
        setIdentityNumber(scanner.nextInt());

        System.out.printf("Enter the born year : \n");
        int year = scanner.nextInt();
        System.out.printf("Enter the born month : \n");
        int month = scanner.nextInt();
        System.out.printf("Enter the born day : \n");
        int day = scanner.nextInt();
        setBirthDate(year,month,day);
        System.out.println();
        System.out.printf("Enter employment year : \n");
        year = scanner.nextInt();
        System.out.printf("Enter employment month : \n");
        month = scanner.nextInt();
        System.out.printf("Enter employment day : \n");
        day = scanner.nextInt();
        setEmploymentDate(year,month,day);
        System.out.println();
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

        System.out.printf("");





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
    public int getNationalCode() {
        return nationalCode;
    }

    //id num getter
     public int getIdentityNumber() {
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

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setIdentityNumber(int identityNumber) {
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

}
