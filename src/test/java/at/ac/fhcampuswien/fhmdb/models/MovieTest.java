package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;
import at.ac.fhcampuswien.fhmdb.HomeController;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
        @Test
        void initializeMovies_set_a_list_of_movies(){
            //given
            Movie movie1 = new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE,Genre.DRAMA));
            //when
            boolean actual = Movie.initializeMovies().contains(movie1.getTitle());
            //then
            assertTrue(actual);
    }




    @Test
    void filtered_Movies_by_String() {
            //given
            HomeController homeController = new HomeController();
            String genre = null;
            String query = "Iron";

            Movie movie1 = new Movie("Harry Potter", "Wizards and Stuff", Arrays.asList(Genre.ADVENTURE));
            Movie movie2 = new Movie("Iron Man", "man in armor", Arrays.asList(Genre.SCIENCE_FICTION));
            Movie movie3 = new Movie("Frozen", "Icy Queen", Arrays.asList(Genre.FANTASY));
            Movie movie4 = new Movie("Life is beautiful", "touching story of father and son", Arrays.asList(Genre.DOCUMENTARY));

            ObservableList<Movie> observableMovies = FXCollections.observableArrayList(movie1, movie2, movie3, movie4);

            //when
            homeController.filteredListByString(observableMovies, query);

            //then
            assertTrue(observableMovies.contains(movie2));

    }
}