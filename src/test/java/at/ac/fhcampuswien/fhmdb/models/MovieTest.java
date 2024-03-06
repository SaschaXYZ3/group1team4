package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;
import at.ac.fhcampuswien.fhmdb.HomeController;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
        @Test
        void initializeMovies_set_a_list_of_movies(){
            //given
            Movie movie1 = new Movie("Iron Man", "Flying Man in metal suit", "ACTION");
            //when
            boolean actual = Movie.initializeMovies().contains(movie1.getTitle());
            //then
            assertTrue(actual);
    }




    @Test
    void filtered_Movies_by_String() {
            //given

            HomeController homeController = new HomeController();
            String query = "iron";

            List<Movie> target = List.of(
                    new Movie("Iron Man", "Flying Man in metal suit", "ADVENTURE"),
                    new Movie("Iron Man 2", "Flying Man in metal suit", "ADVENTURE")
            );


        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie("Iron Man", "Flying Man in metal suit", "ADVENTURE");
        movies.add(movie1);
        Movie movie2 = new Movie("Iron Man 2", "Flying Man in metal suit", "ADVENTURE");
        movies.add(movie2);
        Movie movie3 = new Movie("Life Is Beautiful", "When an open-minded Jewish librarian and his son become victims of" +
                "the Holocaust he uses a perfect mixture of will, humor, and imagination to protect his son" +
                "from the dangers around their camp.", "ADVENTURE");
        movies.add(movie3);
        Movie movie4 = new Movie("The Usual Suspects", "A sole survivor tells of the twisty events leading up to a horrific" +
                "gun battle on a boat which begin when five criminals meet at seemingly random police lineup.",
                "ADVENTURE");
        movies.add(movie4);

            //when

            List<Movie> results = homeController.filterMovies(movies, query);

            //then
            assertTrue(results.contains(target));
    }
}