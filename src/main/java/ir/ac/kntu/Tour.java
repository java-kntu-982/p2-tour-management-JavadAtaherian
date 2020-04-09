package ir.ac.kntu;

import java.util.Scanner;
//import java.util.*;

public class Tour {
    private String name ;
    private boolean kind ; // international ?
//    private Country countryArea ;
//    private City cityarea ;
    private String area ;
    private City origin ;
    private City destination;
    private int nights ;
    private int days ;
    private Date startDate;
    private Date finishDate ;
    private double price ;
    private boolean transportation ; // air or land based travel
    private String[] nightPlans;
    private String[] dayPlans;


    ///////////////////////////////////////////////////////////////////////////////

    //constructor
    public Tour(){
        Scanner scanner = new Scanner(System.in);

        //name
        System.out.printf("Enter the tours name : \n");
        setName(scanner.nextLine());

        //international ?
        System.out.printf("Is this tour international ? ('y' for yes and 'n' no)\n");
        String question = scanner.next();
        if (question.equals("Y")||question.equals("y") || question.equals("Yea")||question.equals("yes")){
            setKind(true);
        } else if (question.equals("N")||question.equals("n") || question.equals("No")||question.equals("no")){
            setKind(false);
        } else{
            System.out.printf("You have entered sth else , we take that as a No \n");
            setKind(false);
        }

        //set area based on being international
        Country[] countryList = Country.values();
        City[] cityList = City.values();
        if (this.kind){
            int j = 0;
            for (Country countryShow : Country.values()){
                System.out.printf("%-30s%d\n", countryShow,j);
                j++;
            }

            //choose from list
            System.out.printf("Choose from the list and enter the country number\n");
            int chosenCountry = scanner.nextInt();
            while(chosenCountry<0||chosenCountry>193){
                System.out.printf("you have  chose an out of range code , please reconsider your decision\n");
                chosenCountry = scanner.nextInt();
            }
            setArea(countryList[chosenCountry].toString());
        } else{

            for (int k=194 ; k<226 ; k++){
                System.out.printf("%-30s%d\n", cityList[k].toString(),k);
            }

            //choose from list
            System.out.printf("Choose from the list and enter the city number\n");
            int chosenCity = scanner.nextInt();
            while(chosenCity<0||chosenCity<193||chosenCity>225){
                System.out.printf("you have  chose an out of range code , please reconsider your decision\n");
                chosenCity = scanner.nextInt();
            }
            setArea(cityList[chosenCity].toString());

        }


        //origin from all cities
        int j = 0;
        for (City cityShow : City.values()){
            System.out.printf("%-30s%d\n", cityShow,j);
            j++;
        }
        System.out.printf("Choose the origin : \n");
        int chosenOrigin = scanner.nextInt();
        setOrigin(cityList[chosenOrigin]);


        //destination based in being international
        if (this.kind){
            int l = 0;
            for (Country countryShow : Country.values()){
                System.out.printf("%-30s%d\n", countryShow,l);
                l++;
            }

            System.out.printf("Choose the destination country: \n");
            int chosenDestinationCountry = scanner.nextInt();
            while(chosenDestinationCountry<0||chosenDestinationCountry>193){
                System.out.printf("you have  chose an out of range code , please reconsider your decision\n");
                chosenDestinationCountry = scanner.nextInt();
            }
            setDestination(cityList[chosenDestinationCountry]);


        } else{

            for (int k=194 ; k<226 ; k++){
                System.out.printf("%-30s%d\n", cityList[k].toString(),k);
            }

            //choose from iran's states
            System.out.printf("Choose the destination city from the list and enter the city number\n");
            int chosenCityofDestination = scanner.nextInt();
            while(chosenCityofDestination<0||chosenCityofDestination>225||chosenCityofDestination<=193){
                System.out.printf("you have  chose an out of range code , please reconsider your decision\n");
                chosenCityofDestination = scanner.nextInt();
            }
            setDestination(cityList[chosenCityofDestination]);


        }


        //days
        System.out.printf("How many days this tour is going to take ? \n");
        int theNights = scanner.nextInt();
        if (theNights>0){
            setNights(theNights);
        }

        //nights
        System.out.printf("How many nights this tour is going to take ? \n");
        int thedays = scanner.nextInt();
        if (thedays>0){
            setDays(thedays);
        }

        //start Date
        System.out.printf("Enter year , month ,  day\n");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        while (!checkDate(year,month,day)){
            System.out.printf("you have entered some irrational numbers pls try again\n");
            System.out.printf("Enter year , month ,  day\n");
            year = scanner.nextInt();
            month = scanner.nextInt();
            day = scanner.nextInt();
        }
        setStartDate(new Date(year,month,day));



        // finish date
        if (thedays>theNights){
            day+=thedays;
            setFinishDate(new Date(year,month,day));
        } else{
            day+=nights;
            setFinishDate(new Date(year,month,day));
        }


        //price
        System.out.printf("How much this tour would cost ? : \n");
        double thePrice = scanner.nextFloat();
        if (thePrice>0){
            setPrice(thePrice);
        }

        //transport
        System.out.printf("Choose the fotm of transportation ? ('a for air and 'land' no)\n");
        String question2 = scanner.next();
        if (question2.equals("A")||question2.equals("a") || question2.equals("Air")||question2.equals("air")){
            setTransportation(true);
        } else if (question2.equals("L")||question2.equals("l") || question2.equals("Land")||question2.equals("land")){
            setTransportation(false);
        } else{
            System.out.printf("You have entered sth else , we take that as a land-based travel \n");
            setTransportation(false);
        }

        //day plans
        this.dayPlans = new String[this.days];
        String thePlan ;
        System.out.printf("write each day's plan (names of places that are going to be visited) -caution : DO NOT USE SPACES , INSTEAD USE '-' \n");
        for (int i = 0; i < this.dayPlans.length; i++) {
            System.out.printf("Day %d  Plan : \n" , i+1);
            thePlan = scanner.next();
            this.dayPlans[i]=thePlan;
        }

        //night plans
        this.nightPlans = new String[this.nights];
        String theNightPlan ;
        System.out.printf("write each night's plan (names of places that are going to be visited) -caution : DO NOT USE SPACES , INSTEAD USE '-' \n");
        for (int i = 0; i < this.nightPlans.length; i++) {
            System.out.printf("Night %d  Plan : \n" , i+1);
            theNightPlan = scanner.next();
            this.nightPlans[i]=theNightPlan;
        }





    }





