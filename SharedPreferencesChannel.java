package andrei.albu.year2020.myhistoryasareader;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class SharedPreferencesChannel {

    public static final String SHARED_PREFERENCES_NAME_ALLMYBOOKS = "allMyBooks";
    public static final String SHARED_PREFERENCES_NAME_READ = "booksRead";
    public static final String SHARED_PREFERENCES_NAME_NOT_READ = "booksNotRead";
    public static final String SHARED_PREFERENCES_NAME_TO_READ = "toRead";
    public static final String SHARED_PREFERENCES_NAME_READING = "reading";
    public static final String BOOK_IMAGE_S_PREFERENCES = "book_image";
    public static final String FOLDERS_S_PREFERENCES = "container_folders";
    public static final String FOLDERS_WITH_BOOKS ="folders_with_books";
    public static final String CHECKED_FOLDERS ="checked_folders";
    public static final String SHARED_PREFERENCES = "sharedPreferences";
    public static final String SHARED_PREFERENCES_NAME_LAST_LISTFRAGMENT_OPENED = "lastListFragmentOpened";

    /**
     * key for searching option in the shared preferences
     * with name SHARED_PREFERENCES
     */
    public static final String SHARED_PREFERENCES_NAME_SEARCH_OPTION = "searchByOption";
    /**
     * key for sorting option in the shared preferences
     * with name SHARED_PREFERENCES
     */
    public static final String SORT_BY_KEY = "sortingOptionKey";
    /**
     * key for image id for reverse image selection in the shared
     * preferences with name SHARED_PREFERENCES
     */
    public static final String REVERSE_IMAGE_SELECTION = "reverseImage";
    public static final String LAST_LISTFRAGMENT_KEY = "lastListFragment";

    public static final String CURRENCY_KEY = "currency";

    public static final String FAVORITE = "favoriteBooks";

    public static final String BOOK_IMAGE_KEY = "book_image_key";
    public static final String SH_CONTAINS_BOOK_IMAGE = "contains_book_image";

    Context context;
	
    SharedPreferences sharedPreferences;
	
    /**
     * True if it is saving books.
     */
    boolean containsBooks;
	
    boolean containsFolders;

    public SharedPreferencesChannel(Context context,String sharedPreferencesName, boolean containsBooks){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(sharedPreferencesName,Context.MODE_PRIVATE);
        this.containsBooks = containsBooks;
        containsFolders = false;
    }
    public SharedPreferencesChannel(Context context,String sharedPreferencesName, boolean containsBooks,boolean containsFolders){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(sharedPreferencesName,Context.MODE_PRIVATE);
        this.containsBooks = containsBooks;
        if(!containsFolders){
            throw new IllegalUseOfS_PreferencesConstructorWithFolderException();
        }
        this.containsFolders = containsFolders;
    }
    public ArrayList<Book> readSharedPreferencesForBooks(){
        ArrayList<Book> myBooks = new ArrayList<>();
        if(containsBooks){
            Map<String,?> stringMap = sharedPreferences.getAll();
            Set<String> stringSet = stringMap.keySet();

            for(String keyBook : stringSet){
                String stringBook = sharedPreferences.getString(keyBook,"");
                myBooks.add(Book.fromJsonString(stringBook));
            }
        }

        return myBooks;
    }

    public void addBook(Book book){
        if(containsBooks){
            if(sharedPreferences.contains(book.getKey())){
                sharedPreferences.edit().remove(book.getKey()).commit();
            }
            addPairStringString(book.getKey(),book.toJsonString());
        }
    }

    public void removeBook(Book book){
        if(containsBooks){
            if(sharedPreferences.contains(book.getKey())){
                sharedPreferences.edit().remove(book.getKey()).commit();
            }
        }
    }

    public static void updateBook(Book book,Context context){
        SharedPreferencesChannel sp = new SharedPreferencesChannel(context,SHARED_PREFERENCES_NAME_ALLMYBOOKS,true);
        if(sp.contains(book.getKey())){
            sp.addBook(book);
        }
        sp = new SharedPreferencesChannel(context,SHARED_PREFERENCES_NAME_READ,true);
        if(book.isRead()){
            sp.addBook(book);
        }
        else{
            sp.removeBook(book);
        }
        sp = new SharedPreferencesChannel(context,SHARED_PREFERENCES_NAME_TO_READ,true);
        if(book.isToRead()){
            sp.addBook(book);
        }
        else{
            sp.removeBook(book);
        }
        sp = new SharedPreferencesChannel(context,SHARED_PREFERENCES_NAME_NOT_READ,true);
        if(!book.isRead()){
            sp.addBook(book);
        }
        else{
            sp.removeBook(book);
        }
        sp = new SharedPreferencesChannel(context,SHARED_PREFERENCES_NAME_READING,true);
        if(book.isReading()){
            sp.addBook(book);
        }
        else{
            sp.removeBook(book);
        }
        sp = new SharedPreferencesChannel(context,FAVORITE,true);
        if(book.isFavorite()){
            sp.addBook(book);
        }
        else{
            sp.removeBook(book);
        }
    }

    public void addPairStringInt(String key,int value){
        sharedPreferences.edit().putInt(key,value).apply();
    }
    public void clearSharedPreferences(){
        sharedPreferences.edit().clear().apply();
    }

    public void addPairStringString(String key,String value){
        sharedPreferences.edit().putString(key,value).apply();
    }

    /**
     * Method used to read the sort selection stored with the 'key' key
     * @param key the key of the value stored
     * @return the int of the string; default value: R.string.sortByTitle
     */
    public int readSortSelection(String key){
        return sharedPreferences.getInt(key,R.string.sortByTitle);
    }

    /**
     * Method used to read the search selection stored with the 'key' key
     * @param key the key of the value stored
     * @return the int of the string; default value: R.string.searchByTitle
     */
    public int readSearchSelection(String key){
        return sharedPreferences.getInt(key,R.string.searchByTitle);
    }

    /**
     * Method used to read the sort reverse selection stored in the 'key' key
     * @param key the key of the value stored
     * @return the int of the string; default value: R.drawable.increasing_sort
     */
    public int readSortReverseSelection(String key){
        return sharedPreferences.getInt(key,R.drawable.increasing_sort);
    }

    public int readNumberOnBackStack(String key){
        return sharedPreferences.getInt(key,0);
    }

    public String readPairStringString(String key){
        return sharedPreferences.getString(key,"This value should be unreachable.");
    }

    public String readPairStringString(String key,String defaultValue){
        return sharedPreferences.getString(key,defaultValue);
    }

    public int readPairStringInt(String key){
        return sharedPreferences.getInt(key,R.string.emptyString);
    }

    public int readPairStringInt(String key,int defaultValue){
        return sharedPreferences.getInt(key,defaultValue);
    }

    public boolean contains(String key){
        return sharedPreferences.contains(key);
    }

    public ArrayList<Folder> getFolders() {
        ArrayList<Folder> myFolders = new ArrayList<>();
         if (containsFolders) {
             Map<String, ?> stringMap = sharedPreferences.getAll();
             Set<String> stringSet = stringMap.keySet();

             for (String keyFolder : stringSet) {
                 String stringFolder = sharedPreferences.getString(keyFolder, "");
                 myFolders.add(Folder.fromJsonString(stringFolder));
            }
        }
         return myFolders;
    }
}


class IllegalUseOfS_PreferencesConstructorWithFolderException extends RuntimeException{}
