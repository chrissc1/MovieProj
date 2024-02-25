import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MovieCollection {
    private ArrayList<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
        loadWordsInto();
        mainMenu();
    }

    public void loadWordsInto() {
        try {
            File myFile = new File("src\\movies_data.csv");
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");
                String title = splitData[0];
                String cast = splitData[1];
                String director = splitData[2];
                String overview = splitData[3];
                int runtime = Integer.parseInt(splitData[4]);
                double userRating = Double.parseDouble(splitData[5]);
                Movie s = new Movie(title, cast, director, overview, runtime, userRating);
                movies.add(s);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void mainMenu() {
        String menuOption = "";

        Scanner scanner = new Scanner(System.in);
        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scanner.nextLine();


            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }

    }

    private void searchTitles() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter part of a title: ");
        String search = scanner.nextLine().trim().toLowerCase();
        ArrayList <Movie> moviesNew = new ArrayList<>();
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(search)) {
                System.out.println(movie.getTitle());
                found = true;
                moviesNew.add(movie);
            }
        }
        if (found) {
            System.out.println("Which movie do you want to learn more about?");
            int movieInt = scanner.nextInt() - 1;
            System.out.println("Title: " + moviesNew.get(movieInt).getTitle());
            System.out.println("Runtime: " + moviesNew.get(movieInt).getRuntime());
            System.out.println("Director: " + moviesNew.get(movieInt).getDirector());
            System.out.println("Cast: " + moviesNew.get(movieInt).getCast());
            System.out.println("Overview: " + moviesNew.get(movieInt).getOverview());
            System.out.println("User Rating: " + moviesNew.get(movieInt).getUserRating());
        }
        if (!found) {
            System.out.println("No matching movies found.");
        }
        mainMenu();
    }

    private void searchCast() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter part of a cast member's name: ");
        String search = scanner.nextLine().trim().toLowerCase();
        ArrayList <String> casts = new ArrayList<>();
        boolean found = false;
        for (Movie movie : movies) {
            String[] castMembers = movie.getCast().split("\\|");
            for (String castMember : castMembers) {
                if (castMember.toLowerCase().contains(search)) {
                    System.out.println(castMember);
                    found = true;
                    casts.add(castMember);
                }
            }
        }
        if (found) {
            System.out.println("Which actor do you want to see all movies for?");
            int castmemebr = scanner.nextInt() - 1;
            for (Movie movie1 : movies) {
                if (movie1.getCast().contains(casts.get(castmemebr))) {
                    System.out.println(movie1.getTitle());
                }
            }
        }
        if (!found) {
            System.out.println("No matching cast members found.");
        }
    }
}
