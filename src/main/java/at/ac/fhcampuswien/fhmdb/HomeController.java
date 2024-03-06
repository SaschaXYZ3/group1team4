package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
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

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

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
        searchBtn.setOnAction(actionEvent -> {
            String txt = searchField.getText().toLowerCase();

            if (txt == null || txt.isEmpty()) {
                return;
            }
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.addAll(filterMovies(allMovies, txt));

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
            if(sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                sortBtn.setText("Sort (desc)");
            } else {
                // TODO sort observableMovies descending
                sortBtn.setText("Sort (asc)");
            }
        });


    }


    public static List<Movie> filteredListByGenre(List<Movie> movies, Genre genre){

        List<Movie> MoviesGenres = movies.stream().filter(a -> Objects.equals(a.getGenres(), genre)).collect(Collectors.toList());

        return MoviesGenres;
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
}