package com.aurionpro.compare.moviefare;
import java.util.Comparator;

public class MovieComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        // Sort by year descending
        int yearCompare = Integer.compare(m2.getYear(), m1.getYear());
        if (yearCompare != 0) {
            return yearCompare;
        }
        // If years are equal, sort by title ascending
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}