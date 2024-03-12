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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
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

        // initialize UI
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll(Genre.values());

        searchBtn.setOnAction(ActionEvent -> {

            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.addAll(allMovies);

            String txt = searchField.getText().toLowerCase();

            if (!txt.isEmpty() && !genreComboBox.getSelectionModel().isEmpty()) {
                movieListView.setItems(filteredListByString(filteredListByGenre(observableMovies, Genre.valueOf(genreComboBox.getValue().toString())), txt));
            }else if (txt.isEmpty() && !genreComboBox.getSelectionModel().isEmpty()) {
                movieListView.setItems(filteredListByGenre(observableMovies, Genre.valueOf(genreComboBox.getValue().toString())));

            } else if (txt.isEmpty() && genreComboBox.getSelectionModel().isEmpty()){
                observableMovies.addAll(allMovies);
            } else if(!txt.isEmpty() && genreComboBox.getSelectionModel().isEmpty()){
                movieListView.setItems(filteredListByString(observableMovies, txt));
            }
        });

        clearBtn.setOnAction(event -> {
            searchField.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.clear();
            movieListView.setCellFactory(movieListView -> new MovieCell());
            observableMovies.addAll(allMovies);

            genreComboBox.setValue(null);
            movieListView.setItems(observableMovies);
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
    public ObservableList<Movie> filteredListByGenre(ObservableList<Movie> movies, Genre genre) {
        ObservableList<Movie> moviesGenres = FXCollections.observableList(movies.stream().filter(samplemovie ->
                samplemovie.getGenres().contains(genre)).collect(Collectors.toList()));
        if (genre == null){
            moviesGenres = observableMovies;
        }
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
        return movies;
    }

    public ObservableList<Movie> sortDescending(ObservableList<Movie> movies) {
        movies.sort(movieComp.reversed());
        // update sort button with text
        if (sortBtn != null) {
            sortBtn.setText("Sort (asc)");
        }
        return movies;
    }
}