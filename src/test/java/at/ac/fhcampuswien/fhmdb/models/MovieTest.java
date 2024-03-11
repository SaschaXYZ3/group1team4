package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.Genre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MovieTest {
    @Test
    void initialize_Movies_set_a_list_of_movies() {
        //given
        Movie movie1 = new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE));

        //when
        boolean actual = Movie.initializeMovies().contains(movie1.getTitle());

        //then
        assertTrue(actual);
    }

    @Test
    void genre_To_String_ANIMATION_DRAMA_ACTION_true() {
        //given
        Movie movieTest = new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora", Arrays.asList(Genre.ANIMATION, Genre.DRAMA, Genre.ACTION));

        //when
        boolean actual;
        if(movieTest.genreToString().equals("ANIMATION DRAMA ACTION ")){
            actual = true;
        }else {
            actual = false;
        }

        //then
        assertTrue(actual);
    }

    @Test
    void genre_To_String_ADVENTURE_false() {
        //given
        Movie movieTest = new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora", Arrays.asList(Genre.ANIMATION, Genre.DRAMA, Genre.ACTION));

        //when
        boolean actual;
        if(movieTest.genreToString().equals("ADVENTURE ")){
            actual = true;
        }else {
            actual = false;
        }

        //then
        assertFalse(actual);
    }
}


