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
        while (true){
            Menu.mainMenu();
        }


    }




}
