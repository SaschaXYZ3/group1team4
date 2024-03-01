package at.ac.fhcampuswien.fhmdb;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void initializeMovies_set_a_list_of_movies(){
        //given
        Movie movie1 = new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.FANTASY, Genre.ADVENTURE));
        //when
        boolean actual = Movie.initializeMovies().contains(movie1.getTitle());
        //then
        assertTrue(actual);
    }

}