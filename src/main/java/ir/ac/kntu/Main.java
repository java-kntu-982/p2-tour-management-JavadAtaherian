package ir.ac.kntu;

import java.util.*;



public class Main {
    public static LinkedList<Tourleader> tourleaders = new LinkedList<Tourleader>() ;
    public static LinkedList<Tour> tours = new LinkedList<>();

    public static void main(String[] args) {

////        Good for showing one location
//        MapUtil.showMap("Shiraz");
//        MapUtil.showMap("@29.6257966,52.5563165,17z");
////        Good for showing two locations
//        City myvr[] = City.values();
//        MapUtil.showMap(myvr[0].toString(),myvr[100].toString());

//        Date date = new Date(1380,12,31);
//        date.printDate();

        //how to show enums
//        int i = 0;
//        for (Country myvar : Country.values()){
//            System.out.printf("%-30s%d\n", myvar,i);
//            i++;
//        }


//        Tourleader tourleader = new Tourleader();
//        tourleader.printEmploymentDate();
//        tourleader.print();
//
//        Country[] mybh = tourleader.getCountriesOfoperation();
//        for (int i = 0; i <mybh.length ; i++) {
//            System.out.println(mybh[i].toString());
//        }
//
//
//
//        City[] myvb = tourleader.getCitiesOfoperation();
//        System.out.println(myvb.length);
//        for (int i = 0; i < myvb.length ; i++) {
//            System.out.println(myvb[i].toString());
//
//        }

//        Tour tour = new Tour();
//        tour.print();

        //--------------------------------------------------------------------------------------------
















    }



