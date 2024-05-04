public class Movie implements Comparable<Movie> {

    //https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/
    private String name;
    private int year;
    private String ageRating;
    private String genre;
    private int runTime;
    private float rating;

    public Movie(String name, int year, String ageRating, String genre, int runTime, float rating) {
        this.name = name;
        this.year = year;
        this.ageRating = ageRating;
        this.genre = genre;
        this.runTime = runTime;
        this.rating = rating;
    }

    public String toString() {
        return name + "," + year + "," + ageRating + "," + genre + "," + runTime + "," + rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public int getRunTime() {
        return runTime;
    }

    public float getRating() {
        return rating;
    }

    @Override //https://www.youtube.com/watch?v=wboqZ2dPDtQ&list=LL&index=1&t=5s
    public int compareTo(Movie o) { //comparing the object we are calling the method on & the object passed into the method
        if (this.runTime == o.runTime) {
            return 0;
        } else if (this.runTime < o.runTime) { //descending order
            return 1;
        } else {
            return -1;
        }
    }
}
