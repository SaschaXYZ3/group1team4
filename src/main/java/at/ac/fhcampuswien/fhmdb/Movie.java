package at.ac.fhcampuswien.fhmdb;

import java.util.ArrayList;
import java.util.List;

public class Movie {


    String title;
    String description;
    List<String> genres = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**public static List<Movie> initializeMovies(){

    }*/
}