    public void mainMenu(){
        System.out.println("Enter 1 for Tourleader's menu ");
        System.out.println("Enter 2 for Tour's menu");
        System.out.println("Enter 3 for map's menu");
        System.out.println("Enter 4 for Countries");
        System.out.println("Enter 5 for Cities");
        System.out.println("Enter 6 to go back to main");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                tourLeaderMenu();
                break;

            case 2:
                tourMenu();
                break;

            case 3:
                mapMenu();
                break;

            case 4:
                MapAndSearch.showAllCountries();
                break;

            case 5:
                MapAndSearch.showAllCities();
                break;

            case 6:
                backToMain();
                break;

            default:
                while (userInput!=1&&userInput!=2&&userInput!=3&&userInput!=4&&userInput!=5){
                    System.out.println("please enter a number between 1 to 5:");
                    userInput = scanner.nextInt();
                }
        }
    }

    //-------------------------------------------------------------------------------------

    public void tourLeaderMenu(){
        System.out.println("Enter 1 to add a tourleader");
        System.out.println("Enter 2 to delete a tourleader");
        System.out.println("Enter 3 to see every tourleader");
        System.out.println("Enter 4 for Countries");
        System.out.println("Enter 5 for Cities");
        System.out.println("Enter 6 to go back to main");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                addTourLeader();
                break;

            case 2:
                removeTourleader();
                break;

            case 3:
                showAllTourLeaders();
                break;

            case 4:
                MapAndSearch.showAllCountries();
                break;

            case 5:
                MapAndSearch.showAllCities();
                break;

            case 6:
                backToMain();
                break;

            default:
                while (userInput!=1&&userInput!=2&&userInput!=3&&userInput!=4&&userInput!=5){
                    System.out.println("please enter a number between 1 to 5:");
                    userInput = scanner.nextInt();
                }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------

    //tour menu
    public void tourMenu(){
        System.out.println("Enter 1 to add a tour");
        System.out.println("Enter 2 to delete a tour");
        System.out.println("Enter 3 to see every tour");
        System.out.println("Enter 4 for Countries");
        System.out.println("Enter 5 for Cities");
        System.out.println("Enter 6 to search for all local tours ");
        System.out.println("Enter 7 to search for all foreign tours");
        System.out.println("Enter 6 to go back to main");
        System.out.println("Enter 8 to search tours based on area");
        System.out.println("Enter 9 to search based on Days");
        System.out.println("Enter 10 to search based on price");
        System.out.println("Enter 11 to search based on price higher");
        System.out.println("Enter 12 to search based on price less");
        System.out.println("Enter 13 to search based on price between");
        System.out.println("Enter 14 to search based start date between");
        System.out.println("Enter 15 to search based on finishing date between");
        System.out.println("Enter 16 to search based on price between");
        System.out.println("Enter 17 to go Back to main");


        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        String string ;

        switch (userInput){
            case 1:
                addTour();
                break;

            case 2:
                removeTour();
                break;

            case 3:
                showAllTours();
                break;

            case 4:
                MapAndSearch.showAllCountries();
                break;

            case 5:
                MapAndSearch.showAllCities();
                break;

            case 6:
                MapAndSearch.searchForLocalTour();
                break;

            case 7:
                MapAndSearch.searchForForeignTours();
                break;

            case 8:
                System.out.println("Enter the area name");
                string = scanner.nextLine();
                MapAndSearch.searchToursBasedOnArea(string);
                break;

            case 9:
                System.out.println("Enter the amount of days you want");
                userInput = scanner.nextInt();
                MapAndSearch.searchToursBasedOnDays(userInput);
                break;

            case 10:
                System.out.println("Enter the amount of price you want");
                userInput = scanner.nextInt();
                MapAndSearch.searchToursBasedOnPrice(userInput);
                break;

            case 11:
                System.out.println("Enter the amount of price you want");
                userInput = scanner.nextInt();
                MapAndSearch.searchToursBasedOnPriceBigger(userInput);
                break;

            case 12:
                System.out.println("Enter the amount of price you want");
                userInput = scanner.nextInt();
                MapAndSearch.searchToursBasedOnPriceLess(userInput);
                break;

            case 13:
                System.out.println("Enter the amount of 2 price you want");
                userInput = scanner.nextInt();
                int userinput2 = scanner.nextInt();
                MapAndSearch.searchToursBasedOnPriceBetween(userInput,userinput2);
                break;

            case 14:
                System.out.println("Enter the  starting point you want");
                Date date = new Date(0,0,0);

                MapAndSearch.searchToursBasedOnStartingPoint(date);
                break;

            case 15:
                System.out.println("Enter the finishing point you want");
                Date date2 = new Date(0,0,0);

                MapAndSearch.searchToursBasedOnFinishingPoint(date2);
                break;
//            case 16:
//                System.out.println("Enter the amount of price you want");
//                userInput = scanner.nextInt();
//                MapAndSearch.searchToursBasedOnPriceLess(userInput);
//                break;


            case 17:
                backToMain();
                break;





            default:
                while (userInput!=1&&userInput!=2&&userInput!=3&&userInput!=4&&userInput!=5){
                    System.out.println("please enter a number between 1 to 5:");
                    userInput = scanner.nextInt();
                }
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------

    //map menu
    public void mapMenu(){
        System.out.println("Enter 1 to see a place you want on the map");
        System.out.println("Enter 2 to see a desired rout on the map");
        System.out.println("Enter 4 for Countries");
        System.out.println("Enter 5 for Cities");
        System.out.println("Enter 6 to go back to main");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        String userString ;
        String userString2;

        switch (userInput){
            case 1:
                System.out.println("Enter the name of your desired place to see on the map");
                userString = scanner.nextLine();
                MapAndSearch.drawOneLocation(userString);
                break;

            case 2:
                System.out.println("Enter the name of your desired place to see on the map");
                userString = scanner.nextLine();
                userString2 = scanner.nextLine();
                MapAndSearch.drawRoutes(userString,userString2);
                break;

            case 3:
                showAllTours();
                break;

            case 4:
                MapAndSearch.showAllCountries();
                break;

            case 5:
                MapAndSearch.showAllCities();
                break;

            case 6:
                backToMain();
                break;

            default:
                while (userInput!=1&&userInput!=2&&userInput!=3&&userInput!=4&&userInput!=5){
                    System.out.println("please enter a number between 1 to 5:");
                    userInput = scanner.nextInt();
                }
        }
    }













    //-------------------------------------------------------------------------------------------------------------------------------------
    //add tourleader
    public void addTourLeader(){
        Main.tourleaders.add(new Tourleader());
    }


    //remove tourleader
    public void removeTourleader(){
        Scanner scanner = new Scanner(System.in);
        showAllTourLeaders();
        System.out.println("Choose a tourleader to be deleted.:");
        int chosenOne =scanner.nextInt();
        while (chosenOne>tourleaders.size()||chosenOne<0){
            System.out.println("try again");
            chosenOne =scanner.nextInt();
        }
        tourleaders.remove(chosenOne);
    }



    //show all tourleaders
    public void showAllTourLeaders(){
        for (int i = 0; i < tourleaders.size(); i++) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Tourlead No." + i+1);
            tourleaders.get(i).print();
        }
    }

    //show all tours
    public void showAllTours(){
        for (int i = 0; i < tours.size(); i++) {
            tours.get(i).print();
        }
    }



    //add tour
    public void addTour(){
        Main.tours.add(new Tour());
    }


    //remove tour
    public void removeTour(){
        Scanner scanner = new Scanner(System.in);
        showAllTours();
        System.out.println("Choose a tour to be deleted.:");
        int chosenOne =scanner.nextInt();
        while (chosenOne>tours.size()||chosenOne<0){
            System.out.println("try again");
            chosenOne =scanner.nextInt();
        }
        tours.remove(chosenOne);
    }

    //back to main
    public void backToMain(){
        mainMenu();
    }










}
