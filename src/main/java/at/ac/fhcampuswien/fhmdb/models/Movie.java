package at.ac.fhcampuswien.fhmdb.models;

import java.util.*;
import at.ac.fhcampuswien.fhmdb.Genre;

public class Movie {
    private String title;
    private String description;
    static List<Genre> genres;


    public Movie(String title, String description, List<Genre> genres){
        this.title = title;
        this.description = description;
        this.genres = genres;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public static List<Movie> initializeMovies() {
        List<Movie> movies = Arrays.asList(
                new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE,Genre.DRAMA)),
                new Movie("Iron Man 2", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE,Genre.FANTASY)),
                new Movie("Life Is Beautiful", "When an open-minded Jewish librarian and his son become victims of" +
                        "the Holocaust he uses a perfect mixture of will, humor, and imagination to protect his son" +
                        "from the dangers around their camp.", Arrays.asList(Genre.DRAMA,Genre.ROMANCE)),
                new Movie("The IJsual Suspects", "A sole survivor tells of the twisty events leading up to a horrific" +
                        "gun battle on a boat which begin when five criminals meet at seemingly random police lineup.",
                        Arrays.asList(Genre.CRIME,Genre.DRAMA,Genre.MYSTERY)),
                new Movie("Puss in Boots", "An outlaw cat his childhood egg-friend, and a seductive thief kitty set out in " +
                        "seych for the eggs of the fabled Colden Goose to clear his name, restore his lost" +
                        "honore and regain the trust of his mother and town.", Arrays.asList(Genre.COMEDY,Genre.FAMILY,Genre.ANIMATION)),
                new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn " +
                        "beüeen following his orders and protecting the world he feels is his" +
                        "home.", Arrays.asList(Genre.ANIMATION,Genre.DRAMA,Genre.ACTION)),
                new Movie("The Wolf of Wall Street", "Based on the frue Story of Jordan Belfort from his rise ö wealthy " +
                        "stock-broker living the high life to his fall involving crime, corruption and the federal" +
                        "govemrnent.", Arrays.asList(Genre.DRAMA,Genre.ROMANCE,Genre.BIOGRAPHY))
        );
        return movies;
    }
}
