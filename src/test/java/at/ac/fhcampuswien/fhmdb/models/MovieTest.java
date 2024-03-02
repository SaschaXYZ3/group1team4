package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}