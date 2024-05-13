package films;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Film> films = List.of(
                new Film("The Shawshank Redemption", 1994, 9.3),
                new Film("The Godfather", 1972, 9.2),
                new Film("The Dark Knight", 2008, 9.0),
                new Film("The Godfather Part II", 1974, 9.0),
                new Film("12 Angry Men", 1957, 9.0),
                new Film("Schindler's List", 1993, 9.0),
                new Film("The Lord of the Rings: The Return of the King", 2003, 9.0),
                new Film("Pulp Fiction", 1994, 8.9),
                new Film("The Lord of the Rings: The Fellowship of the Ring", 2001, 8.9),
                new Film("The Good, the Bad and the Ugly", 1966, 8.8)
        );

        FilmLibrary filmLibrary = new FilmLibrary(films);

        boolean areRatingsCorrect = filmLibrary.areFilmRatingsCorrect();
        System.out.println("Рейтинг всех фильмов корректен: " + areRatingsCorrect);

        double ratingThreshold = 9.0;
        List<String> filmNames = filmLibrary.getFilmNames(ratingThreshold);
        System.out.println(String.format("Названия фильмов с рейтингом выше %s: %s", ratingThreshold, filmNames));

        int year = 1994;
        double averageRating = filmLibrary.getAverageFilmRating(year);
        System.out.println(String.format("Средний рейтинг фильмов за %s год: %s", year, averageRating));

        year = 2008;
        List<Film> filteredFilms = filmLibrary.filter(year);
        System.out.println(String.format("Фильмы, вышедшие в %s году: %s", year, filteredFilms));

        int startYear = 2001;
        int endYear = 2005;
        filteredFilms = filmLibrary.filter(startYear, endYear);
        System.out.println(String.format("Фильмы, вышедшие в %s-%s годах: %s", startYear, endYear, filteredFilms));

        List<Film> sortedFilms = filmLibrary.sort();
        System.out.println("Отсортированный список фильмов: " + sortedFilms);
    }
}
