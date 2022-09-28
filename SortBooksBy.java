package andrei.albu.year2020.myhistoryasareader;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class SortBooksBy {

    /**
     * Compare two strings with the assumption that Book.DEFAULT_STRING is greater than every other character
     * At this moment Book.DEFAULT_STRING is equal to '-'
     * @param str1 first string
     * @param str2 second string
     * @return negative number if str1 is lower than str2, 0 if str1 is equal to str2, positive number otherwise
     */
    private static int compareStringsBook(String str1,String str2){
        if(str1.equals(str2)){
            return 0;
        }
        else if(str1.equals(Book.DEFAULT_STRING)){
            return 1;
        }
        else if(str2.equals(Book.DEFAULT_STRING)){
            return -1;
        }
        return str1.compareTo(str2);
    }

    private static int compareIntStringFormatBooks(String str1,String str2) throws NumberFormatException{
        if(str1.equals(str2)){
            return 0;
        }
        else if(str1.equals(Book.DEFAULT_STRING)){
            return 1;
        }
        else if(str2.equals(Book.DEFAULT_STRING)){
            return -1;
        }

        try{
            int str1Int = Integer.parseInt(str1);
            int str2Int = Integer.parseInt(str2);

            if(str1Int<str2Int){
                return -1;
            }
            else {
                return 1;
            }
        }
        catch (NumberFormatException e){
            throw e;
        }

    }
    /**
     * Sort an ArrayList>Book> by 'title'
     * @param books ArrayList to sort
     */
    public static void title(ArrayList<Book> books){
        mergesortBooksByTitle(books);
    }

    /**
     * Helper method for title(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByTitle(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByTitle(left);
        mergesortBooksByTitle(right);

        mergeByTitle(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByTitle(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByTitle(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(compareStringsBook(b.get(ib).getTitle(),(c.get(ic).getTitle()))<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }

    /**
     * Sort an ArrayList>Book> by 'author'
     * @param books ArrayList to sort
     */
    public static void author(ArrayList<Book> books){
        mergesortBooksByAuthor(books);
    }

    /**
     * Helper method for author(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByAuthor(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByAuthor(left);
        mergesortBooksByAuthor(right);

        mergeByAuthor(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByAuthor(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByAuthor(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(compareStringsBook(b.get(ib).getAuthor(),(c.get(ic).getAuthor()))<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }


    /**
     * Sort an ArrayList>Book> by 'genre'
     * @param books ArrayList to sort
     */
    public static void genre(ArrayList<Book> books){
        mergesortBooksByGenre(books);
    }

    /**
     * Helper method for genre(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByGenre(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByGenre(left);
        mergesortBooksByGenre(right);

        mergeByGenre(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByGenre(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByGenre(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(compareStringsBook(b.get(ib).getGenre(),(c.get(ic).getGenre()))<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }


    /**
     * Sort an ArrayList>Book> by 'language'
     * @param books ArrayList to sort
     */
    public static void language(ArrayList<Book> books){
        mergesortBooksByLanguage(books);
    }

    /**
     * Helper method for language(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByLanguage(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByLanguage(left);
        mergesortBooksByLanguage(right);

        mergeByLanguage(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByLanguage(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByLanguage(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(compareStringsBook(b.get(ib).getLanguage(),(c.get(ic).getLanguage()))<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }


    /**
     * Sort an ArrayList>Book> by 'number of pages'
     * @param books ArrayList to sort
     */
    public static void numberOfPages(ArrayList<Book> books){
        mergesortBooksByNumberOfPages(books);
    }

    /**
     * Helper method for numberOfPages(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByNumberOfPages(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByNumberOfPages(left);
        mergesortBooksByNumberOfPages(right);

        mergeByNumberOfPages(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByNumberOfPages(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByNumberOfPages(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(compareIntStringFormatBooks(b.get(ib).getNumberOfPages(),c.get(ic).getNumberOfPages())<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }


    /**
     * Sort an ArrayList>Book> by 'personal rating'
     * @param books ArrayList to sort
     */
    public static void personalRating(ArrayList<Book> books){
        mergesortBooksByPersonalRating(books);
    }

    /**
     * Helper method for personalRating(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByPersonalRating(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByPersonalRating(left);
        mergesortBooksByPersonalRating(right);

        mergeByPersonalRating(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByPersonalRating(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByPersonalRating(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(b.get(ib).getPersonalRating().getRating()<c.get(ic).getPersonalRating().getRating())
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }


    /**
     * Sort an ArrayList>Book> by 'reading start date'
     * @param books ArrayList to sort
     */
    public static void readingStartDate(ArrayList<Book> books){
        mergesortBooksByReadingStartDate(books);
    }

    /**
     * Helper method for readingStartDate(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByReadingStartDate(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByReadingStartDate(left);
        mergesortBooksByReadingStartDate(right);

        mergeByReadingStartDate(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByReadingStartDate(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByReadingStartDate(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(b.get(ib).getStartReadingDate().compareTo(c.get(ic).getStartReadingDate())<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }


    /**
     * Sort an ArrayList>Book> by 'readingEndDate'
     * @param books ArrayList to sort
     */
    public static void readingEndDate(ArrayList<Book> books,Context context){
        mergesortBooksByReadingEndDate(books,context);
    }

    /**
     * Helper method for readingReadingEndDate(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByReadingEndDate(ArrayList<Book> a,Context context)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByReadingEndDate(left,context);
        mergesortBooksByReadingEndDate(right,context);

        mergeByReadingEndDate(a,left,right,context);
    }

    /**
     * Helper method for mergesortBooksByReadingEndDate(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByReadingEndDate(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c,Context context)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(b.get(ib).getFinishReadingDate().compareTo(c.get(ic).getFinishReadingDate())<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }


    /**
     * Sort an ArrayList>Book> by 'dateWasAddedOnTheApp'
     * @param books ArrayList to sort
     */
    public static void dateWasAddedOnTheApp(ArrayList<Book> books){
        mergesortBooksByDateWasAddedOnTheApp(books);
    }

    /**
     * Helper method for dateWasAddedOnTheApp(ArrayList<Book>) method
     * @param a ArrayList to sort
     */
    private static void mergesortBooksByDateWasAddedOnTheApp(ArrayList<Book> a)
    {
        if(a==null) return;
        if(a.size()<2) return; //base case

        int mid = a.size()/2;
        ArrayList<Book> left = new ArrayList<>(mid);
        ArrayList<Book> right = new ArrayList<>(a.size()-mid);
        for(int i=0;i<mid;i++){
            left.add(a.get(i));
        }

        for(int i=mid;i<a.size();i++){
            right.add(a.get(i));
        }

        mergesortBooksByDateWasAddedOnTheApp(left);
        mergesortBooksByDateWasAddedOnTheApp(right);

        mergeByDateWasAddedOnTheApp(a,left,right);
    }

    /**
     * Helper method for mergesortBooksByDateWasAddedOnTheApp(ArrayList<Book> a) method. Merge the two ArrayList<Book> b and c in the a
     * @param a final ArrayList<Book>
     * @param b left ArrayList<Book>
     * @param c right ArrayList<Book>
     */
    private static void mergeByDateWasAddedOnTheApp(ArrayList<Book> a, ArrayList<Book> b, ArrayList<Book> c)
    {
        int ia = 0,ib = 0, ic = 0;
        while(ib<b.size() && ic<c.size())
        {
            if(b.get(ib).getWhenWasAddedOnTheApp().compareTo(c.get(ic).getWhenWasAddedOnTheApp())<0)
            {
                a.set(ia++,b.get(ib++));
            }
            else
            {
                a.set(ia++,c.get(ic++));
            }
        }

        while(ib<b.size())
        {
            a.set(ia++,b.get(ib++));
        }
        while(ic<c.size())
        {
            a.set(ia++,c.get(ic++));
        }
    }

    public static ArrayList<Book> reverseArrayListBook(ArrayList<Book> books){
        ArrayList<Book> booksList = new ArrayList<>();

        for(int i=books.size()-1;i>=0;i--){
            booksList.add(books.get(i));
        }

        return booksList;

    }
}
