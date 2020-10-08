import java.util.Comparator;

public class Movie2 {
    String myID;
    String myType;
    String myTitle;
    String myOTitle;
    int myPlayTime;
    int myReleaseYear;
    Genre myGenre;

    public Movie2(String ID, String Type, String Title, String OTitle, int ReleaseYear, int PlayTime, String genre) {
        myID = ID;
        myType = Type;
        myTitle = Title;
        myOTitle = OTitle;
        myPlayTime = PlayTime;
        myReleaseYear = ReleaseYear;
        myGenre = new Genre(genre);
    }

    //Create Getters
    public String getID() {
        return myID;
    }

    public String getType() {
        return myType;
    }

    public String getTitle() {
        return myTitle;
    }

    public String getOTitle() {
        return myOTitle;
    }

    public int getReleaseYear() {
        return myReleaseYear;
    }

    //Create String Variant Getters for printing ints more easily
    public String getReleaseYearString() {
        String myReleaseYearString = Integer.toString(myReleaseYear);
        return myReleaseYearString;
    }

    public String getPlayTimeString() {
        String myPlayTimeString = Integer.toString(myPlayTime);
        return myPlayTimeString;
    }

    public Genre getGenre() {
        return myGenre;
    }

    //Create Setters (which btw are never used in this assignment :D)
    public void setID(String ID) {
        myID = ID;
    }

    public void setType(String Type) {
        myType = Type;
    }

    public void setTitle(String title) {
        myTitle = title;
    }

    public void setOTitle(String OTitle) {
        myOTitle = OTitle;
    }

    public void setReleaseYear(int releaseYear) {
        myReleaseYear = releaseYear;
    }

    public void setPlayTime(int playtime) {
        myPlayTime = playtime;
    }

    public void setGenre(Genre genre) {
        myGenre = genre;
    }

    public String movieToString(Movie2 movie) {
        String movieString = "";

        movieString = movie.getID();
        movieString = movieString + ", " + movie.getType();
        movieString = movieString + ", " + movie.getTitle();
        movieString = movieString + ", " + movie.getOTitle();
        movieString = movieString + ", " + movie.getReleaseYearString();
        movieString = movieString + ", " + movie.getPlayTimeString();
        movieString = movieString + ", " + movie.getGenre().myToString();
        return movieString;
    }

    public static Comparator<Movie2> myCompare = new Comparator<Movie2>() {

        @Override
        public int compare(Movie2 A, Movie2 B) {
            if (A.getReleaseYear() > B.getReleaseYear()) {
                return -1;
            } else if (B.getReleaseYear() > A.getReleaseYear()) {
                return 1;
            } else {
                return A.getTitle().toLowerCase().compareTo(B.getTitle().toLowerCase());
            }
        }
    };
}
