package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

public class MapAndSearch {

    //draw one place
    public static void drawOneLocation(String theLocation){
        MapUtil.showMap(theLocation);
    }

    //draw a route
    public static void drawRoutes(String orginal , String destination){
        MapUtil.showMap(orginal,destination);
    }



    //search for local tours
    public static void searchForLocalTour(){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (!Main.tours.get(i).getKind()){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");

    }

    //search for foreign tours
    public static void searchForForeignTours(){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getKind()){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }

    //search tours based on days
    public static void searchToursBasedOnDays(int days){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getDays()==days){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }

    //search tours based on price
    public static void searchToursBasedOnPrice(int price){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getPrice()==price){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }

    //search tours based on price bigger than
    public static void searchToursBasedOnPriceBigger(double price){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getPrice()>=price){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }

    //search tours based on price
    public static void searchToursBasedOnPriceLess(double price){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getPrice()<price){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }

    //search tours based on price
    public static void searchToursBasedOnPriceBetween(double price1 , double price2){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getPrice()>=price1 && Main.tours.get(i).getPrice()<=price2){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }


    //search tours based on area
    public static void searchToursBasedOnArea(String area){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getArea().equalsIgnoreCase(area)){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }

    //search tours based on day plans
    public static void searchToursBasedOnDayPlans(String plan){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            for (int j = 0; j < Main.tours.get(i).getDayPlans().length ; j++) {
                if (Main.tours.get(i).getDayPlans()[j].equalsIgnoreCase(plan)){
                    Main.tours.get(i).print();
                    success++;
                    break;
                }
            }
            if (success==0)
                System.out.println("No compatibility!");

        }
    }

    //search tours based on their first and last name
    public static void searchToursBasedOnTourLeadersName(String firstname , String lastname){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getTheTourLeader().getFirstName().equalsIgnoreCase(firstname) && Main.tours.get(i).getTheTourLeader().getFirstName().equalsIgnoreCase(lastname)){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }

    //search tours based on a certain date
    public static void searchToursBasedOnStartingPoint(Date thedate){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getStartDate().equalsto(thedate)){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }


    public static void searchToursBasedOnFinishingPoint(Date thedate){
        int success = 0;
        for (int i = 0; i < Main.tours.size(); i++) {
            if (Main.tours.get(i).getFinishDate().equalsto(thedate)){
                Main.tours.get(i).print();
                success++;
            }
        }
        if (success==0)
            System.out.println("No compatibility!");
    }


    //show all cities
    public static void showAllCountries(){
        int i = 0;
        for (Country myCountrySet : Country.values()){
            System.out.printf("%-30s%d\n", myCountrySet,i);
            i++;
        }
    }

    //show all cities
    public static void showAllCities(){
        int i = 0;
        for (City myCitySet : City.values()){
            System.out.printf("%-30s%d\n", myCitySet,i);
            i++;
        }
    }
















}
