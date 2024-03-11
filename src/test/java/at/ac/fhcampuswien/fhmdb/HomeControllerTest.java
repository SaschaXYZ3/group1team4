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
    void filteredListByString_LowerCase_iron() {

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

        ObservableList<Movie> filteredList = homeController.filteredListByString(movies, "iron");

        //then
        assertTrue(filteredList.contains(movie1));
        assertTrue(filteredList.contains(movie2));
       // assertTrue(filteredList.contains(movie3)); --> false Test if used

    }

    @Test
    void filteredListByString_Uppercase_IRON() {

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

        ObservableList<Movie> filteredList = homeController.filteredListByString(movies, "IRON");

        //then
        assertTrue(filteredList.contains(movie1));
        assertTrue(filteredList.contains(movie2));
        // assertTrue(filteredList.contains(movie3)); --> false Test if used

    }

    @Test
    void filteredListByGenre_DRAMA() {

        //given
        HomeController homeController = new HomeController();
        ObservableList <Movie> movies = FXCollections.observableArrayList();
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
        ObservableList<Movie> filteredGenreList = homeController.filteredListByGenre(movies, Genre.DRAMA);
        //then
        //assertTrue(filteredGenreList.contains(movie1)); --> Test false if used
        //assertTrue(filteredGenreList.contains(movie2)); --> Test false if used
        assertTrue(filteredGenreList.contains(movie3));
        assertTrue(filteredGenreList.contains(movie4));
    }
}