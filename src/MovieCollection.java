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
        System.out.println(movies);
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
        System.out.println("Welcome to the movie collection!");
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Search for a Movie: ");
        String search = scan.nextLine();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().contains(search)) {
                System.out.println(movies.get(i).getTitle());
            }
        }
    }
}
