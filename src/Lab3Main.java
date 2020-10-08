// Charles Madigan
// September 18, 2020

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab3Main {

    public static ArrayList<Movie2> MovieCollection;
    public static Scanner myInput;

    public static void main(String[] args) {

        // initialize collection
        MovieCollection = new ArrayList<>();

        //Create System.in Scanner
        Scanner sc = new Scanner(System.in);

        //Create loop for finding file (display error message if file not found)
        while (true) {
            String filename;
            System.out.println("Filename: ");
            filename = sc.nextLine();

            try {
                myInput = new Scanner(new FileReader(filename));
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not Found: " + filename);
            }
        }
        //Set Comma as Delimiter
        myInput.useDelimiter(",");

        myInput.nextLine();

        //get data off each line
        while (myInput.hasNext()) {
            String myID = myInput.next();
            String myType = myInput.next();
            String myTitle = myInput.next();
            String myOTitle = myInput.next();
            //get release year, convert to integer, handle exception
            String myRYear = myInput.next();
            //Instantiate ints
            int myPlayTime;
            int myReleaseYear;
            try {
                myReleaseYear = Integer.parseInt(myRYear);
            } catch (NumberFormatException e) {
                myReleaseYear = -1;
            }
            //get playtime in minutes, convert to integer, handle exception
            String myPTime = myInput.next();
            try {
                myPlayTime = Integer.parseInt(myPTime);
            } catch (NumberFormatException e) {
                myPlayTime = 0;
            }
            //Read in Genres as Strings
            String myGenre = myInput.nextLine();

                //Add new movie to array list
                MovieCollection.add(new Movie2(myID, myType, myTitle, myOTitle, myReleaseYear, myPlayTime, myGenre));
            }

            //Create New File "Titles" to display all movie titles
            try {
                FileWriter titleWriter = new FileWriter("Titles");
                for (int i = 0; i < MovieCollection.size(); i++) {
                    titleWriter.write(MovieCollection.get(i).getTitle());
                    titleWriter.write(System.lineSeparator());
                }
            } catch (IOException e) {
                System.out.println("An error has occurred with Titles File.");
            }

            //Create New File "Movies2005-2020" to display all info about all movies from 2005-2020
            try {
                FileWriter Writer = new FileWriter("Movies2005-2020");
                for (int i = 0; i < MovieCollection.size(); i++) {
                    if (MovieCollection.get(i).getReleaseYear() >= 2005) {
                        Writer.write(MovieCollection.get(i).getID() + ", ");
                        Writer.write(MovieCollection.get(i).getType() + ", ");
                        Writer.write(MovieCollection.get(i).getTitle() + ", ");
                        Writer.write(MovieCollection.get(i).getOTitle() + ", ");
                        Writer.write(MovieCollection.get(i).getReleaseYearString() + ", ");
                        Writer.write(MovieCollection.get(i).getPlayTimeString());
                        Writer.write(MovieCollection.get(i).getGenre().myToString());
                        Writer.write(System.lineSeparator());
                    }
                }
            } catch (IOException e) {
                System.out.println("An error has occurred with Movies2005-2020 File");
            }

            //Create New FIle "Documentary" to display all info about only movies in the Documentary Genre
            try {
                FileWriter docWriter = new FileWriter("Documentary");
                for (int i = 0; i < MovieCollection.size(); i++) {
                    if (MovieCollection.get(i).getGenre().myToString().contains("documentary")) {
                        docWriter.write(MovieCollection.get(i).getID() + ", ");
                        docWriter.write(MovieCollection.get(i).getType() + ", ");
                        docWriter.write(MovieCollection.get(i).getTitle() + ", ");
                        docWriter.write(MovieCollection.get(i).getOTitle() + ", ");
                        docWriter.write(MovieCollection.get(i).getReleaseYearString() + ", ");
                        docWriter.write(MovieCollection.get(i).getPlayTimeString());
                        docWriter.write(MovieCollection.get(i).getGenre().myToString());
                        docWriter.write(System.lineSeparator());
                    }
                }
            } catch (IOException e) {
                System.out.println("An error has occurred with Documentary File");
            }

            //Create New File "Title-Year" to display only the title and release year of each movie
            try {
                FileWriter tyWriter = new FileWriter("Title-Year");
                for (int i = 0; i < MovieCollection.size(); i++) {
                    tyWriter.write(MovieCollection.get(i).getTitle() + ", ");
                    tyWriter.write(MovieCollection.get(i).getReleaseYearString());
                    tyWriter.write(System.lineSeparator());
                }
            } catch (IOException e) {
                System.out.println("An error has occurred with Title-Year File");
            }

        //Create New File "Sorted List" to display all the information sorted
        try {
            FileWriter slWriter = new FileWriter("Sorted List");
                Collections.sort(MovieCollection, Movie2.myCompare);
                int year = 2017;
                for (Movie2 x : MovieCollection){
                    if (x.getReleaseYear() < year) {
                        slWriter.write("\r\n");
                    }
                    slWriter.write(x.movieToString(x) + "\r\n");
                    year = x.getReleaseYear();
                }

        } catch (IOException e) {
            System.out.println("An error has occurred with the Sorted List File");
        }
        System.out.println("All appropriate files have been generated!");
    }
    }