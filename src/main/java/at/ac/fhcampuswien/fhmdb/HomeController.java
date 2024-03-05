package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private static final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll(Genre.values());
        //genreComboBox.setItems(FXCollections.observableArrayList(Genre.values()));
        //movieListView.setItems(Movie.filteredListByGenre(observableMovies,genreComboBox.getValue());
        genreComboBox.setOnAction(event -> {
            movieListView.setItems((ObservableList) filteredListByGenre(observableMovies, (Genre) genreComboBox.getValue()));

        });


        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here
        searchBtn.setOnAction(ActionEvent -> {
            String txt = searchField.getText().toLowerCase();

                filterMovies(allMovies, txt);


        });


        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                movieListView.setItems(sortAscending(movieListView.getItems()));
                sortBtn.setText("Sort (desc)");
            } else {
                // TODO sort observableMovies descending
                movieListView.setItems(sortDescending(movieListView.getItems()));
                sortBtn.setText("Sort (asc)");
            }
        });


    }
    public static ObservableList<Movie> filteredListByString(ObservableList<Movie> movies, String searchWord){

        ObservableList<Movie> filteredMovies = FXCollections.observableList(movies.stream()
                .filter(samplemovie -> samplemovie.getTitle().toLowerCase().contains(searchWord.toLowerCase()))
                .filter(samplemovie -> samplemovie.getDescription().toLowerCase().contains(searchWord.toLowerCase()))
                .collect(Collectors.toList()));

        return  filteredMovies;
    }

    public static List<Movie> filteredListByGenre(List<Movie> movies, Genre genre){

        List<Movie> MoviesGenres = movies.stream().filter(a -> Objects.equals(a.getGenres(), genre)).collect(Collectors.toList());

        return MoviesGenres;
    }

    public static void filterMovies(List<Movie> movies, String txt){
        observableMovies.clear();
        for (Movie movie : movies){
            if (movie.getTitle().toLowerCase().contains(txt) || movie.getDescription().toLowerCase().contains(txt)){
                observableMovies.add(movie);
            }
        }
    }

    //comparator from movie with title
    Comparator<Movie> movieComp = Comparator.comparing(Movie::getTitle);

    public ObservableList<Movie> sortAscending(ObservableList<Movie> movies) {
        movies.sort(movieComp);
        // update sort button with text
        if (sortBtn != null) {
            sortBtn.setText("Sort (desc)");
        }
        return observableMovies;
    }

    public ObservableList<Movie> sortDescending(ObservableList<Movie> movies) {
        movies.sort(movieComp.reversed());
        // update sort button with text
        if (sortBtn != null) {
            sortBtn.setText("Sort (asc)");
        }
        return observableMovies;
    }
}