package andrei.albu.year2020.myhistoryasareader;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Class thrown if a Book returns an invalid priorityReadText
 */
class ReadSmashException extends RuntimeException{}
class NumberOfPagesFormatIllegalException extends RuntimeException{}
class NegativeOrNullNumberOfPagesException extends RuntimeException{}

public class Book {
    public final static String DEFAULT_STRING = "-";

    private String key;
    private String title;
    private int imageID;
    private String imageUriString;
    private String author;
    private boolean read;
    private boolean reading;
    private boolean toRead;
    private String priorityReadText; //the book is read? to be read? not read? reading? to be read and reading have priority over the others.
    private String isbn;
    private boolean favorite;
    private int heartImageID;
    private Date startReadingDate;
    private Date finishReadingDate;
    private Date publicationDate; //when did the author publish the book?
    private boolean loaned; //prestato
    private  boolean borrowed;
    private String genre;
    private String publishing_house;
    private String numberOfPages;
    private String price;
    private andrei.albu.year2020.myhistoryasareader.Rating personalRating;
    private String category;
    private Date whenWasAddedOnTheApp;
    private String language;
    private String description;
    private String notes;
    private ArrayList<Folder> foldersWhichContainTheBook;

    public Book(){
        //default constructor
    }

    public String getKey() {
        return key;
    }

    public String getTitle(){
        return title;
    }

    public int getImageID() {
        return imageID;
    }

    public String getImageUriString(){
        return imageUriString;
    }

