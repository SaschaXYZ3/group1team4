package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
        @Test
        void initializeMovies_set_a_list_of_movies(){
            //given
            Movie movie1 = new Movie("Iron Man", "Flying Man in metal suit");
            //when
            boolean actual = Movie.initializeMovies().contains(movie1.getTitle());
            //then
            assertTrue(actual);

    }
}