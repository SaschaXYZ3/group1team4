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
    public JFXButton clearBtn;

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

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data
        observableMovies.addAll(allMovies);         // add dummy data to observable list

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

            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.addAll(allMovies);
            /*
            String txt = searchField.getText().toLowerCase();

            if (txt == null || txt.isEmpty()) {
                return;
            }
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.addAll(filterMovies(allMovies, txt));
            */
            if (!searchField.getText().isBlank()) {
                setupMovieListView();
                movieListView.setItems(filteredListByString(observableMovies, searchField.getText()));
            }

            if (!genreComboBox.getSelectionModel().isEmpty()) {
                movieListView.setItems(filteredListByGenre(observableMovies, Genre.valueOf(genreComboBox.getValue().toString())));
            }
        });


        clearBtn.setOnAction(actionEvent -> {
            searchField.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.addAll(allMovies);
        });


        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {

            if (sortBtn.getText().equals("Sort (asc)")) {
                //  sort observableMovies ascending
                movieListView.setItems(sortAscending(movieListView.getItems()));
                sortBtn.setText("Sort (desc)");
            } else {
                //  sort observableMovies descending
                movieListView.setItems(sortDescending(movieListView.getItems()));
                sortBtn.setText("Sort (asc)");
            }
        });
    }

    //TODO correct filter
    /*public static ObservableList<Movie> filteredListByString(ObservableList<Movie> movies, String searchWord) {
        ObservableList<Movie> filteredMovies = FXCollections.observableList(movies.stream().filter(sampleMovie ->
                sampleMovie.getTitle().toLowerCase().contains(searchWord.toLowerCase())).filter(sampleMovie ->
                sampleMovie.getDescription().toLowerCase().contains(searchWord.toLowerCase())).collect(Collectors.toList()));
        return filteredMovies;
    }*/

    public ObservableList<Movie> filteredListByString(ObservableList<Movie> movies, String searchWord) {
        String searchLower = searchWord.toLowerCase();

        ObservableList<Movie> filteredMovies = FXCollections.observableList(movies.stream().filter(sampleMovie ->
                        sampleMovie.getDescription().toLowerCase().contains(searchLower) || sampleMovie.getTitle()
                                .toLowerCase().contains(searchLower)).collect(Collectors.toList()));
        return filteredMovies;
    }

    private void setupMovieListView() {
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }

    //TODO check if it works, no clue because visibility from genre doesn't works
    public static ObservableList<Movie> filteredListByGenre(ObservableList<Movie> movies, Genre genre) {
        ObservableList<Movie> moviesGenres = FXCollections.observableList(movies.stream().filter(samplemovie ->
                samplemovie.getGenres().contains(genre)).collect(Collectors.toList()));
        return moviesGenres;
    }

    public List<Movie> filterMovies(List<Movie> movies, String txt){

        List<Movie> movieList = new ArrayList<>();
        for (Movie movie : movies){
            if (movie.getTitle().toLowerCase().contains(txt) || movie.getDescription().toLowerCase().contains(txt)){
                movieList.add(movie);
            }
        }
        return movieList;
    }

    //comparator for movie with title
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