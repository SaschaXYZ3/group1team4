package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private final List<Genre> genres;
    private String title;
    private String description;

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
        List<Movie> movies = new ArrayList<>();
                Movie movie1 = new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE, Genre.COMEDY));
                movies.add(movie1);
                Movie movie2 = new Movie("Iron Man 2", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE));
                movies.add(movie2);
                Movie movie3 = new Movie("Life Is Beautiful", "When an open-minded Jewish librarian and his son become victims of" +
                        "the Holocaust he uses a perfect mixture of will, humor, and imagination to protect his son" +
                        "from the dangers around their camp.", Arrays.asList(Genre.DRAMA, Genre.ROMANCE));
                movies.add(movie3);
                Movie movie4 = new Movie("The Usual Suspects", "A sole survivor tells of the twisty events leading up to a horrific" +
                        "gun battle on a boat which begin when five criminals meet at seemingly random police lineup.",
                        Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY));
                movies.add(movie4);
                Movie movie5 = new Movie("Puss in Boots", "An outlaw cat his childhood egg-friend, and a seductive thief kitty set out in " +
                        "search for the eggs of the fabled Golden Goose to clear his name, restore his lost" +
                        "honor and regain the trust of his mother and town.", Arrays.asList(Genre.COMEDY, Genre.FAMILY, Genre.ANIMATION));
                movies.add(movie5);
                Movie movie6 = new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn " +
                        "between following his orders and protecting the world he feels is his" +
                        "home.", Arrays.asList(Genre.ANIMATION, Genre.DRAMA, Genre.ACTION));
                movies.add(movie6);
                Movie movie7 = new Movie("The Wolf of Wall Street", "Based on the true Story of Jordan Belfort from his rise ö wealthy " +
                        "stock-broker living the high life to his fall involving crime, corruption and the federal" +
                        "government.", Arrays.asList(Genre.DRAMA, Genre.ROMANCE, Genre.BIOGRAPHY));
                movies.add(movie7);
                return movies;
    }

    //FIX Genre to String
    public String genreToString(){

        StringBuilder stringBuilder = new StringBuilder();

        for(Genre genre : getGenres()){
            stringBuilder.append(genre.toString());
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

}
