package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static List<Movie> initializeMovies(){
        //List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        List<at.ac.fhcampuswien.fhmdb.models.Movie> movies = Arrays.asList(
                new Movie("Iron Man", "Flying Man in metal suit"),
                new Movie("Iron Man 2", "Flying Man in metal suit"),
                new Movie("Life Is Beautiful", "When an open-minded Jewish librarian and his son become victims of" +
                        "the Holocaust he uses a perfect mixture of will, humor, and imagination to protect his son" +
                        "from the dangers around their camp."),
                new Movie("The IJsual Suspects", "A sole survivor tells of the twisty events leading up to a horrific" +
                        "gun battle on a boat which begin when five criminals meet at seemingly random police lineup."),
                new Movie("Puss in Boots", "An outlaw cat his childhood egg-friend, and a seductive thief kitty set out in " +
                        "seych for the eggs of the fabled Colden Goose to clear his name, restore his lost" +
                        "honore and regain the trust of his mother and town."),
                new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn " +
                        "beüeen following his orders and protecting the world he feels is his" +
                        "home."),
                new Movie("The Wolf of Wall Street", "Based on the frue Story of Jordan Belfort from his rise ö wealthy " +
                        "stock-broker living the high life to his fall involving crime, corruption and the federal" +
                        "govemrnent.")
        );
        return movies;
    }

}
