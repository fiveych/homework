package films;

import java.util.Objects;

public class Film implements Comparable<Film> {

    private final String name;
    private final int year;
    private final double rating;

    public Film(String name, int year, double rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public boolean isRatingCorrect() {
        final double minRating = 0.0;
        final double maxRating = 10.0;
        return rating >= minRating && rating <= maxRating;
    }

    @Override
    public int compareTo(Film film) {

        int yearComparison = Integer.compare(year, film.year);
        if (yearComparison != 0) {
            return yearComparison;
        }

        return name.compareTo(film.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return year == film.year && Double.compare(rating, film.rating) == 0 && Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, rating);
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
