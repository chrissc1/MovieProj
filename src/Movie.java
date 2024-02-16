import java.util.Optional;

public class Movie {
    private String title;
    private String cast;
    private String director;
    private String overview;
    private int runtime;
    private double userRating;

    public Movie(String title, String cast, String director, String overview, int runtime, double userRating) {
        this.title = title;
        this.cast = cast;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.userRating = userRating;
    }

    public double getUserRating() {
        return userRating;
    }

    public String getCast() {
        return cast;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getDirector() {
        return director;
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title;
    }
}
