package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HomeControllerTest {

    @Test
    void sortAscending() {
        //TODO write min. one test case for sortAscending
        //given
        HomeController homeController = new HomeController();
        ObservableList<Movie> movies = FXCollections.observableArrayList();

        Movie movie1 = new Movie("Iron Man 2", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE));
        movies.add(movie1);
        Movie movie2 = new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE));
        movies.add(movie2);
        Movie movie3 = new Movie("The Usual Suspects", "A sole survivor tells of the twisty events leading up to a horrific" +
                "gun battle on a boat which begin when five criminals meet at seemingly random police lineup.",
                Arrays.asList(Genre.ADVENTURE));
        movies.add(movie3);
        Movie movie4 = new Movie("Life Is Beautiful", "When an open-minded Jewish librarian and his son become victims of" +
                "the Holocaust he uses a perfect mixture of will, humor, and imagination to protect his son" +
                "from the dangers around their camp.", Arrays.asList(Genre.ADVENTURE));
        movies.add(movie4);

        //when
        homeController.sortAscending(movies);

        //then
        assertTrue(movies.get(0).getTitle() == "Iron Man");
        assertTrue(movies.get(3).getTitle() == "The Usual Suspects");
    }

    @Test
    void sortDescending() {
        //TODO write min. one test case for sortDescending
        //given
        HomeController homeController = new HomeController();
        ObservableList<Movie> movies = FXCollections.observableArrayList();

        Movie movie1 = new Movie("Iron Man 2", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE));
        movies.add(movie1);
        Movie movie2 = new Movie("Iron Man", "Flying Man in metal suit", Arrays.asList(Genre.ADVENTURE));
        movies.add(movie2);
        Movie movie3 = new Movie("The Usual Suspects", "A sole survivor tells of the twisty events leading up to a horrific" +
                "gun battle on a boat which begin when five criminals meet at seemingly random police lineup.",
                Arrays.asList(Genre.ADVENTURE));
        movies.add(movie3);
        Movie movie4 = new Movie("Life Is Beautiful", "When an open-minded Jewish librarian and his son become victims of" +
                "the Holocaust he uses a perfect mixture of will, humor, and imagination to protect his son" +
                "from the dangers around their camp.", Arrays.asList(Genre.ADVENTURE));
        movies.add(movie4);

        //when
        homeController.sortDescending(movies);

        //then
        assertTrue(movies.get(0).getTitle() == "The Usual Suspects");
        assertTrue(movies.get(3).getTitle() == "Iron Man");
    }

    @Test
    void filteredListByString_iron() {
        //TODO write min. one test case for filteredListByString
        //given
        HomeController homeController = new HomeController();
        ObservableList<Movie> movies = FXCollections.observableArrayList();
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
        //when
        homeController.filteredListByString(movies, "iron");
        //then
        assertTrue(movies.contains(movie1));
        assertTrue(movies.contains(movie2));

    }

    @Test
    void filteredListByGenre() {
        //TODO write min. one test case for filteredListByGenre
        //given

        //when

        //then
    }
}