    //////////////////////////////////////////////////////////////////////////////
    //getters


    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestination() {
        return destination;
    }

    public int getNights() {
        return nights;
    }

    public int getDays() {
        return days;
    }

    public double getPrice() {
        return price;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String[] getDayPlans() {
        return dayPlans;
    }

    public String[] getNightPlans() {
        return nightPlans;
    }


    /////////////////////////////////////////////////////////////
    //setters


    public void setName(String name) {
        this.name = name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setKind(boolean kind) {
        this.kind = kind;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public void setTransportation(boolean transportation) {
        this.transportation = transportation;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDayPlans(String[] dayPlans) {
        this.dayPlans = dayPlans;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public void setNightPlans(String[] nightPlans) {
        this.nightPlans = nightPlans;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    ////////////////////////////////////////////////////////////

    //check the date
    public boolean checkDate(int year , int month , int day){
        if (year>1 && month>1 && day>1){
            if ((year>=1280) && (((month<=6) && (day>=1&&day<=31)) || ((month>=7 && month<=12)&&(day<=30)))){
                return true ;
            }
        }
        return false ;
    }

    //clear screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //print
    public void print(){
        System.out.println("Tour's name:" + this.getName());
        System.out.println("International ?" + this.kind);
        System.out.println("Area : " + this.getArea());
        System.out.println("Origin city : " + this.getOrigin().toString());
        System.out.println("Destination city : " + this.getDestination().toString());
        System.out.println("Nights : " + this.getNights());
        System.out.println("Days : " + this.getDays());
        System.out.println("Start date : "+this.getStartDate().getYear() + "/" + this.getStartDate().getMonth() + "/" + this.getStartDate().getDay());
        System.out.println("Finish date : " +this.getFinishDate().getYear() + "/" + this.getFinishDate().getMonth() + "/" + this.getFinishDate().getDay());
        System.out.println("Price :" + this.getPrice());
        System.out.println("Air travel ?" + this.transportation);
        System.out.println("Day Plans:");
        for (int i = 0; i < this.dayPlans.length; i++) {
            System.out.printf("Day %d plan : %s \n" ,i+1, dayPlans[i]);
        }
        System.out.println("-----------------------------");
        System.out.println("Night Plans :");
        for (int i = 0; i < this.nightPlans.length; i++) {
            System.out.printf("Night %d plan : %s \n" , i+1 , nightPlans[i]);
        }




    }






}

