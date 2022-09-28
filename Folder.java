package andrei.albu.year2020.myhistoryasareader;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.Calendar;

class folderNotContainsBooksOrFoldersException extends RuntimeException{}



public class Folder{
    private String key;
    private String name;
    private boolean containsBooks;
    Folder parent;

    public Folder(String name,boolean containsBooks,Folder parent){
        this.name = name.toUpperCase();
        this.containsBooks = containsBooks;
        key = name + LocalDateTime.now().toString();
        this.parent = parent;
    }

    public Folder(String name,boolean containsBooks,String key,Folder parent){
        this.name = name.toUpperCase();
        this.containsBooks = containsBooks;
        this.key = key;
        this.parent = parent;
    }
    
    public String getKey(){return key;}

    public String getName(){return name;}

    public boolean getContainsBooks(){
        return containsBooks;
    }

    public Folder getParent() {
        return parent;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setContainsBooks(boolean containsBooks){
        this.containsBooks = containsBooks;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public String toJsonString(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public static Folder fromJsonString(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,Folder.class);
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Folder)){
            return false;
        }
        if(this.key.equals(((Folder) obj).getKey())){
            return true;
        }
        return false;
    }
}