    public String getAuthor() {
        return author;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public Date getStartReadingDate() {
        return startReadingDate;
    }

    public Date getFinishReadingDate() {
        return finishReadingDate;
    }

    public int getHeartImageID() {
        return heartImageID;
    }

    public String getPriorityReadText() {
        if(read){
            return "READ";
        }
        if(toRead){
            return "TO READ";
        }
        if(reading){
            return "READING";
        }
        else{
            return "NOT READ";
        }
    }

    public Date getWhenWasAddedOnTheApp() {
        return whenWasAddedOnTheApp;
    }

    public String getPrice() {
        return price;
    }

    public andrei.albu.year2020.myhistoryasareader.Rating getPersonalRating() {
        return personalRating;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<Folder> getFoldersWhichContainTheBook() {
        return foldersWhichContainTheBook;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isReading() {
        return reading;
    }

    public boolean isToRead() {
        return toRead;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setFinishReadingDate(Date finishReadingDate) {
        this.finishReadingDate = finishReadingDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setImageUriString(String imageUriString){
        this.imageUriString = imageUriString;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    public void setNumberOfPages(String numberOfPages) {
        try{
            Integer.parseInt(numberOfPages);
        }catch (Exception e){
            throw new NumberOfPagesFormatIllegalException();
        }
        if(Integer.parseInt(numberOfPages)<=0){
            throw new NegativeOrNullNumberOfPagesException();
        }
        this.numberOfPages = numberOfPages;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setToRead(boolean toRead) {
        this.toRead = toRead;
    }

    public void setHeartImageID(int heartImageID) {
        this.heartImageID = heartImageID;
    }

    public void setPriorityReadText(String priorityReadText) {
        this.priorityReadText = priorityReadText;
    }

    public void setStartReadingDate(Date startReadingDate) {
        this.startReadingDate = startReadingDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPersonalRating(andrei.albu.year2020.myhistoryasareader.Rating personalRating) {
        this.personalRating = personalRating;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setWhenWasAddedOnTheApp(Date whenWasAddedOnTheApp) {
        this.whenWasAddedOnTheApp = whenWasAddedOnTheApp;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setFoldersWhichContainTheBook(ArrayList<Folder> foldersWhichContainTheBook) {
        this.foldersWhichContainTheBook = foldersWhichContainTheBook;
    }

    public static class Builder{
        private String key;
        private String title;
        private int imageID;
        private String imageUriString;
        private String author;
        private boolean read;
        private boolean reading;
        private boolean toRead;
        private String isbn;
        private boolean favorite;
        private Date startReadingDate;
        private Date finishReadingDate;
        private Date publicationDate;
        private boolean loaned; //prestato
        private  boolean borrowed; //preso in prestito
        private String genre;
        private String publishing_house;
        private String numberOfPages;
        private int heartImageID;
        private String priorityReadText;
        private String price;
        private andrei.albu.year2020.myhistoryasareader.Rating personalRating;
        private String category; //???
        private Date whenWasAddedOnTheApp;
        private String language;
        private String description;
        private String notes;
        private ArrayList<Folder> foldersWhichContainTheBook;

        public Builder(String title){
            key = title.toUpperCase();
            this.title = title;
            imageID = R.drawable.default_book_image;
            imageUriString = DEFAULT_STRING;
            author = DEFAULT_STRING;
            genre = DEFAULT_STRING;
            language = DEFAULT_STRING;
            isbn = DEFAULT_STRING;
            publishing_house = DEFAULT_STRING;
            numberOfPages = DEFAULT_STRING;
            price = DEFAULT_STRING;
            publicationDate = new Date();
            read = false;
            toRead = false;
            reading = false;
            personalRating = new andrei.albu.year2020.myhistoryasareader.Rating();
            favorite = false;
            loaned = false;
            borrowed = false;
            startReadingDate = new Date();
            finishReadingDate = new Date();
            whenWasAddedOnTheApp = new Date().now();
            description = "THERE IS NO DESCRIPTION.";
            notes = "YOU HAVEN'T ADDED NOTES YET.";
            heartImageID = R.drawable.empty_heart;
            foldersWhichContainTheBook = new ArrayList<>();
        }

        public Builder imageID(int imageID){
            this.imageID = imageID;
            return this;
        }

        public Builder imageUriString(String imageUriString){
            this.imageUriString = imageUriString;
            return this;
        }

        public Builder author(String author){
            this.author = author;
            return this;
        }

        public Builder read(boolean read){
            this.read = read;
            return this;
        }

        public Builder reading(boolean reading){
            this.reading = reading;
            return this;
        }

        public Builder toRead(boolean toRead){
            this.toRead = toRead;
            return this;
        }

        public Builder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }

        public Builder favorite(boolean favorite){
            this.favorite = favorite;
            return this;
        }

        public Builder startDate(Date startReadingDate){
            this.startReadingDate = startReadingDate;
            return this;
        }

        public Builder finishDate(Date finishReadingDate){
            this.finishReadingDate = finishReadingDate;
            return this;
        }

        public Builder publicationDate(Date publicationDate){
            this.publicationDate = publicationDate;
            return this;
        }

        public Builder loaned(boolean loaned){
            this.loaned = loaned;
            return this;
        }

        public Builder borrowed(boolean borrowed){
            this.borrowed = borrowed;
            return this;
        }

        public Builder genre(String genre){
            this.genre = genre;
            return this;
        }

        public Builder publishing_house(String publishing_house){
            this.publishing_house = publishing_house;
            return this;
        }

        public Builder numberOfPages(String numberOfPages){
            try{
                Integer.parseInt(numberOfPages);
            }catch (Exception e){
                throw new NumberOfPagesFormatIllegalException();
            }
            if(Integer.parseInt(numberOfPages)<=0){
                throw new NegativeOrNullNumberOfPagesException();
            }
            this.numberOfPages = numberOfPages;
            return this;
        }

        public Builder heartImageID(int heartImageID){
            this.heartImageID = heartImageID;
            return this;
        }

        public Builder priorityReadText(String priorityReadText){
            this.priorityReadText = priorityReadText;
            return this;
        }

        public Builder price(String price){
            this.price = price;
            return this;
        }

        public Builder personalRating(andrei.albu.year2020.myhistoryasareader.Rating personalRating){
            this.personalRating = personalRating;
            return this;
        }

        public Builder category(String category){
            this.category = category;
            return this;
        }

        public Builder whenWasAddedOnTheApp(Date whenWasAddedOnTheApp){
            this.whenWasAddedOnTheApp = whenWasAddedOnTheApp;
            return this;
        }

        public Builder language(String language){
            this.language = language;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder notes(String notes){
            this.notes = notes;
            return this;
        }

        public Builder foldersWhichContainTheBook(ArrayList<Folder> foldersWhichContainTheBook){
            this.foldersWhichContainTheBook = foldersWhichContainTheBook;
            return this;
        }

        public Book build(){
            Book book = new Book();

            book.key = key;
            book.title = title;
            book.imageID = imageID;
            book.imageUriString = imageUriString;
            book.author = author;
            book.borrowed = borrowed;
            book.loaned = loaned;
            book.favorite = favorite;
            book.startReadingDate = startReadingDate;
            book.finishReadingDate = finishReadingDate;
            book.publicationDate = publicationDate;
            book.isbn = isbn;
            book.genre = genre;
            book.read = read;
            book.toRead = toRead;
            book.reading = reading;
            book.publishing_house = publishing_house;
            book.numberOfPages = numberOfPages;
            book.heartImageID = heartImageID;
            book.priorityReadText = priorityReadText;
            book.price = price;
            book.personalRating = personalRating;
            book.category = category;
            book.whenWasAddedOnTheApp = whenWasAddedOnTheApp;
            book.language = language;
            book.description = description;
            book.notes = notes;
            book.foldersWhichContainTheBook = foldersWhichContainTheBook;

            return book;
        }
    }

    public String toJsonString(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public static Book fromJsonString(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,Book.class);
    }

    public static ArrayList<Book> booksWithStringCostraint(ArrayList<Book> books, String s, int searchBy){
        String check ="";
        if(searchBy==R.string.searchByAuthor){
            check = "True";
        }

        ArrayList<Book> newBooks = new ArrayList<>();
        switch (searchBy){
            case R.string.searchByTitle:
                for(Book book : books){
                    if(book.getTitle().startsWith(s.toLowerCase()) || book.getTitle().startsWith(s.toUpperCase())){
                        newBooks.add(book);
                    }
                }
                break;
            case R.string.searchByAuthor:
                for(Book book : books){
                    if(book.getAuthor().startsWith(s.toLowerCase()) || book.getAuthor().startsWith(s.toUpperCase())){
                        newBooks.add(book);
                    }
                }
                break;
            case R.string.searchByGenre:
                for(Book book : books){
                    if(book.getGenre().startsWith(s.toLowerCase()) || book.getGenre().startsWith(s.toUpperCase())){
                        newBooks.add(book);
                    }
                }
                break;
            case R.string.searchByLanguage:
                for(Book book : books){
                    if(book.getLanguage().startsWith(s.toLowerCase()) || book.getLanguage().startsWith(s.toUpperCase())){
                        newBooks.add(book);
                    }
                }
                break;
            case R.string.searchByPersonalRating:
                for(Book book : books){
                    if(Integer.toString(book.getPersonalRating().getRating()).equalsIgnoreCase(s)){
                        newBooks.add(book);
                    }
                }
                break;
        }
        return newBooks;
    }
}

