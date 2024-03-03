package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;
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
    void filtered_Movies_by_String_Iron() {
            //given
        List<Movie> filterdMovies = Arrays.asList(
                new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE,Genre.DRAMA)),
                new Movie("Iron Man 2", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE,Genre.FANTASY))
        );
        //when
        boolean actual; //= filterdMovies.equals(Movie.filteredListByString(Movie.initializeMovies(), "Iron"));
        actual = filterdMovies.contains(Movie.filteredListByString(Movie.initializeMovies(), "Iron"));
        //then
        assertTrue(actual);
    }
}