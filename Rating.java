package andrei.albu.year2020.myhistoryasareader;

/**
 * Class thrown if a Rating class with an invalid rating is created.
 */
class WrongRatingException extends RuntimeException{}

/**
Rating of a book.
*/
public class Rating{
    public static final int MIN_RATING = 1;
    public static final int MAX_RATING = 10;
    private int rating;

    public Rating(){
        rating = 0;
    }
    public Rating(int rating) throws WrongRatingException{
        if(rating<MIN_RATING-1 || rating>MAX_RATING){
            throw new WrongRatingException();
        }
        this.rating = rating;
    }

    public int getMinRating() {
        return MIN_RATING;
    }

    public int getMaxRating() {
        return MAX_RATING;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String toString(){
        return getRating() + "/" + getMaxRating();
    }
}
