package ir.ac.kntu;

public class Date {
    private int year ;
    private int month ;
    private int day ;


    //constructor

    public Date(int year , int month , int day){
        if (checkDate(year, month, day)){
            setYear(year);
            setMonth(month);
            setDay(day);
        }
    }

    //getters
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }



    //setters
    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
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


    //print date
    public void printDate(){
        System.out.println(this.year+"/"+this.month+"/"+this.day);
    }




}
