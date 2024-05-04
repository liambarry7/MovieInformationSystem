import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;



public class MovieDatabase {
    public static ArrayList<Movie> listOfMovies = new ArrayList<>(); //global arraylist which can be accessed anywhere within the package
    public static void readTextFile() {
        try {
//            String folderDirectory = System.getProperty("user.dir") + "\\movies.txt";
            String folderDirectory = "movies.txt"; // for PASS
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            String textLine;

            while ((textLine = read.readLine()) != null) { //while there is still a line to read in the file
                //Regex to find if there are any commas within speech marks, e.g. The good, the bad and the ugly
                String[] nextMovie = textLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); //https://www.baeldung.com/java-split-string-commas
                Movie newMovie = new Movie(nextMovie[0], Integer.parseInt(nextMovie[1]), nextMovie[2], nextMovie[3], Integer.parseInt(nextMovie[4]), Float.parseFloat(nextMovie[5]));
                listOfMovies.add(newMovie);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void task2() {
        //print movies in descending order of runtime
        Collections.sort(listOfMovies);
        System.out.println("Movies in descending order of duration: ");
        for (int i = 0; i < listOfMovies.size(); i++){
            System.out.println(listOfMovies.get(i).getName() + ", " + listOfMovies.get(i).getYear() + ", " + listOfMovies.get(i).getAgeRating() + ", " + listOfMovies.get(i).getGenre() + ", " + listOfMovies.get(i).getRunTime() + ", " + listOfMovies.get(i).getRating());
        }
        System.out.println();
    }

    public static void task3() {
        //lowest rated sci-fi film
        ArrayList<Movie> sciFiMovies = new ArrayList<>();
        
        //add movie to new list if the genre includes sci-fi
        for (int i = 0; i < listOfMovies.size(); i++) {            
            if (listOfMovies.get(i).getGenre().contains("Sci-Fi")) {
                sciFiMovies.add(listOfMovies.get(i));
            }
        }

        //Sets the first movie in the sciFiMovies list to be the default lowest rated scifi film
        Movie lowestRatedSciFi = sciFiMovies.get(0);
        for (int i = 0; i < sciFiMovies.size(); i++) { // for (datatype item : array) - (enhanced for loop)

            //everytime the rating is lower than the object stored in lowestRatedSciFi, the object is stored in that variable
            if (sciFiMovies.get(i).getRating() < lowestRatedSciFi.getRating()) {
                lowestRatedSciFi = sciFiMovies.get(i);
            }
        }

        System.out.println("The lowest rated Sci-Fi film is: " + lowestRatedSciFi.toString() + "\n");
        
    }

    public static void task4() {
        //5th most recent PG films
        ArrayList<Movie> pgMovies = new ArrayList<>();

        //add movie to new list if the rating is PG
        for (int i = 0; i < listOfMovies.size(); i++) {
            if (listOfMovies.get(i).getAgeRating().equals("\"PG\"")) {
                pgMovies.add(listOfMovies.get(i));
            }
        }

        // Order pgMovies by descending release date
        ArrayList<Movie> orderedBNF = sortByNewestFilm(pgMovies);
        System.out.println("The fifth newest PG rated film is: " + orderedBNF.get(4).toString()  + "\n");

    }

    public static ArrayList<Movie> sortByNewestFilm(ArrayList<Movie> movies) {
        // bubble sort to order films by newest
        for (int i = 0; i < movies.size(); i++) { // https://github.com/liambarry7/NEAStadiumBookingSystem/blob/master/src/library/sortsAndSearches.java
            for (int j = 0; j < movies.size() - i - 1; j++) {
                if (movies.get(j).getYear() < movies.get(j+1).getYear()) {
                    Movie temporary = movies.get(j);
                    movies.set(j, movies.get(j+1));
                    movies.set(j+1, temporary);
                }
            }
        }
        return movies;
    }

    public static void task5() {
        //film with the longest name
        int nameSize = 0;
        Movie longestTitle = listOfMovies.get(0); //Sets the first movie in the listOfMovies list to be the default longest titles film
        for (int i = 0; i < listOfMovies.size(); i++) {
            if (nameSize < listOfMovies.get(i).getName().length()) { //if title length is greater than nameSize...
                longestTitle = listOfMovies.get(i);
                nameSize = longestTitle.getName().length(); //update the lenght of the current longest named film
            }
        }

        System.out.println("The film with the longest title is: " + longestTitle.toString() + "\n");
    }

    public static void task6() {
        //number of years separating oldest and youngest film
        //set oldest and youngest year of a film to the first film in the listOfMovies
        int oldestYear = listOfMovies.get(0).getYear(); //year of oldest film
        int youngestYear = listOfMovies.get(0).getYear(); //year of youngest film
        Movie oldestFilm = listOfMovies.get(0);
        Movie youngestFilm = listOfMovies.get(0);

        for (int i = 0; i < listOfMovies.size(); i++) {
            if (listOfMovies.get(i).getYear() < oldestYear) {
                oldestYear = listOfMovies.get(i).getYear();
                oldestFilm = listOfMovies.get(i);
            } else if (listOfMovies.get(i).getYear() > youngestYear) {
                youngestYear = listOfMovies.get(i).getYear();
                youngestFilm = listOfMovies.get(i);
            }
        }
        System.out.println("The oldest film is: " + oldestFilm.toString());
        System.out.println("The youngest film is: " + youngestFilm.toString());
        System.out.println("Difference between oldest and youngest film: " + (youngestYear - oldestYear));
    }



}

