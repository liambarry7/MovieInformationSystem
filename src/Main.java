public class Main {
    public static void main(String[] args) {

        /* Tasks
        1 - Display collection of movies in descending order of duration
        2 - display the lowest rated sci-fi movie
        3 - fifth most recent PG rated movie
        4 - Movie with the longest name
        5 - number of years seperating oldest and newest
        */
        MovieDatabase.readTextFile();
        MovieDatabase.task2();
        MovieDatabase.task3();
        MovieDatabase.task4();
        MovieDatabase.task5();
        MovieDatabase.task6();



    }
}