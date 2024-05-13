package films;

import java.util.List;
import java.util.stream.Collectors;

public class FilmLibrary {

    private final List<Film> films;

    public FilmLibrary(List<Film> films) {
        this.films = films;
    }

    public boolean areFilmRatingsCorrect() {
        return films.stream().allMatch(Film::isRatingCorrect);
    }

    public List<String> getFilmNames(double ratingThreshold) {
        return films.stream()
                .filter(film -> film.getRating() >= ratingThreshold)
                .map(Film::getName)
                .collect(Collectors.toList());
    }

    public double getAverageFilmRating(int year) {
        return films.stream()
                .filter(film -> film.getYear() == year)
                .mapToDouble(Film::getRating)
                .average()
                .orElse(0);
    }

    public List<Film> filter(int year) {
        return films.stream()
                .filter(film -> film.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Film> filter(int startYear, int endYear) {
        return films.stream()
                .filter(film -> film.getYear() >= startYear)
                .filter(film -> film.getYear() <= endYear)
                .collect(Collectors.toList());
    }

    public List<Film> sort() {
        return films.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
