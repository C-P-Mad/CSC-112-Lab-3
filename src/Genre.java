import java.util.ArrayList;
import java.util.Scanner;

public class Genre {
    ArrayList<String> myMovieGenres = new ArrayList();

public Genre(String genre) {
    //Create Scanner Object
    Scanner sc;

    //Make Strings lowercase
    genre = genre.toLowerCase();

    //Try to read genres
    try{
        sc = new Scanner(genre);
    } catch (Exception e){
        System.out.println("An Error occurred in reading genres");
        System.exit(0);
        return;
    }
    //Set Delimiter
    sc.useDelimiter(",");

    //Read genres into array list
    while(sc.hasNext()){
        myMovieGenres.add(sc.next());
    }

}
public String myToString(){
    String stringGenres = "";
    for (int i = 0; i < myMovieGenres.size(); i++){
        stringGenres = stringGenres + ", " + myMovieGenres.get(i);
    }
return stringGenres;
}

public boolean isGenre(String genre){
    if (myMovieGenres.contains(genre)){
        return true;}
    else {
        return false;}
    }
}