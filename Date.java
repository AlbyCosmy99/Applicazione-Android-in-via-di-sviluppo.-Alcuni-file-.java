package andrei.albu.year2020.myhistoryasareader;

import java.time.LocalDate;
import java.time.LocalTime;

class WrongDateException extends RuntimeException{}

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(){
        day = 0;
        month = 0;
        year = 0;
    }
    public Date(int day,int month,int year) throws WrongDateException{
        if(day<1 || day>31){
            throw new WrongDateException();
        }
        if(month<1 || month>12){
            throw new WrongDateException();
        }
        if(year<1){
            throw new WrongDateException();
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    public Date now(){
        String localDateString = java.time.LocalDate.now().toString();

        try{
            year = Integer.parseInt(localDateString.substring(0,4));
            month = Integer.parseInt(localDateString.substring(5,7));
            day = Integer.parseInt(localDateString.substring(8));
        }catch(NumberFormatException e){
            day = 0;
            month = 0;
            year = 0;
        }

        return this;
    }

    public int compareTo(Date date){
        //date 0(zero) is bigger than any other date

        if(year==0){
            if(year==date.getYear()){
                return 0;
            }
            return 1;
        }

        //year is surely != from 0(zero)

        if(date.getYear()==0){
            return -1;
        }
        //years are different from zero

        if(year<date.getYear()){
            return -1;
        }
        if(year>date.getYear()){
            return 1;
        }
        //years are equal and different from zero

        if(month==0){
            if(month==date.getMonth()){
                return 0;
            }
            return 1;
        }

        //month is surely != from 0(zero)

        if(date.getMonth()==0){
            return -1;
        }

        //months are different from zero

        if(month<date.getMonth()){
            return -1;
        }
        if(month>date.getMonth()){
            return 1;
        }
        //months are equal and different from zero

        if(day==0){
            if(day==date.getDay()){
                return 0;
            }
            return 1;
        }

        //day is surely != from 0(zero)

        if(date.getDay()==0){
            return -1;
        }

        //days are different from zero

        if(day<date.getDay()){
            return -1;
        }
        if(day>date.getDay()){
            return 1;
        }
        //days are equal and different from zero
        //dates are equal
        return 0;
    }

    public boolean dayIsNull(){
        if (day==0){
            return true;
        }
        return false;
    }

    public boolean monthIsNull(){
        if (month==0){
            return true;
        }
        return false;
    }

    public boolean yearIsNull(){
        if (year==0){
            return true;
        }
        return false;
    }

    public boolean isNull(){
        if(dayIsNull() && monthIsNull() && yearIsNull()){
            return true;
        }
        return false;
    }

    public void setStringDate(String date){
        try{
            String[] ints = date.split("/");
            this.day = Integer.parseInt(ints[0]);
            this.month = Integer.parseInt(ints[1]);
            this.year = Integer.parseInt(ints[2]);
        }
        catch(Exception e){
            this.day = 0;
            this.month = 0;
            this.year = 0;
        }
    }
}
